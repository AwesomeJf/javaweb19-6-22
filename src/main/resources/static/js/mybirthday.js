$(function(){
var days = 0;
years();
months();
Days();
var date = new Date();
$("#dr_year").val(date.getFullYear());
$("#dr_month").val((date.getMonth() + 1));
$("#dr_day").val(date.getDate());
$("#dr_year").change(function () {
    months();
    Days();
});
$("#dr_month").change(function () {
    Days();
});

function years() {
    for (var i = 1900; i <= 2100; i++) {
        var str = "<option value=\"" + i + "\">" + i + "</option>";
        $("#dr_year").append(str);
    }
}

function months() {
    $("#dr_month").empty();
    for (var i = 1; i <= 12; i++) {
        var str = "<option value=\"" + i + "\">" + i + "</option>";
        $("#dr_month").append(str);
    }
}

function Days() {
    $("#dr_day").empty();
    if (parseInt($("#dr_month").val()) == 1 || parseInt($("#dr_month").val()) == 3 || parseInt($("#dr_month").val()) == 5 || parseInt($("#dr_month").val()) == 7 || parseInt($("#dr_month").val()) == 8 || parseInt($("#dr_month").val()) == 10 || parseInt($("#dr_month").val()) == 12) {
        days = 31;
    }
    else if (parseInt($("#dr_month").val()) == 4 || parseInt($("#dr_month").val()) == 6 || parseInt($("#dr_month").val()) == 9 || parseInt($("#dr_month").val()) == 11) {
        days = 30;
    }
    else {
        if (parseInt($("#dr_year").val()) % 400 == 0 || (parseInt($("#dr_year").val()) % 4 == 0 && parseInt($("#dr_year").val()) % 100 != 0)) {
            days = 29;
        }
        else {
            days = 28;
        }
    }
    for (var i = 1; i <= days; i++) {
        var str = "<option value=\"" + i + "\">" + i + "</option>";
        $("#dr_day").append(str);
    }
}
})