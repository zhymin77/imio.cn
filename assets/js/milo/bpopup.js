$(function(){
  $('#login').on('click', function() {
    var t = new Date().getSeconds() % 2 ? 'slideIn' : 'slideDown';
    $('#bppp').bPopup({
      easing: 'easeOutBack',
      speed: 650,
      transition: t,
      loadUrl: '/tologin.html'
    });
  });
});
$(document).on('click', '#user-login', function() {
  var username = $($(this).parent().parent()).find('input.username').val();
  var password = $($(this).parent().parent()).find('input.password').val();
  $.get('/login/' + username + '/' + password, function(msg) {
    $('#bppp').bPopup().close();
    setTimeout(function(){
      if ('ok' == msg) window.location.href = '/'; else alert('呵~呵~呵~呵~呵~~~~');
    }, 500);
  });
});
