// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smartMedChat.proto

package dist.systems.ca.service3;

public final class SmartMedChat {
  private SmartMedChat() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatMsg_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022smartMedChat.proto\"-\n\007chatMsg\022\017\n\007messa" +
      "ge\030\001 \001(\t\022\021\n\tmessageNo\030\002 \001(\0052,\n\004Chat\022$\n\010C" +
      "hatBiDi\022\010.chatMsg\032\010.chatMsg\"\000(\0010\001B\034\n\030dis" +
      "t.systems.ca.service3P\001b\006proto3"
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
    internal_static_chatMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_chatMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatMsg_descriptor,
        new java.lang.String[] { "Message", "MessageNo", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}