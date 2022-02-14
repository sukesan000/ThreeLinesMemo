$(function () {
  $("#create_memo").click(function () {
    if ($("#create_memo").val() === "true") {
      $(".edit").show();
      $("#create_memo").val(false);
      $("#create_memo").text("-");
    } else if ($("#create_memo").val() === "false") {
      $(".edit").hide();
      $("#create_memo").val(true);
      $("#create_memo").text("+");
    }
  });
});
