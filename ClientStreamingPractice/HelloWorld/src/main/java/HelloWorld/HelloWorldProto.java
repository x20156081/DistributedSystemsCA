// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello.proto

package HelloWorld;

public final class HelloWorldProto {
  private HelloWorldProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HelloReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_HelloReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DetailsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DetailsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DetailsReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DetailsReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013hello.proto\"\034\n\014HelloRequest\022\014\n\004name\030\001 " +
      "\001(\t\"\035\n\nHelloReply\022\017\n\007message\030\001 \001(\t\"A\n\016De" +
      "tailsRequest\022\014\n\004name\030\001 \001(\t\022\024\n\014emailAddre" +
      "ss\030\002 \001(\t\022\013\n\003tel\030\003 \001(\005\"\033\n\014DetailsReply\022\013\n" +
      "\003ack\030\001 \001(\t2\213\002\n\007Greeter\022(\n\010SayHello\022\r.Hel" +
      "loRequest\032\013.HelloReply\"\000\022-\n\rSayHelloAgai" +
      "n\022\r.HelloRequest\032\013.HelloReply\"\000\022/\n\013SendD" +
      "etails\022\017.DetailsRequest\032\r.DetailsReply\"\000" +
      "\0227\n\021SendDetailsStream\022\017.DetailsRequest\032\r" +
      ".DetailsReply\"\0000\001\022=\n\027SendDetailsClientSt" +
      "ream\022\017.DetailsRequest\032\r.DetailsReply\"\000(\001" +
      "B%\n\nHelloWorldB\017HelloWorldProtoP\001\242\002\003HLWb" +
      "\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_HelloReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_HelloReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_HelloReply_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_DetailsRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_DetailsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DetailsRequest_descriptor,
        new java.lang.String[] { "Name", "EmailAddress", "Tel", });
    internal_static_DetailsReply_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_DetailsReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DetailsReply_descriptor,
        new java.lang.String[] { "Ack", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
