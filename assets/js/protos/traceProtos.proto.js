"use strict";
/** @suppress {duplicate}*/var ProtoJs;
if (typeof(ProtoJs)=="undefined") {ProtoJs = {};}
if (typeof(ProtoJs.Trace)=="undefined") {ProtoJs.Trace = {};}

ProtoJs.Trace.Trace = PROTO.Message("ProtoJs.Trace.Trace",{
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
	timestamp: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.int64;},
		id: 3
	},
	ip: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.string;},
		id: 4
	}});
