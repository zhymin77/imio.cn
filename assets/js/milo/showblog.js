function submitComment(ts) {
  var co = $('#commentsay');
  var content = co.val().trim();
  var usrnm = $('#usrnm').val().trim();
  var eml = $('#eml').val().trim();
  if(usrnm == '') {
    alert('请输入用户名。');
  } else if (content == '') {
    alert('请输入非空文字。');
  } else {
    var stream = new PROTO.Base64Stream();
    var cmt = new ProtoJs.Comment.Comment();
    cmt.blogId = new PROTO.I64.fromNumber(co.attr('blogId'));
    cmt.content = content;
    cmt.username = usrnm;
    cmt.email = eml;
    cmt.SerializeToStream(stream);
    $.post(domain + '/savecomment', stream.getString(), function(rv) {
      if ('success' == rv) {
        window.location.reload();
      }
    });
  }
}
