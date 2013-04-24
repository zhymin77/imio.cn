function submitComment(ts) {
  var comment = $.trim(ts.previousSibling.innerHTML);
  console.log(comment);
  mUtil.touchVerify(cbSuccess);
}
function cbSuccess(args, check_obj) {
}
