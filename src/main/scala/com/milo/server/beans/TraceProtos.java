// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: traceProtos.proto

package com.milo.server.beans;

public final class TraceProtos {
  private TraceProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface TraceOrBuilder
      extends com.google.protobuf.MessageOrBuilder {
    
    // optional int64 id = 1;
    boolean hasId();
    long getId();
    
    // optional int64 blogId = 2;
    boolean hasBlogId();
    long getBlogId();
    
    // optional int64 timestamp = 3;
    boolean hasTimestamp();
    long getTimestamp();
    
    // optional string ip = 4;
    boolean hasIp();
    String getIp();
  }
  public static final class Trace extends
      com.google.protobuf.GeneratedMessage
      implements TraceOrBuilder {
    // Use Trace.newBuilder() to construct.
    private Trace(Builder builder) {
      super(builder);
    }
    private Trace(boolean noInit) {}
    
    private static final Trace defaultInstance;
    public static Trace getDefaultInstance() {
      return defaultInstance;
    }
    
    public Trace getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.milo.server.beans.TraceProtos.internal_static_ProtoJs_Trace_Trace_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.milo.server.beans.TraceProtos.internal_static_ProtoJs_Trace_Trace_fieldAccessorTable;
    }
    
    private int bitField0_;
    // optional int64 id = 1;
    public static final int ID_FIELD_NUMBER = 1;
    private long id_;
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public long getId() {
      return id_;
    }
    
    // optional int64 blogId = 2;
    public static final int BLOGID_FIELD_NUMBER = 2;
    private long blogId_;
    public boolean hasBlogId() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    public long getBlogId() {
      return blogId_;
    }
    
    // optional int64 timestamp = 3;
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    private long timestamp_;
    public boolean hasTimestamp() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    public long getTimestamp() {
      return timestamp_;
    }
    
    // optional string ip = 4;
    public static final int IP_FIELD_NUMBER = 4;
    private java.lang.Object ip_;
    public boolean hasIp() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    public String getIp() {
      java.lang.Object ref = ip_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (com.google.protobuf.Internal.isValidUtf8(bs)) {
          ip_ = s;
        }
        return s;
      }
    }
    private com.google.protobuf.ByteString getIpBytes() {
      java.lang.Object ref = ip_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
        ip_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    
    private void initFields() {
      id_ = 0L;
      blogId_ = 0L;
      timestamp_ = 0L;
      ip_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt64(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt64(2, blogId_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt64(3, timestamp_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(4, getIpBytes());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, blogId_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(3, timestamp_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, getIpBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static com.milo.server.beans.TraceProtos.Trace parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.milo.server.beans.TraceProtos.Trace parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.milo.server.beans.TraceProtos.Trace parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.milo.server.beans.TraceProtos.Trace parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.milo.server.beans.TraceProtos.Trace parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.milo.server.beans.TraceProtos.Trace parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.milo.server.beans.TraceProtos.Trace parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.milo.server.beans.TraceProtos.Trace parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.milo.server.beans.TraceProtos.Trace parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.milo.server.beans.TraceProtos.Trace parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.milo.server.beans.TraceProtos.Trace prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.milo.server.beans.TraceProtos.TraceOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.milo.server.beans.TraceProtos.internal_static_ProtoJs_Trace_Trace_descriptor;
      }
      
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.milo.server.beans.TraceProtos.internal_static_ProtoJs_Trace_Trace_fieldAccessorTable;
      }
      
      // Construct using com.milo.server.beans.TraceProtos.Trace.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        id_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        blogId_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000002);
        timestamp_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000004);
        ip_ = "";
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.milo.server.beans.TraceProtos.Trace.getDescriptor();
      }
      
      public com.milo.server.beans.TraceProtos.Trace getDefaultInstanceForType() {
        return com.milo.server.beans.TraceProtos.Trace.getDefaultInstance();
      }
      
      public com.milo.server.beans.TraceProtos.Trace build() {
        com.milo.server.beans.TraceProtos.Trace result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private com.milo.server.beans.TraceProtos.Trace buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        com.milo.server.beans.TraceProtos.Trace result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public com.milo.server.beans.TraceProtos.Trace buildPartial() {
        com.milo.server.beans.TraceProtos.Trace result = new com.milo.server.beans.TraceProtos.Trace(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.id_ = id_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.blogId_ = blogId_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.timestamp_ = timestamp_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.ip_ = ip_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.milo.server.beans.TraceProtos.Trace) {
          return mergeFrom((com.milo.server.beans.TraceProtos.Trace)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.milo.server.beans.TraceProtos.Trace other) {
        if (other == com.milo.server.beans.TraceProtos.Trace.getDefaultInstance()) return this;
        if (other.hasId()) {
          setId(other.getId());
        }
        if (other.hasBlogId()) {
          setBlogId(other.getBlogId());
        }
        if (other.hasTimestamp()) {
          setTimestamp(other.getTimestamp());
        }
        if (other.hasIp()) {
          setIp(other.getIp());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              onChanged();
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                onChanged();
                return this;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              id_ = input.readInt64();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              blogId_ = input.readInt64();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              timestamp_ = input.readInt64();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000008;
              ip_ = input.readBytes();
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // optional int64 id = 1;
      private long id_ ;
      public boolean hasId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public long getId() {
        return id_;
      }
      public Builder setId(long value) {
        bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = 0L;
        onChanged();
        return this;
      }
      
      // optional int64 blogId = 2;
      private long blogId_ ;
      public boolean hasBlogId() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      public long getBlogId() {
        return blogId_;
      }
      public Builder setBlogId(long value) {
        bitField0_ |= 0x00000002;
        blogId_ = value;
        onChanged();
        return this;
      }
      public Builder clearBlogId() {
        bitField0_ = (bitField0_ & ~0x00000002);
        blogId_ = 0L;
        onChanged();
        return this;
      }
      
      // optional int64 timestamp = 3;
      private long timestamp_ ;
      public boolean hasTimestamp() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      public long getTimestamp() {
        return timestamp_;
      }
      public Builder setTimestamp(long value) {
        bitField0_ |= 0x00000004;
        timestamp_ = value;
        onChanged();
        return this;
      }
      public Builder clearTimestamp() {
        bitField0_ = (bitField0_ & ~0x00000004);
        timestamp_ = 0L;
        onChanged();
        return this;
      }
      
      // optional string ip = 4;
      private java.lang.Object ip_ = "";
      public boolean hasIp() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      public String getIp() {
        java.lang.Object ref = ip_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
          ip_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      public Builder setIp(String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        ip_ = value;
        onChanged();
        return this;
      }
      public Builder clearIp() {
        bitField0_ = (bitField0_ & ~0x00000008);
        ip_ = getDefaultInstance().getIp();
        onChanged();
        return this;
      }
      void setIp(com.google.protobuf.ByteString value) {
        bitField0_ |= 0x00000008;
        ip_ = value;
        onChanged();
      }
      
      // @@protoc_insertion_point(builder_scope:ProtoJs.Trace.Trace)
    }
    
    static {
      defaultInstance = new Trace(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:ProtoJs.Trace.Trace)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_ProtoJs_Trace_Trace_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ProtoJs_Trace_Trace_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021traceProtos.proto\022\rProtoJs.Trace\"B\n\005Tr" +
      "ace\022\n\n\002id\030\001 \001(\003\022\016\n\006blogId\030\002 \001(\003\022\021\n\ttimes" +
      "tamp\030\003 \001(\003\022\n\n\002ip\030\004 \001(\tB\027\n\025com.milo.serve" +
      "r.beans"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_ProtoJs_Trace_Trace_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_ProtoJs_Trace_Trace_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_ProtoJs_Trace_Trace_descriptor,
              new java.lang.String[] { "Id", "BlogId", "Timestamp", "Ip", },
              com.milo.server.beans.TraceProtos.Trace.class,
              com.milo.server.beans.TraceProtos.Trace.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}
