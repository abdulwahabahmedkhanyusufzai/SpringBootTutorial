import grpc
import time
import state_coordinator_pb2
import state_coordinator_pb2_grpc
from google.adk.agents import Agent
from google.adk.tools import FunctionTool

# 1. Define a real Google ADK Tool
def knowledge_graph_update(data: str):
    """Simulates updating a shared Knowledge Graph on Google Cloud."""
    return f"Successfully updated Knowledge Graph with: {data}"

# 2. Setup the ADK Agent
adk_agent = Agent(
    name="DeepMind_Researcher",
    instruction="Process data only when the Coordinator grants access.",
    tools=[FunctionTool(knowledge_graph_update)]
)

def run_agent(agent_id):
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = state_coordinator_pb2_grpc.StateCoordinatorStub(channel)
        print(f"🚀 Google ADK Agent {agent_id} is online...")

        lock_request = state_coordinator_pb2.LockRequest(
            agent_id=agent_id, 
            resource_id="knowledge-graph-lock"
        )
        
        try:
            lock_response = stub.AcquireLock(lock_request)
            if lock_response.success:
                print(f"🔒 LOCK GRANTED. Triggering Google ADK...")
                
                # REAL WORK: Use the Google ADK Agent here
                result = adk_agent.run("Update graph with 'New JAX Model Metadata'")
                print(f"🤖 ADK Response: {result.text}")
                
                time.sleep(3) # Hold lock briefly to show collision in logs
                stub.ReleaseLock(lock_request)
                print("🔓 Work complete. Lock released.")
            else:
                print("❌ ACCESS DENIED: Another ADK Agent is using the Knowledge Graph.")
        except grpc.RpcError as e:
            print(f"⚠️ Coordinator Error: {e.code()}")

        # Heartbeat Loop continues...
        while True:
            try:
                request = state_coordinator_pb2.HeartBeatRequest(
                    agent_id=agent_id,
                    current_task="ADK Idle",
                    load_percentage=5.0
                )
                stub.SendHeartbeat(request)
                time.sleep(2)
            except grpc.RpcError:
                time.sleep(3)

if __name__ == "__main__":
    # Run Agent 01 in Terminal A and Agent 02 in Terminal B
    run_agent("PYTHON_WORKER_01")