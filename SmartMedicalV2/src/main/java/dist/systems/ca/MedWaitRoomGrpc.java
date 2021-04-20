package dist.systems.ca;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: smartMedWaitRoom.proto")
public final class MedWaitRoomGrpc {

  private MedWaitRoomGrpc() {}

  public static final String SERVICE_NAME = "MedWaitRoom";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dist.systems.ca.WaitingRoomEntry,
      dist.systems.ca.WaitTimeReply> getWaitingTimerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WaitingTimerStream",
      requestType = dist.systems.ca.WaitingRoomEntry.class,
      responseType = dist.systems.ca.WaitTimeReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<dist.systems.ca.WaitingRoomEntry,
      dist.systems.ca.WaitTimeReply> getWaitingTimerStreamMethod() {
    io.grpc.MethodDescriptor<dist.systems.ca.WaitingRoomEntry, dist.systems.ca.WaitTimeReply> getWaitingTimerStreamMethod;
    if ((getWaitingTimerStreamMethod = MedWaitRoomGrpc.getWaitingTimerStreamMethod) == null) {
      synchronized (MedWaitRoomGrpc.class) {
        if ((getWaitingTimerStreamMethod = MedWaitRoomGrpc.getWaitingTimerStreamMethod) == null) {
          MedWaitRoomGrpc.getWaitingTimerStreamMethod = getWaitingTimerStreamMethod = 
              io.grpc.MethodDescriptor.<dist.systems.ca.WaitingRoomEntry, dist.systems.ca.WaitTimeReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "MedWaitRoom", "WaitingTimerStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dist.systems.ca.WaitingRoomEntry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dist.systems.ca.WaitTimeReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MedWaitRoomMethodDescriptorSupplier("WaitingTimerStream"))
                  .build();
          }
        }
     }
     return getWaitingTimerStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MedWaitRoomStub newStub(io.grpc.Channel channel) {
    return new MedWaitRoomStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MedWaitRoomBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MedWaitRoomBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MedWaitRoomFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MedWaitRoomFutureStub(channel);
  }

  /**
   */
  public static abstract class MedWaitRoomImplBase implements io.grpc.BindableService {

    /**
     */
    public void waitingTimerStream(dist.systems.ca.WaitingRoomEntry request,
        io.grpc.stub.StreamObserver<dist.systems.ca.WaitTimeReply> responseObserver) {
      asyncUnimplementedUnaryCall(getWaitingTimerStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWaitingTimerStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                dist.systems.ca.WaitingRoomEntry,
                dist.systems.ca.WaitTimeReply>(
                  this, METHODID_WAITING_TIMER_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class MedWaitRoomStub extends io.grpc.stub.AbstractStub<MedWaitRoomStub> {
    private MedWaitRoomStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MedWaitRoomStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MedWaitRoomStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MedWaitRoomStub(channel, callOptions);
    }

    /**
     */
    public void waitingTimerStream(dist.systems.ca.WaitingRoomEntry request,
        io.grpc.stub.StreamObserver<dist.systems.ca.WaitTimeReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getWaitingTimerStreamMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MedWaitRoomBlockingStub extends io.grpc.stub.AbstractStub<MedWaitRoomBlockingStub> {
    private MedWaitRoomBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MedWaitRoomBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MedWaitRoomBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MedWaitRoomBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<dist.systems.ca.WaitTimeReply> waitingTimerStream(
        dist.systems.ca.WaitingRoomEntry request) {
      return blockingServerStreamingCall(
          getChannel(), getWaitingTimerStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MedWaitRoomFutureStub extends io.grpc.stub.AbstractStub<MedWaitRoomFutureStub> {
    private MedWaitRoomFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MedWaitRoomFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MedWaitRoomFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MedWaitRoomFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_WAITING_TIMER_STREAM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MedWaitRoomImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MedWaitRoomImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WAITING_TIMER_STREAM:
          serviceImpl.waitingTimerStream((dist.systems.ca.WaitingRoomEntry) request,
              (io.grpc.stub.StreamObserver<dist.systems.ca.WaitTimeReply>) responseObserver);
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

  private static abstract class MedWaitRoomBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MedWaitRoomBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dist.systems.ca.SmartMedWaitRoom.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MedWaitRoom");
    }
  }

  private static final class MedWaitRoomFileDescriptorSupplier
      extends MedWaitRoomBaseDescriptorSupplier {
    MedWaitRoomFileDescriptorSupplier() {}
  }

  private static final class MedWaitRoomMethodDescriptorSupplier
      extends MedWaitRoomBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MedWaitRoomMethodDescriptorSupplier(String methodName) {
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
      synchronized (MedWaitRoomGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MedWaitRoomFileDescriptorSupplier())
              .addMethod(getWaitingTimerStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
