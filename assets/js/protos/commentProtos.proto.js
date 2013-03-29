"use strict";
/** @suppress {duplicate}*/var ProtoJs;
if (typeof(ProtoJs)=="undefined") {ProtoJs = {};}
if (typeof(ProtoJs.Comment)=="undefined") {ProtoJs.Comment = {};}

ProtoJs.Comment.Comment = PROTO.Message("ProtoJs.Comment.Comment",{
	id: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.int64;},
		id: 1
	},
	blogId: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.int64;},
		id: 2
	},
	userId: {
		options: {default_value:0},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.int64;},
		id: 3
	},
	timestamp: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.int64;},
		id: 4
	},
	content: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.string;},
		id: 5
	},
	parentId: {
		options: {default_value:0},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.int64;},
		id: 6
	}});
