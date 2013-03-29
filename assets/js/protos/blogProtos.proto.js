"use strict";
/** @suppress {duplicate}*/var ProtoJs;
if (typeof(ProtoJs)=="undefined") {ProtoJs = {};}
if (typeof(ProtoJs.Blog)=="undefined") {ProtoJs.Blog = {};}

ProtoJs.Blog.BlogType= PROTO.Enum("ProtoJs.Blog.BlogType",{
		Technic :0,
		Essay :1,
		Other :2});
ProtoJs.Blog.Blog = PROTO.Message("ProtoJs.Blog.Blog",{
	id: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.int64;},
		id: 1
	},
	title: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.string;},
		id: 2
	},
	brief: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.string;},
		id: 3
	},
	timestamp: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.int64;},
		id: 4
	},
	review: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.int32;},
		id: 5
	},
	content: {
		options: {},
		multiplicity: PROTO.optional,
		type: function(){return PROTO.string;},
		id: 6
	},
	blogType: {
		options: {default_value:ProtoJs.Blog.BlogType.Technic},
		multiplicity: PROTO.optional,
		type: function(){return ProtoJs.Blog.BlogType;},
		id: 7
	}});
