$(function() {
  editor = CKEDITOR.replace('CKEditor');
});
$('#blog-submit').click(function() {
  var title = $('#blog-title').val();
  var content = editor.getData();
  var data = {
    'title': title,
    'content': content
  };
  postJson(domain + '/blog/edit', data);
});
function postJson(url, data) {
  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    dataType: 'json',
    url: url,
    data: data,
    success: function(msg) {
      console.log(msg);
    },
    error: function(msg) {
      console.log(msg);
    }
  });
};
