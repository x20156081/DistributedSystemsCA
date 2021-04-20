// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smartMedWaitRoom.proto

package dist.systems.ca;

/**
 * Protobuf type {@code WaitingRoomEntry}
 */
public  final class WaitingRoomEntry extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:WaitingRoomEntry)
    WaitingRoomEntryOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WaitingRoomEntry.newBuilder() to construct.
  private WaitingRoomEntry(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WaitingRoomEntry() {
    hasEnteredWaitRoom_ = false;
    patientFirstName_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WaitingRoomEntry(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            hasEnteredWaitRoom_ = input.readBool();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            patientFirstName_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return dist.systems.ca.SmartMedWaitRoom.internal_static_WaitingRoomEntry_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return dist.systems.ca.SmartMedWaitRoom.internal_static_WaitingRoomEntry_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            dist.systems.ca.WaitingRoomEntry.class, dist.systems.ca.WaitingRoomEntry.Builder.class);
  }

  public static final int HASENTEREDWAITROOM_FIELD_NUMBER = 1;
  private boolean hasEnteredWaitRoom_;
  /**
   * <code>bool hasEnteredWaitRoom = 1;</code>
   */
  public boolean getHasEnteredWaitRoom() {
    return hasEnteredWaitRoom_;
  }

  public static final int PATIENTFIRSTNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object patientFirstName_;
  /**
   * <code>string patientFirstName = 2;</code>
   */
  public java.lang.String getPatientFirstName() {
    java.lang.Object ref = patientFirstName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      patientFirstName_ = s;
      return s;
    }
  }
  /**
   * <code>string patientFirstName = 2;</code>
   */
  public com.google.protobuf.ByteString
      getPatientFirstNameBytes() {
    java.lang.Object ref = patientFirstName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      patientFirstName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (hasEnteredWaitRoom_ != false) {
      output.writeBool(1, hasEnteredWaitRoom_);
    }
    if (!getPatientFirstNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, patientFirstName_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (hasEnteredWaitRoom_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, hasEnteredWaitRoom_);
    }
    if (!getPatientFirstNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, patientFirstName_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof dist.systems.ca.WaitingRoomEntry)) {
      return super.equals(obj);
    }
    dist.systems.ca.WaitingRoomEntry other = (dist.systems.ca.WaitingRoomEntry) obj;

    boolean result = true;
    result = result && (getHasEnteredWaitRoom()
        == other.getHasEnteredWaitRoom());
    result = result && getPatientFirstName()
        .equals(other.getPatientFirstName());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + HASENTEREDWAITROOM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getHasEnteredWaitRoom());
    hash = (37 * hash) + PATIENTFIRSTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getPatientFirstName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static dist.systems.ca.WaitingRoomEntry parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dist.systems.ca.WaitingRoomEntry parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dist.systems.ca.WaitingRoomEntry parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dist.systems.ca.WaitingRoomEntry parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dist.systems.ca.WaitingRoomEntry parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dist.systems.ca.WaitingRoomEntry parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dist.systems.ca.WaitingRoomEntry parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dist.systems.ca.WaitingRoomEntry parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static dist.systems.ca.WaitingRoomEntry parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static dist.systems.ca.WaitingRoomEntry parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static dist.systems.ca.WaitingRoomEntry parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dist.systems.ca.WaitingRoomEntry parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(dist.systems.ca.WaitingRoomEntry prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code WaitingRoomEntry}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:WaitingRoomEntry)
      dist.systems.ca.WaitingRoomEntryOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return dist.systems.ca.SmartMedWaitRoom.internal_static_WaitingRoomEntry_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return dist.systems.ca.SmartMedWaitRoom.internal_static_WaitingRoomEntry_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              dist.systems.ca.WaitingRoomEntry.class, dist.systems.ca.WaitingRoomEntry.Builder.class);
    }

    // Construct using dist.systems.ca.WaitingRoomEntry.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      hasEnteredWaitRoom_ = false;

      patientFirstName_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return dist.systems.ca.SmartMedWaitRoom.internal_static_WaitingRoomEntry_descriptor;
    }

    @java.lang.Override
    public dist.systems.ca.WaitingRoomEntry getDefaultInstanceForType() {
      return dist.systems.ca.WaitingRoomEntry.getDefaultInstance();
    }

    @java.lang.Override
    public dist.systems.ca.WaitingRoomEntry build() {
      dist.systems.ca.WaitingRoomEntry result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public dist.systems.ca.WaitingRoomEntry buildPartial() {
      dist.systems.ca.WaitingRoomEntry result = new dist.systems.ca.WaitingRoomEntry(this);
      result.hasEnteredWaitRoom_ = hasEnteredWaitRoom_;
      result.patientFirstName_ = patientFirstName_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof dist.systems.ca.WaitingRoomEntry) {
        return mergeFrom((dist.systems.ca.WaitingRoomEntry)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(dist.systems.ca.WaitingRoomEntry other) {
      if (other == dist.systems.ca.WaitingRoomEntry.getDefaultInstance()) return this;
      if (other.getHasEnteredWaitRoom() != false) {
        setHasEnteredWaitRoom(other.getHasEnteredWaitRoom());
      }
      if (!other.getPatientFirstName().isEmpty()) {
        patientFirstName_ = other.patientFirstName_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      dist.systems.ca.WaitingRoomEntry parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (dist.systems.ca.WaitingRoomEntry) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean hasEnteredWaitRoom_ ;
    /**
     * <code>bool hasEnteredWaitRoom = 1;</code>
     */
    public boolean getHasEnteredWaitRoom() {
      return hasEnteredWaitRoom_;
    }
    /**
     * <code>bool hasEnteredWaitRoom = 1;</code>
     */
    public Builder setHasEnteredWaitRoom(boolean value) {
      
      hasEnteredWaitRoom_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool hasEnteredWaitRoom = 1;</code>
     */
    public Builder clearHasEnteredWaitRoom() {
      
      hasEnteredWaitRoom_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object patientFirstName_ = "";
    /**
     * <code>string patientFirstName = 2;</code>
     */
    public java.lang.String getPatientFirstName() {
      java.lang.Object ref = patientFirstName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        patientFirstName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string patientFirstName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getPatientFirstNameBytes() {
      java.lang.Object ref = patientFirstName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        patientFirstName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string patientFirstName = 2;</code>
     */
    public Builder setPatientFirstName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      patientFirstName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string patientFirstName = 2;</code>
     */
    public Builder clearPatientFirstName() {
      
      patientFirstName_ = getDefaultInstance().getPatientFirstName();
      onChanged();
      return this;
    }
    /**
     * <code>string patientFirstName = 2;</code>
     */
    public Builder setPatientFirstNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      patientFirstName_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:WaitingRoomEntry)
  }

  // @@protoc_insertion_point(class_scope:WaitingRoomEntry)
  private static final dist.systems.ca.WaitingRoomEntry DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new dist.systems.ca.WaitingRoomEntry();
  }

  public static dist.systems.ca.WaitingRoomEntry getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WaitingRoomEntry>
      PARSER = new com.google.protobuf.AbstractParser<WaitingRoomEntry>() {
    @java.lang.Override
    public WaitingRoomEntry parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WaitingRoomEntry(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WaitingRoomEntry> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WaitingRoomEntry> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public dist.systems.ca.WaitingRoomEntry getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
