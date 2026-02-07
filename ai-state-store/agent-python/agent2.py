import grpc
import time
import state_coordinator_pb2
import state_coordinator_pb2_grpc
from google.adk.agents import Agent
from google.adk.tools import FunctionTool

# 1. Define the tool with a clear docstring (required for ADK)
def knowledge_graph_validation(data: str):
    """
    Validates and updates the Knowledge Graph metadata.
    Args:
        data: The metadata string to validate.
    """
    return f"Validator processed: {data}"

# 2. Setup the ADK Agent (Fixed for Pydantic)
# Note: 'name' uses underscores, 'instruction' is singular
adk_agent = Agent(
    name="Model_Validator_02",
    model="gemini-1.5-flash", 
    instruction="Verify model integrity only when the Coordinator grants access.",
    tools=[FunctionTool(knowledge_graph_validation)]
)

def run_agent(agent_id):
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = state_coordinator_pb2_grpc.StateCoordinatorStub(channel)
        
        print(f"🚀 Agent {agent_id} is online and looking for Coordinator...")

        # 1. ATTEMPT TO ACQUIRE LOCK
        lock_request = state_coordinator_pb2.LockRequest(
            agent_id=agent_id, 
            resource_id="pinecone-index-alpha"
        )
        
        try:
            lock_response = stub.AcquireLock(lock_request)
            if lock_response.success:
                print("🔒 I HAVE THE LOCK! Triggering Google ADK Validation...")
                
                # Use the ADK Agent
                result = adk_agent.run("Validate JAX Metadata Batch A-12")
                print(f"🤖 ADK Response: {result.text}")
                
                time.sleep(5) # Simulate validation work

                stub.ReleaseLock(lock_request)
                print("🔓 Work complete. Lock released.")
            else:
                print("❌ ACCESS DENIED: Worker 01 is currently using the index.")
        except grpc.RpcError as e:
            print(f"⚠️ Failed to reach Coordinator: {e.code()}")

        # 2. START HEARTBEAT LOOP
        while True:
            try:
                request = state_coordinator_pb2.HeartBeatRequest(
                    agent_id=agent_id,
                    current_task="Validator Idle",
                    load_percentage=10.5
                )
                response = stub.SendHeartbeat(request)
                if response.acknowledged:
                    print(f"✅ Heartbeat Ack: {response.command}")
            except grpc.RpcError:
                print(f"⚠️ Coordinator offline. Retrying...")
                time.sleep(3)
            time.sleep(2)

if __name__ == "__main__":
    # Ensure this is unique so Java/Redis can track both simultaneously
    run_agent("PYTHON_WORKER_02")