$(function () {
    $("#aside div").css("display", "none");
    $("#aside h2").on("click", function () {
        $("#aside div").not($(this).next()).css("display", "none");
        if ($(this).next().css("display") === "none") {
            $(this).next().css("display", "block")
        } else {
            $(this).next().css("display", "none")
        }
    });
});