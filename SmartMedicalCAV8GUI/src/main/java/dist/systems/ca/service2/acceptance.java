// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smartMedWaitRoom.proto

package dist.systems.ca.service2;

/**
 * Protobuf type {@code acceptance}
 */
public  final class acceptance extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:acceptance)
    acceptanceOrBuilder {
private static final long serialVersionUID = 0L;
  // Use acceptance.newBuilder() to construct.
  private acceptance(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private acceptance() {
    serverReply_ = "";
    accepted_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private acceptance(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            serverReply_ = s;
            break;
          }
          case 16: {

            accepted_ = input.readBool();
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
    return dist.systems.ca.service2.SmartMedWaitRoom.internal_static_acceptance_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return dist.systems.ca.service2.SmartMedWaitRoom.internal_static_acceptance_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            dist.systems.ca.service2.acceptance.class, dist.systems.ca.service2.acceptance.Builder.class);
  }

  public static final int SERVERREPLY_FIELD_NUMBER = 1;
  private volatile java.lang.Object serverReply_;
  /**
   * <code>string serverReply = 1;</code>
   */
  public java.lang.String getServerReply() {
    java.lang.Object ref = serverReply_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      serverReply_ = s;
      return s;
    }
  }
  /**
   * <code>string serverReply = 1;</code>
   */
  public com.google.protobuf.ByteString
      getServerReplyBytes() {
    java.lang.Object ref = serverReply_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      serverReply_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ACCEPTED_FIELD_NUMBER = 2;
  private boolean accepted_;
  /**
   * <code>bool accepted = 2;</code>
   */
  public boolean getAccepted() {
    return accepted_;
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
    if (!getServerReplyBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, serverReply_);
    }
    if (accepted_ != false) {
      output.writeBool(2, accepted_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getServerReplyBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, serverReply_);
    }
    if (accepted_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, accepted_);
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
    if (!(obj instanceof dist.systems.ca.service2.acceptance)) {
      return super.equals(obj);
    }
    dist.systems.ca.service2.acceptance other = (dist.systems.ca.service2.acceptance) obj;

    boolean result = true;
    result = result && getServerReply()
        .equals(other.getServerReply());
    result = result && (getAccepted()
        == other.getAccepted());
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
    hash = (37 * hash) + SERVERREPLY_FIELD_NUMBER;
    hash = (53 * hash) + getServerReply().hashCode();
    hash = (37 * hash) + ACCEPTED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getAccepted());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static dist.systems.ca.service2.acceptance parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dist.systems.ca.service2.acceptance parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dist.systems.ca.service2.acceptance parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dist.systems.ca.service2.acceptance parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dist.systems.ca.service2.acceptance parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dist.systems.ca.service2.acceptance parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dist.systems.ca.service2.acceptance parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dist.systems.ca.service2.acceptance parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static dist.systems.ca.service2.acceptance parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static dist.systems.ca.service2.acceptance parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static dist.systems.ca.service2.acceptance parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dist.systems.ca.service2.acceptance parseFrom(
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
  public static Builder newBuilder(dist.systems.ca.service2.acceptance prototype) {
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
   * Protobuf type {@code acceptance}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:acceptance)
      dist.systems.ca.service2.acceptanceOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return dist.systems.ca.service2.SmartMedWaitRoom.internal_static_acceptance_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return dist.systems.ca.service2.SmartMedWaitRoom.internal_static_acceptance_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              dist.systems.ca.service2.acceptance.class, dist.systems.ca.service2.acceptance.Builder.class);
    }

    // Construct using dist.systems.ca.service2.acceptance.newBuilder()
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
      serverReply_ = "";

      accepted_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return dist.systems.ca.service2.SmartMedWaitRoom.internal_static_acceptance_descriptor;
    }

    @java.lang.Override
    public dist.systems.ca.service2.acceptance getDefaultInstanceForType() {
      return dist.systems.ca.service2.acceptance.getDefaultInstance();
    }

    @java.lang.Override
    public dist.systems.ca.service2.acceptance build() {
      dist.systems.ca.service2.acceptance result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public dist.systems.ca.service2.acceptance buildPartial() {
      dist.systems.ca.service2.acceptance result = new dist.systems.ca.service2.acceptance(this);
      result.serverReply_ = serverReply_;
      result.accepted_ = accepted_;
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
      if (other instanceof dist.systems.ca.service2.acceptance) {
        return mergeFrom((dist.systems.ca.service2.acceptance)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(dist.systems.ca.service2.acceptance other) {
      if (other == dist.systems.ca.service2.acceptance.getDefaultInstance()) return this;
      if (!other.getServerReply().isEmpty()) {
        serverReply_ = other.serverReply_;
        onChanged();
      }
      if (other.getAccepted() != false) {
        setAccepted(other.getAccepted());
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
      dist.systems.ca.service2.acceptance parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (dist.systems.ca.service2.acceptance) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object serverReply_ = "";
    /**
     * <code>string serverReply = 1;</code>
     */
    public java.lang.String getServerReply() {
      java.lang.Object ref = serverReply_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        serverReply_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string serverReply = 1;</code>
     */
    public com.google.protobuf.ByteString
        getServerReplyBytes() {
      java.lang.Object ref = serverReply_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        serverReply_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string serverReply = 1;</code>
     */
    public Builder setServerReply(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      serverReply_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string serverReply = 1;</code>
     */
    public Builder clearServerReply() {
      
      serverReply_ = getDefaultInstance().getServerReply();
      onChanged();
      return this;
    }
    /**
     * <code>string serverReply = 1;</code>
     */
    public Builder setServerReplyBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      serverReply_ = value;
      onChanged();
      return this;
    }

    private boolean accepted_ ;
    /**
     * <code>bool accepted = 2;</code>
     */
    public boolean getAccepted() {
      return accepted_;
    }
    /**
     * <code>bool accepted = 2;</code>
     */
    public Builder setAccepted(boolean value) {
      
      accepted_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool accepted = 2;</code>
     */
    public Builder clearAccepted() {
      
      accepted_ = false;
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


    // @@protoc_insertion_point(builder_scope:acceptance)
  }

  // @@protoc_insertion_point(class_scope:acceptance)
  private static final dist.systems.ca.service2.acceptance DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new dist.systems.ca.service2.acceptance();
  }

  public static dist.systems.ca.service2.acceptance getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<acceptance>
      PARSER = new com.google.protobuf.AbstractParser<acceptance>() {
    @java.lang.Override
    public acceptance parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new acceptance(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<acceptance> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<acceptance> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public dist.systems.ca.service2.acceptance getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

