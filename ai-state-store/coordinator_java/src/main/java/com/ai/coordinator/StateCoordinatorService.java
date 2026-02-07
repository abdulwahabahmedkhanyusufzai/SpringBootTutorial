package com.ai.coordinator;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class StateCoordinatorService extends StateCoordinatorGrpc.StateCoordinatorImplBase {

    @Autowired
    private StringRedisTemplate redis; // This is your bridge to Redis

    @Override
    public void sendHeartbeat(HeartBeatRequest request, StreamObserver<HeartBeatResponse> responseObserver) {
        String agentId = request.getAgentId();
        
        // MAANG MOVE: Set key with a 10-second expiration (TTL)
        // This effectively replaces your manual monitorHealth logic.
        redis.opsForValue().set("agent:" + agentId, "ONLINE", 10, TimeUnit.SECONDS);
        
        System.out.println("LOG: Heartbeat from [" + agentId + "] synced to Redis.");

        HeartBeatResponse response = HeartBeatResponse.newBuilder()
                .setAcknowledged(true)
                .setCommand("CONTINUE")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void acquireLock(LockRequest request, StreamObserver<LockResponse> responseObserver) {
        String resourceId = "lock:" + request.getResourceId();
        String agentId = request.getAgentId();

        String currentOwner = redis.opsForValue().get(resourceId);
        boolean released = false;
        if (currentOwner == null) {
        // The lock already expired or was released by someone else
        System.out.println("ℹ️ INFO: Lock [" + resourceId + "] was already empty (likely expired).");
        released = true;
        }else if (agentId.equals(currentOwner)) {
            redis.delete(resourceId);
            released = true;
           System.out.println("🔓 LOCK RELEASED: [" + agentId + "] freed [" + resourceId + "]");
        } else {
            System.out.println("⚠️ RELEASE DENIED: [" + agentId + "] tried to release [" + resourceId + "] but it belongs to [" + currentOwner + "]");
        }

        LockResponse response = LockResponse.newBuilder()
                .setSuccess(Boolean.TRUE.equals(released))
                .setLockToken(Boolean.TRUE.equals(released) ? "REDIS-TOKEN-" + System.currentTimeMillis() : "")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}