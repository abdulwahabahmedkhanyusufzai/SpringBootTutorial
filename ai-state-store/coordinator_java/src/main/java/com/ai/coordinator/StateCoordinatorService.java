package com.ai.coordinator;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public  class StateCoordinatorService extends  StateCoordinatorGrpc.StateCoordinatorImplBase{
    private final Map<String,Instant> agentRegistry = new ConcurrentHashMap<>();

    @Override
    public void sendHeartbeat(HeartBeatRequest request,StreamObserver<HeartBeatResponse> responseObserver){
        String agentId = request.getAgentId();
        String task = request.getCurrentTask();

        agentRegistry.put(agentId, Instant.now());
        System.out.println("LOG: Heartbeat from [" + agentId + "] performing [" + task + "]");

        HeartBeatResponse response = HeartBeatResponse.newBuilder()
        .setAcknowledged(true)
                .setCommand("CONTINUE")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void acquireLock(LockRequest request, StreamObserver<LockResponse> responseObserver) {
        // We will implement the Raft-based locking logic in the next step
        LockResponse response = LockResponse.newBuilder()
                .setSuccess(true)
                .setLockToken("LOCK-" + request.getAgentId() + "-" + System.currentTimeMillis())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}