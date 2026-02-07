package com.ai.coordinator;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: state_coordinator.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StateCoordinatorGrpc {

  private StateCoordinatorGrpc() {}

  public static final java.lang.String SERVICE_NAME = "coordinator.StateCoordinator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ai.coordinator.HeartBeatRequest,
      com.ai.coordinator.HeartBeatResponse> getSendHeartbeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendHeartbeat",
      requestType = com.ai.coordinator.HeartBeatRequest.class,
      responseType = com.ai.coordinator.HeartBeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ai.coordinator.HeartBeatRequest,
      com.ai.coordinator.HeartBeatResponse> getSendHeartbeatMethod() {
    io.grpc.MethodDescriptor<com.ai.coordinator.HeartBeatRequest, com.ai.coordinator.HeartBeatResponse> getSendHeartbeatMethod;
    if ((getSendHeartbeatMethod = StateCoordinatorGrpc.getSendHeartbeatMethod) == null) {
      synchronized (StateCoordinatorGrpc.class) {
        if ((getSendHeartbeatMethod = StateCoordinatorGrpc.getSendHeartbeatMethod) == null) {
          StateCoordinatorGrpc.getSendHeartbeatMethod = getSendHeartbeatMethod =
              io.grpc.MethodDescriptor.<com.ai.coordinator.HeartBeatRequest, com.ai.coordinator.HeartBeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendHeartbeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ai.coordinator.HeartBeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ai.coordinator.HeartBeatResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StateCoordinatorMethodDescriptorSupplier("SendHeartbeat"))
              .build();
        }
      }
    }
    return getSendHeartbeatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ai.coordinator.LockRequest,
      com.ai.coordinator.LockResponse> getAcquireLockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcquireLock",
      requestType = com.ai.coordinator.LockRequest.class,
      responseType = com.ai.coordinator.LockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ai.coordinator.LockRequest,
      com.ai.coordinator.LockResponse> getAcquireLockMethod() {
    io.grpc.MethodDescriptor<com.ai.coordinator.LockRequest, com.ai.coordinator.LockResponse> getAcquireLockMethod;
    if ((getAcquireLockMethod = StateCoordinatorGrpc.getAcquireLockMethod) == null) {
      synchronized (StateCoordinatorGrpc.class) {
        if ((getAcquireLockMethod = StateCoordinatorGrpc.getAcquireLockMethod) == null) {
          StateCoordinatorGrpc.getAcquireLockMethod = getAcquireLockMethod =
              io.grpc.MethodDescriptor.<com.ai.coordinator.LockRequest, com.ai.coordinator.LockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AcquireLock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ai.coordinator.LockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ai.coordinator.LockResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StateCoordinatorMethodDescriptorSupplier("AcquireLock"))
              .build();
        }
      }
    }
    return getAcquireLockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ai.coordinator.LockRequest,
      com.ai.coordinator.LockResponse> getReleaseLockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReleaseLock",
      requestType = com.ai.coordinator.LockRequest.class,
      responseType = com.ai.coordinator.LockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ai.coordinator.LockRequest,
      com.ai.coordinator.LockResponse> getReleaseLockMethod() {
    io.grpc.MethodDescriptor<com.ai.coordinator.LockRequest, com.ai.coordinator.LockResponse> getReleaseLockMethod;
    if ((getReleaseLockMethod = StateCoordinatorGrpc.getReleaseLockMethod) == null) {
      synchronized (StateCoordinatorGrpc.class) {
        if ((getReleaseLockMethod = StateCoordinatorGrpc.getReleaseLockMethod) == null) {
          StateCoordinatorGrpc.getReleaseLockMethod = getReleaseLockMethod =
              io.grpc.MethodDescriptor.<com.ai.coordinator.LockRequest, com.ai.coordinator.LockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReleaseLock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ai.coordinator.LockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ai.coordinator.LockResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StateCoordinatorMethodDescriptorSupplier("ReleaseLock"))
              .build();
        }
      }
    }
    return getReleaseLockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StateCoordinatorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StateCoordinatorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StateCoordinatorStub>() {
        @java.lang.Override
        public StateCoordinatorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StateCoordinatorStub(channel, callOptions);
        }
      };
    return StateCoordinatorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StateCoordinatorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StateCoordinatorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StateCoordinatorBlockingStub>() {
        @java.lang.Override
        public StateCoordinatorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StateCoordinatorBlockingStub(channel, callOptions);
        }
      };
    return StateCoordinatorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StateCoordinatorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StateCoordinatorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StateCoordinatorFutureStub>() {
        @java.lang.Override
        public StateCoordinatorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StateCoordinatorFutureStub(channel, callOptions);
        }
      };
    return StateCoordinatorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void sendHeartbeat(com.ai.coordinator.HeartBeatRequest request,
        io.grpc.stub.StreamObserver<com.ai.coordinator.HeartBeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendHeartbeatMethod(), responseObserver);
    }

    /**
     */
    default void acquireLock(com.ai.coordinator.LockRequest request,
        io.grpc.stub.StreamObserver<com.ai.coordinator.LockResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAcquireLockMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;-- Add this line
     * </pre>
     */
    default void releaseLock(com.ai.coordinator.LockRequest request,
        io.grpc.stub.StreamObserver<com.ai.coordinator.LockResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReleaseLockMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StateCoordinator.
   */
  public static abstract class StateCoordinatorImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StateCoordinatorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StateCoordinator.
   */
  public static final class StateCoordinatorStub
      extends io.grpc.stub.AbstractAsyncStub<StateCoordinatorStub> {
    private StateCoordinatorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StateCoordinatorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StateCoordinatorStub(channel, callOptions);
    }

    /**
     */
    public void sendHeartbeat(com.ai.coordinator.HeartBeatRequest request,
        io.grpc.stub.StreamObserver<com.ai.coordinator.HeartBeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendHeartbeatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void acquireLock(com.ai.coordinator.LockRequest request,
        io.grpc.stub.StreamObserver<com.ai.coordinator.LockResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcquireLockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;-- Add this line
     * </pre>
     */
    public void releaseLock(com.ai.coordinator.LockRequest request,
        io.grpc.stub.StreamObserver<com.ai.coordinator.LockResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReleaseLockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StateCoordinator.
   */
  public static final class StateCoordinatorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StateCoordinatorBlockingStub> {
    private StateCoordinatorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StateCoordinatorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StateCoordinatorBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ai.coordinator.HeartBeatResponse sendHeartbeat(com.ai.coordinator.HeartBeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendHeartbeatMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ai.coordinator.LockResponse acquireLock(com.ai.coordinator.LockRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcquireLockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;-- Add this line
     * </pre>
     */
    public com.ai.coordinator.LockResponse releaseLock(com.ai.coordinator.LockRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReleaseLockMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StateCoordinator.
   */
  public static final class StateCoordinatorFutureStub
      extends io.grpc.stub.AbstractFutureStub<StateCoordinatorFutureStub> {
    private StateCoordinatorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StateCoordinatorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StateCoordinatorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ai.coordinator.HeartBeatResponse> sendHeartbeat(
        com.ai.coordinator.HeartBeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendHeartbeatMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ai.coordinator.LockResponse> acquireLock(
        com.ai.coordinator.LockRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcquireLockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;-- Add this line
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ai.coordinator.LockResponse> releaseLock(
        com.ai.coordinator.LockRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReleaseLockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_HEARTBEAT = 0;
  private static final int METHODID_ACQUIRE_LOCK = 1;
  private static final int METHODID_RELEASE_LOCK = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_HEARTBEAT:
          serviceImpl.sendHeartbeat((com.ai.coordinator.HeartBeatRequest) request,
              (io.grpc.stub.StreamObserver<com.ai.coordinator.HeartBeatResponse>) responseObserver);
          break;
        case METHODID_ACQUIRE_LOCK:
          serviceImpl.acquireLock((com.ai.coordinator.LockRequest) request,
              (io.grpc.stub.StreamObserver<com.ai.coordinator.LockResponse>) responseObserver);
          break;
        case METHODID_RELEASE_LOCK:
          serviceImpl.releaseLock((com.ai.coordinator.LockRequest) request,
              (io.grpc.stub.StreamObserver<com.ai.coordinator.LockResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendHeartbeatMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.ai.coordinator.HeartBeatRequest,
              com.ai.coordinator.HeartBeatResponse>(
                service, METHODID_SEND_HEARTBEAT)))
        .addMethod(
          getAcquireLockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.ai.coordinator.LockRequest,
              com.ai.coordinator.LockResponse>(
                service, METHODID_ACQUIRE_LOCK)))
        .addMethod(
          getReleaseLockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.ai.coordinator.LockRequest,
              com.ai.coordinator.LockResponse>(
                service, METHODID_RELEASE_LOCK)))
        .build();
  }

  private static abstract class StateCoordinatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StateCoordinatorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ai.coordinator.StateCoordinatorOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StateCoordinator");
    }
  }

  private static final class StateCoordinatorFileDescriptorSupplier
      extends StateCoordinatorBaseDescriptorSupplier {
    StateCoordinatorFileDescriptorSupplier() {}
  }

  private static final class StateCoordinatorMethodDescriptorSupplier
      extends StateCoordinatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StateCoordinatorMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StateCoordinatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StateCoordinatorFileDescriptorSupplier())
              .addMethod(getSendHeartbeatMethod())
              .addMethod(getAcquireLockMethod())
              .addMethod(getReleaseLockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
