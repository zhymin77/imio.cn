$(function() {
  editor = CKEDITOR.replace('CKEditor');
});
$('#blog-submit').click(function() {
  var title = $('#blog-title').val();
  var brief = editor.document.getBody().getText();
  if (brief.length > 250) brief = brief.substring(0, 250);
  var stream = new PROTO.Base64Stream();
  var blog = new ProtoJs.Blog.Blog();
  blog.title = title;
  blog.brief = brief;
  blog.content = editor.getData();
  blog.blogType = ProtoJs.Blog.BlogType.Technic;
  blog.SerializeToStream(stream);
  mUtil.postJson(domain + '/blog/save', stream.getString(),
    function(msg) { alert('保存成功: ' + msg); },
    function(msg) { alert('保存失败：' + msg); }
  );
});

