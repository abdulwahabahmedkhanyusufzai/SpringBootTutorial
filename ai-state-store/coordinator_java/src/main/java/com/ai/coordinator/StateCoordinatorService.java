package com.ai.coordinator;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.scheduling.annotation.Scheduled;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public  class StateCoordinatorService extends  StateCoordinatorGrpc.StateCoordinatorImplBase{
    class AgentInfo{
        Instant lastSeen;
        String status;

        AgentInfo(Instant lastSeen) {
           this.lastSeen = lastSeen;
           this.status = "ONLINE";
        }
        
    }
    private final Map<String,AgentInfo> agentRegistry = new ConcurrentHashMap<>();

    @Override
    public void sendHeartbeat(HeartBeatRequest request,StreamObserver<HeartBeatResponse> responseObserver){
        String agentId = request.getAgentId();
        String task = request.getCurrentTask();

        agentRegistry.put(agentId,new AgentInfo(Instant.now()));
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
    
    @Scheduled(fixedRate=5000)
    public void monitorHealth(){
        Instant timeoutThresHold = Instant.now().minusSeconds(10);

        agentRegistry.forEach((id,info) -> {
            if(info.lastSeen.isBefore(timeoutThresHold) && info.status.equals("ONLINE")){
                info.status = "OFFLINE";
                System.err.println("🚨 ALERT: Agent [" + id + "] is now OFFLINE. (Last seen: " + info.lastSeen + ")");
            }
        });
    }

        
    }
