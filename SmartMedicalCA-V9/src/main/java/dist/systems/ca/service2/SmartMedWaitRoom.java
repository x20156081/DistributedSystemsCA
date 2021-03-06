// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smartMedWaitRoom.proto

package dist.systems.ca.service2;

public final class SmartMedWaitRoom {
  private SmartMedWaitRoom() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_waitingRoomEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_waitingRoomEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_waitTimeReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_waitTimeReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_answer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_answer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_acceptance_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_acceptance_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026smartMedWaitRoom.proto\"H\n\020waitingRoomE" +
      "ntry\022\032\n\022hasEnteredWaitRoom\030\001 \001(\010\022\030\n\020pati" +
      "entFirstName\030\002 \001(\t\"1\n\rwaitTimeReply\022\017\n\007t" +
      "imeMsg\030\001 \001(\t\022\017\n\007minutes\030\002 \001(\005\";\n\006answer\022" +
      "\016\n\006retort\030\001 \001(\t\022\020\n\010answerNo\030\002 \001(\005\022\017\n\007met" +
      "rics\030\003 \001(\001\"C\n\nacceptance\022\023\n\013serverReply\030" +
      "\001 \001(\t\022\020\n\010accepted\030\002 \001(\010\022\016\n\006bmiRes\030\003 \001(\0012" +
      "\204\001\n\013MedWaitRoom\022;\n\022WaitingTimerStream\022\021." +
      "waitingRoomEntry\032\016.waitTimeReply\"\0000\001\0228\n\034" +
      "SendLiabilityClientStreaming\022\007.answer\032\013." +
      "acceptance\"\000(\001B\034\n\030dist.systems.ca.servic" +
      "e2P\001b\006proto3"
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
    internal_static_waitingRoomEntry_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_waitingRoomEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_waitingRoomEntry_descriptor,
        new java.lang.String[] { "HasEnteredWaitRoom", "PatientFirstName", });
    internal_static_waitTimeReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_waitTimeReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_waitTimeReply_descriptor,
        new java.lang.String[] { "TimeMsg", "Minutes", });
    internal_static_answer_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_answer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_answer_descriptor,
        new java.lang.String[] { "Retort", "AnswerNo", "Metrics", });
    internal_static_acceptance_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_acceptance_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_acceptance_descriptor,
        new java.lang.String[] { "ServerReply", "Accepted", "BmiRes", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
