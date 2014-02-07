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
  $('#hdct').on('click', function() {
    if ($('#content').css('display') == 'block') {
      $('#content').css('display', 'none');
      $('#footer').css('display', 'none');
    } else {
      $('#content').css('display', 'block');
      $('#footer').css('display', 'block');
    }
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
