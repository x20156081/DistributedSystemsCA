// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smartMedAuthenticate.proto

package dist.systems.ca;

public final class SmartMedAuthenticate {
  private SmartMedAuthenticate() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CheckInRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CheckInRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CheckInReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CheckInReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CheckOutRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CheckOutRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CheckOutReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CheckOutReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032smartMedAuthenticate.proto\";\n\016CheckInR" +
      "equest\022\014\n\004name\030\001 \001(\t\022\033\n\023healthServiceNum" +
      "ber\030\002 \001(\005\" \n\014CheckInReply\022\020\n\010replyMsg\030\001 " +
      "\001(\t\"<\n\017CheckOutRequest\022\014\n\004name\030\001 \001(\t\022\033\n\023" +
      "healthServiceNumber\030\002 \001(\005\"\036\n\rCheckOutRep" +
      "ly\022\r\n\005reply\030\001 \001(\t2k\n\014Authenticate\022+\n\007Che" +
      "ckIn\022\017.CheckInRequest\032\r.CheckInReply\"\000\022." +
      "\n\010CheckOut\022\020.CheckOutRequest\032\016.CheckOutR" +
      "eply\"\000B\023\n\017dist.systems.caP\001b\006proto3"
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
    internal_static_CheckInRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_CheckInRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CheckInRequest_descriptor,
        new java.lang.String[] { "Name", "HealthServiceNumber", });
    internal_static_CheckInReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_CheckInReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CheckInReply_descriptor,
        new java.lang.String[] { "ReplyMsg", });
    internal_static_CheckOutRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_CheckOutRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CheckOutRequest_descriptor,
        new java.lang.String[] { "Name", "HealthServiceNumber", });
    internal_static_CheckOutReply_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_CheckOutReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CheckOutReply_descriptor,
        new java.lang.String[] { "Reply", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}