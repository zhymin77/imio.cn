var milo = milo || {};
milo.Util = function() {};
milo.Util.prototype.touchVerify = function(args, sfun, efun) {
  window.TouClick.Start({
    website_key: '959dff8e-827f-4a44-b204-7f42d41d0cc9',
    position_code: 0,
    args: args,
    captcha_style: { 'position': 'fixed', 'top': '250px'},
    onSuccess: sfun,
    onError: efun
  });
};
milo.Util.prototype.postJson = function(url, data, sfun, efun) {
  $.ajax({
    type: 'POST',
    url: url,
    data: data,
    success: sfun,
    error:efun
  });
};
$(function() {
    mUtil = new milo.Util();
});
