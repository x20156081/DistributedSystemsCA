package com.dermot;

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
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: biDirectional.proto")
public final class GreeterGrpc {

  private GreeterGrpc() {}

  public static final String SERVICE_NAME = "Greeter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dermot.HelloRequest,
      com.dermot.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = com.dermot.HelloRequest.class,
      responseType = com.dermot.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dermot.HelloRequest,
      com.dermot.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<com.dermot.HelloRequest, com.dermot.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
          GreeterGrpc.getSayHelloMethod = getSayHelloMethod = 
              io.grpc.MethodDescriptor.<com.dermot.HelloRequest, com.dermot.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Greeter", "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.HelloReply.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SayHello"))
                  .build();
          }
        }
     }
     return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dermot.HelloRequest,
      com.dermot.HelloReply> getSayHelloAgainMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHelloAgain",
      requestType = com.dermot.HelloRequest.class,
      responseType = com.dermot.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dermot.HelloRequest,
      com.dermot.HelloReply> getSayHelloAgainMethod() {
    io.grpc.MethodDescriptor<com.dermot.HelloRequest, com.dermot.HelloReply> getSayHelloAgainMethod;
    if ((getSayHelloAgainMethod = GreeterGrpc.getSayHelloAgainMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSayHelloAgainMethod = GreeterGrpc.getSayHelloAgainMethod) == null) {
          GreeterGrpc.getSayHelloAgainMethod = getSayHelloAgainMethod = 
              io.grpc.MethodDescriptor.<com.dermot.HelloRequest, com.dermot.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Greeter", "SayHelloAgain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.HelloReply.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SayHelloAgain"))
                  .build();
          }
        }
     }
     return getSayHelloAgainMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dermot.DetailsRequest,
      com.dermot.DetailsReply> getSendDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendDetails",
      requestType = com.dermot.DetailsRequest.class,
      responseType = com.dermot.DetailsReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dermot.DetailsRequest,
      com.dermot.DetailsReply> getSendDetailsMethod() {
    io.grpc.MethodDescriptor<com.dermot.DetailsRequest, com.dermot.DetailsReply> getSendDetailsMethod;
    if ((getSendDetailsMethod = GreeterGrpc.getSendDetailsMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSendDetailsMethod = GreeterGrpc.getSendDetailsMethod) == null) {
          GreeterGrpc.getSendDetailsMethod = getSendDetailsMethod = 
              io.grpc.MethodDescriptor.<com.dermot.DetailsRequest, com.dermot.DetailsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Greeter", "SendDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.DetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.DetailsReply.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SendDetails"))
                  .build();
          }
        }
     }
     return getSendDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dermot.DetailsRequest,
      com.dermot.DetailsReply> getSendDetailsStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendDetailsStream",
      requestType = com.dermot.DetailsRequest.class,
      responseType = com.dermot.DetailsReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.dermot.DetailsRequest,
      com.dermot.DetailsReply> getSendDetailsStreamMethod() {
    io.grpc.MethodDescriptor<com.dermot.DetailsRequest, com.dermot.DetailsReply> getSendDetailsStreamMethod;
    if ((getSendDetailsStreamMethod = GreeterGrpc.getSendDetailsStreamMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSendDetailsStreamMethod = GreeterGrpc.getSendDetailsStreamMethod) == null) {
          GreeterGrpc.getSendDetailsStreamMethod = getSendDetailsStreamMethod = 
              io.grpc.MethodDescriptor.<com.dermot.DetailsRequest, com.dermot.DetailsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Greeter", "SendDetailsStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.DetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.DetailsReply.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SendDetailsStream"))
                  .build();
          }
        }
     }
     return getSendDetailsStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dermot.DetailsRequest,
      com.dermot.DetailsReply> getSendDetailsClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendDetailsClientStream",
      requestType = com.dermot.DetailsRequest.class,
      responseType = com.dermot.DetailsReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.dermot.DetailsRequest,
      com.dermot.DetailsReply> getSendDetailsClientStreamMethod() {
    io.grpc.MethodDescriptor<com.dermot.DetailsRequest, com.dermot.DetailsReply> getSendDetailsClientStreamMethod;
    if ((getSendDetailsClientStreamMethod = GreeterGrpc.getSendDetailsClientStreamMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSendDetailsClientStreamMethod = GreeterGrpc.getSendDetailsClientStreamMethod) == null) {
          GreeterGrpc.getSendDetailsClientStreamMethod = getSendDetailsClientStreamMethod = 
              io.grpc.MethodDescriptor.<com.dermot.DetailsRequest, com.dermot.DetailsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Greeter", "SendDetailsClientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.DetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.DetailsReply.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SendDetailsClientStream"))
                  .build();
          }
        }
     }
     return getSendDetailsClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dermot.DetailsRequest,
      com.dermot.DetailsReply> getSendDetailsBiDirectionalStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendDetailsBiDirectionalStream",
      requestType = com.dermot.DetailsRequest.class,
      responseType = com.dermot.DetailsReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.dermot.DetailsRequest,
      com.dermot.DetailsReply> getSendDetailsBiDirectionalStreamMethod() {
    io.grpc.MethodDescriptor<com.dermot.DetailsRequest, com.dermot.DetailsReply> getSendDetailsBiDirectionalStreamMethod;
    if ((getSendDetailsBiDirectionalStreamMethod = GreeterGrpc.getSendDetailsBiDirectionalStreamMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSendDetailsBiDirectionalStreamMethod = GreeterGrpc.getSendDetailsBiDirectionalStreamMethod) == null) {
          GreeterGrpc.getSendDetailsBiDirectionalStreamMethod = getSendDetailsBiDirectionalStreamMethod = 
              io.grpc.MethodDescriptor.<com.dermot.DetailsRequest, com.dermot.DetailsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Greeter", "SendDetailsBiDirectionalStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.DetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dermot.DetailsReply.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SendDetailsBiDirectionalStream"))
                  .build();
          }
        }
     }
     return getSendDetailsBiDirectionalStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreeterStub newStub(io.grpc.Channel channel) {
    return new GreeterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GreeterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GreeterFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class GreeterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(com.dermot.HelloRequest request,
        io.grpc.stub.StreamObserver<com.dermot.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    public void sayHelloAgain(com.dermot.HelloRequest request,
        io.grpc.stub.StreamObserver<com.dermot.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloAgainMethod(), responseObserver);
    }

    /**
     * <pre>
     *rpc SayHelloAgainAndAgain (HelloRequest) returns (HelloReply){}
     * </pre>
     */
    public void sendDetails(com.dermot.DetailsRequest request,
        io.grpc.stub.StreamObserver<com.dermot.DetailsReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSendDetailsMethod(), responseObserver);
    }

    /**
     * <pre>
     *server streaming
     * </pre>
     */
    public void sendDetailsStream(com.dermot.DetailsRequest request,
        io.grpc.stub.StreamObserver<com.dermot.DetailsReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSendDetailsStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.dermot.DetailsRequest> sendDetailsClientStream(
        io.grpc.stub.StreamObserver<com.dermot.DetailsReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendDetailsClientStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.dermot.DetailsRequest> sendDetailsBiDirectionalStream(
        io.grpc.stub.StreamObserver<com.dermot.DetailsReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendDetailsBiDirectionalStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dermot.HelloRequest,
                com.dermot.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getSayHelloAgainMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dermot.HelloRequest,
                com.dermot.HelloReply>(
                  this, METHODID_SAY_HELLO_AGAIN)))
          .addMethod(
            getSendDetailsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dermot.DetailsRequest,
                com.dermot.DetailsReply>(
                  this, METHODID_SEND_DETAILS)))
          .addMethod(
            getSendDetailsStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.dermot.DetailsRequest,
                com.dermot.DetailsReply>(
                  this, METHODID_SEND_DETAILS_STREAM)))
          .addMethod(
            getSendDetailsClientStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.dermot.DetailsRequest,
                com.dermot.DetailsReply>(
                  this, METHODID_SEND_DETAILS_CLIENT_STREAM)))
          .addMethod(
            getSendDetailsBiDirectionalStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.dermot.DetailsRequest,
                com.dermot.DetailsReply>(
                  this, METHODID_SEND_DETAILS_BI_DIRECTIONAL_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GreeterStub extends io.grpc.stub.AbstractStub<GreeterStub> {
    private GreeterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(com.dermot.HelloRequest request,
        io.grpc.stub.StreamObserver<com.dermot.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sayHelloAgain(com.dermot.HelloRequest request,
        io.grpc.stub.StreamObserver<com.dermot.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloAgainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *rpc SayHelloAgainAndAgain (HelloRequest) returns (HelloReply){}
     * </pre>
     */
    public void sendDetails(com.dermot.DetailsRequest request,
        io.grpc.stub.StreamObserver<com.dermot.DetailsReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendDetailsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *server streaming
     * </pre>
     */
    public void sendDetailsStream(com.dermot.DetailsRequest request,
        io.grpc.stub.StreamObserver<com.dermot.DetailsReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSendDetailsStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.dermot.DetailsRequest> sendDetailsClientStream(
        io.grpc.stub.StreamObserver<com.dermot.DetailsReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSendDetailsClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *bi-directional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.dermot.DetailsRequest> sendDetailsBiDirectionalStream(
        io.grpc.stub.StreamObserver<com.dermot.DetailsReply> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendDetailsBiDirectionalStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GreeterBlockingStub extends io.grpc.stub.AbstractStub<GreeterBlockingStub> {
    private GreeterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.dermot.HelloReply sayHello(com.dermot.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dermot.HelloReply sayHelloAgain(com.dermot.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloAgainMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *rpc SayHelloAgainAndAgain (HelloRequest) returns (HelloReply){}
     * </pre>
     */
    public com.dermot.DetailsReply sendDetails(com.dermot.DetailsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendDetailsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *server streaming
     * </pre>
     */
    public java.util.Iterator<com.dermot.DetailsReply> sendDetailsStream(
        com.dermot.DetailsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSendDetailsStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GreeterFutureStub extends io.grpc.stub.AbstractStub<GreeterFutureStub> {
    private GreeterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dermot.HelloReply> sayHello(
        com.dermot.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dermot.HelloReply> sayHelloAgain(
        com.dermot.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloAgainMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *rpc SayHelloAgainAndAgain (HelloRequest) returns (HelloReply){}
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dermot.DetailsReply> sendDetails(
        com.dermot.DetailsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendDetailsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_SAY_HELLO_AGAIN = 1;
  private static final int METHODID_SEND_DETAILS = 2;
  private static final int METHODID_SEND_DETAILS_STREAM = 3;
  private static final int METHODID_SEND_DETAILS_CLIENT_STREAM = 4;
  private static final int METHODID_SEND_DETAILS_BI_DIRECTIONAL_STREAM = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreeterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreeterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.dermot.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.dermot.HelloReply>) responseObserver);
          break;
        case METHODID_SAY_HELLO_AGAIN:
          serviceImpl.sayHelloAgain((com.dermot.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.dermot.HelloReply>) responseObserver);
          break;
        case METHODID_SEND_DETAILS:
          serviceImpl.sendDetails((com.dermot.DetailsRequest) request,
              (io.grpc.stub.StreamObserver<com.dermot.DetailsReply>) responseObserver);
          break;
        case METHODID_SEND_DETAILS_STREAM:
          serviceImpl.sendDetailsStream((com.dermot.DetailsRequest) request,
              (io.grpc.stub.StreamObserver<com.dermot.DetailsReply>) responseObserver);
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
        case METHODID_SEND_DETAILS_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendDetailsClientStream(
              (io.grpc.stub.StreamObserver<com.dermot.DetailsReply>) responseObserver);
        case METHODID_SEND_DETAILS_BI_DIRECTIONAL_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendDetailsBiDirectionalStream(
              (io.grpc.stub.StreamObserver<com.dermot.DetailsReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreeterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dermot.BiDirectional.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter");
    }
  }

  private static final class GreeterFileDescriptorSupplier
      extends GreeterBaseDescriptorSupplier {
    GreeterFileDescriptorSupplier() {}
  }

  private static final class GreeterMethodDescriptorSupplier
      extends GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreeterMethodDescriptorSupplier(String methodName) {
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
      synchronized (GreeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreeterFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getSayHelloAgainMethod())
              .addMethod(getSendDetailsMethod())
              .addMethod(getSendDetailsStreamMethod())
              .addMethod(getSendDetailsClientStreamMethod())
              .addMethod(getSendDetailsBiDirectionalStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
