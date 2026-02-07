import grpc
import time
import state_coordinator_pb2
import state_coordinator_pb2_grpc

def run_agent(agent_id):
    # Connect to the Java Spring Boot server
    # Port 9090 is the default for the gRPC Spring Boot starter
    with grpc.insecure_channel('localhost:9090') as channel:
        # Create the 'Stub' (this is your client-side bridge)
        stub = state_coordinator_pb2_grpc.StateCoordinatorStub(channel)
        
        print(f"🚀 Agent {agent_id} is online and looking for Coordinator...")
        
        while True:
            try:
                # Prepare the Heartbeat Data
                request = state_coordinator_pb2.HeartBeatRequest(
                    agent_id=agent_id,
                    current_task="Optimizing Knowledge Graph",
                    load_percentage=22.5
                )
                
                # Make the RPC call to the Java Server
                response = stub.SendHeartbeat(request)
                
                if response.acknowledged:
                    print(f"✅ Coordinator Ack: Command = {response.command}")
                
            except grpc.RpcError as e:
                # If Java server is down, this prevents the Python script from crashing
                print(f"⚠️ Coordinator offline (Status: {e.code()}). Retrying in 5s...")
                time.sleep(3) # Wait a bit longer if there's an error

            time.sleep(2) # Normal heartbeat interval

if __name__ == "__main__":
    # You can change this ID for different workers
    run_agent("PYTHON_WORKER_01")