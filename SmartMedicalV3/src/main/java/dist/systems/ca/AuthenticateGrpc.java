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
    comments = "Source: smartMedAuthenticate.proto")
public final class AuthenticateGrpc {

  private AuthenticateGrpc() {}

  public static final String SERVICE_NAME = "Authenticate";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dist.systems.ca.CheckInRequest,
      dist.systems.ca.CheckInReply> getCheckInMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckIn",
      requestType = dist.systems.ca.CheckInRequest.class,
      responseType = dist.systems.ca.CheckInReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dist.systems.ca.CheckInRequest,
      dist.systems.ca.CheckInReply> getCheckInMethod() {
    io.grpc.MethodDescriptor<dist.systems.ca.CheckInRequest, dist.systems.ca.CheckInReply> getCheckInMethod;
    if ((getCheckInMethod = AuthenticateGrpc.getCheckInMethod) == null) {
      synchronized (AuthenticateGrpc.class) {
        if ((getCheckInMethod = AuthenticateGrpc.getCheckInMethod) == null) {
          AuthenticateGrpc.getCheckInMethod = getCheckInMethod = 
              io.grpc.MethodDescriptor.<dist.systems.ca.CheckInRequest, dist.systems.ca.CheckInReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Authenticate", "CheckIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dist.systems.ca.CheckInRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dist.systems.ca.CheckInReply.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthenticateMethodDescriptorSupplier("CheckIn"))
                  .build();
          }
        }
     }
     return getCheckInMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dist.systems.ca.CheckOutRequest,
      dist.systems.ca.CheckOutReply> getCheckOutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckOut",
      requestType = dist.systems.ca.CheckOutRequest.class,
      responseType = dist.systems.ca.CheckOutReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dist.systems.ca.CheckOutRequest,
      dist.systems.ca.CheckOutReply> getCheckOutMethod() {
    io.grpc.MethodDescriptor<dist.systems.ca.CheckOutRequest, dist.systems.ca.CheckOutReply> getCheckOutMethod;
    if ((getCheckOutMethod = AuthenticateGrpc.getCheckOutMethod) == null) {
      synchronized (AuthenticateGrpc.class) {
        if ((getCheckOutMethod = AuthenticateGrpc.getCheckOutMethod) == null) {
          AuthenticateGrpc.getCheckOutMethod = getCheckOutMethod = 
              io.grpc.MethodDescriptor.<dist.systems.ca.CheckOutRequest, dist.systems.ca.CheckOutReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Authenticate", "CheckOut"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dist.systems.ca.CheckOutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dist.systems.ca.CheckOutReply.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthenticateMethodDescriptorSupplier("CheckOut"))
                  .build();
          }
        }
     }
     return getCheckOutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthenticateStub newStub(io.grpc.Channel channel) {
    return new AuthenticateStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthenticateBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AuthenticateBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthenticateFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuthenticateFutureStub(channel);
  }

  /**
   */
  public static abstract class AuthenticateImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkIn(dist.systems.ca.CheckInRequest request,
        io.grpc.stub.StreamObserver<dist.systems.ca.CheckInReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckInMethod(), responseObserver);
    }

    /**
     */
    public void checkOut(dist.systems.ca.CheckOutRequest request,
        io.grpc.stub.StreamObserver<dist.systems.ca.CheckOutReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckOutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckInMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                dist.systems.ca.CheckInRequest,
                dist.systems.ca.CheckInReply>(
                  this, METHODID_CHECK_IN)))
          .addMethod(
            getCheckOutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                dist.systems.ca.CheckOutRequest,
                dist.systems.ca.CheckOutReply>(
                  this, METHODID_CHECK_OUT)))
          .build();
    }
  }

  /**
   */
  public static final class AuthenticateStub extends io.grpc.stub.AbstractStub<AuthenticateStub> {
    private AuthenticateStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthenticateStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticateStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthenticateStub(channel, callOptions);
    }

    /**
     */
    public void checkIn(dist.systems.ca.CheckInRequest request,
        io.grpc.stub.StreamObserver<dist.systems.ca.CheckInReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckInMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkOut(dist.systems.ca.CheckOutRequest request,
        io.grpc.stub.StreamObserver<dist.systems.ca.CheckOutReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckOutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthenticateBlockingStub extends io.grpc.stub.AbstractStub<AuthenticateBlockingStub> {
    private AuthenticateBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthenticateBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticateBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthenticateBlockingStub(channel, callOptions);
    }

    /**
     */
    public dist.systems.ca.CheckInReply checkIn(dist.systems.ca.CheckInRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckInMethod(), getCallOptions(), request);
    }

    /**
     */
    public dist.systems.ca.CheckOutReply checkOut(dist.systems.ca.CheckOutRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckOutMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthenticateFutureStub extends io.grpc.stub.AbstractStub<AuthenticateFutureStub> {
    private AuthenticateFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthenticateFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticateFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthenticateFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dist.systems.ca.CheckInReply> checkIn(
        dist.systems.ca.CheckInRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckInMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dist.systems.ca.CheckOutReply> checkOut(
        dist.systems.ca.CheckOutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckOutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_IN = 0;
  private static final int METHODID_CHECK_OUT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthenticateImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthenticateImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_IN:
          serviceImpl.checkIn((dist.systems.ca.CheckInRequest) request,
              (io.grpc.stub.StreamObserver<dist.systems.ca.CheckInReply>) responseObserver);
          break;
        case METHODID_CHECK_OUT:
          serviceImpl.checkOut((dist.systems.ca.CheckOutRequest) request,
              (io.grpc.stub.StreamObserver<dist.systems.ca.CheckOutReply>) responseObserver);
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

  private static abstract class AuthenticateBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthenticateBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dist.systems.ca.SmartMedAuthenticate.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Authenticate");
    }
  }

  private static final class AuthenticateFileDescriptorSupplier
      extends AuthenticateBaseDescriptorSupplier {
    AuthenticateFileDescriptorSupplier() {}
  }

  private static final class AuthenticateMethodDescriptorSupplier
      extends AuthenticateBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthenticateMethodDescriptorSupplier(String methodName) {
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
      synchronized (AuthenticateGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthenticateFileDescriptorSupplier())
              .addMethod(getCheckInMethod())
              .addMethod(getCheckOutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
