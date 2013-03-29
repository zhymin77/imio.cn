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
  postJson(domain + '/blog/save', stream.getString());
});
function postJson(url, data) {
  $.ajax({
    type: 'POST',
    url: url,
    data: data,
    success: function(msg) {
      console.log('success....');
    },
    error: function(msg) {
      console.log('error....');
    }
  });
};
