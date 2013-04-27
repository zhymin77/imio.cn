function submitComment(ts) {
  var co = $('#commentsay');
  var content = co.val().trim();
  if (content == '') {
    alert('请输入非空文字。');
  } else {
    var args = {'content': content, 'blogId': co.attr('blogId')};
    mUtil.touchVerify(args, cbSuccess);
  }
}
function cbSuccess(args, check_obj) {
  var stream = new PROTO.Base64Stream();
  var cmt = new ProtoJs.Comment.Comment();
  console.log(args['blogId']);
  cmt.blogId = new PROTO.I64.fromNumber(args['blogId']);//args['blogId'];
  cmt.content = args['content'];
  cmt.SerializeToStream(stream);
  mUtil.postJson(domain + '/savecomment', stream.getString(),
    function(msg) { alert('success'); },
    function(msg) { alert('保存失败：' + msg); }
  );
}
