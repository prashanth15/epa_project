$(document).ready(function() {
    $("#e1").select2();
    $("#e9").select2();
    $("#e92").select2();
    $("#e94").select2();
    $("#e2").select2({
        placeholder: "Select a State",
        allowClear: true
    });
    $("#e3").select2({
        minimumInputLength: 2
    });
});

