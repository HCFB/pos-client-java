$(".spinner").TouchSpin({
    min: 0,
    max: 100,
    step: 1,
    boostat: 5,
    maxboostedstep: 10,
    width: 40
});

$(".spinner").change(function (ev) {
    $(".summ-number").text(getSumm());
});

function getSumm() {
    var summ=0;
    $.each($(".shop-item-price"),function (key,el) {
        summ += $(el).text() * $(el).parent().find(".shop-item-number input").val()
    });
    return summ;
}

$(document).ready(function (doc) {
    $(".summ-number").text(getSumm());
});

$.validate({lang : "ru"});

$("#client-info-form").on("submit", function (ev) {
    ev.preventDefault();
    var data = {};
    $(this).serializeArray().map(function(x){data[x.name] = x.value;});
    $.each(data, function (key, value) {
        if(key == "address") {
            data['code'] = $("option[value='"+value+"']").attr("data-code");
        }
    });
    var items = [];
    $.each($(".shop-item"), function (key, val) {
        var item = {
            model : "ItemModel",
            name : $(val).find(".shop-item-name").text(),
            partnerGoodCatalog : "TEST",
            price : $(val).find(".shop-item-price").text(),
            "producer" : "Someone",
            "quantity" : $(val).find(".shop-item-number input").val(),
            "weight" : 1
        };
        if(item.quantity > 0) {
            items.push(item);
        }
    });
    data["items"] = items;
    $.ajax({
        data : JSON.stringify(data),
        method : "post",
        dataTYpe : "json",
        contentType : "application/json",
        url : "/applicationCreate"
    }).done(function (res) {
        console.log(res);
        $("#client-info-form")[0].reset()
        $("#myModal").fadeOut();
        $(".modal-backdrop").fadeOut();
        window.location.href = res.bankUrl;
    }).fail(function (res) {
        console.log(res);
        alert("Произошла ошибка");
    });
});

function setTestData() {
    var form = $("#client-info-form");
    form.find("#name").val("Иван");
    form.find("#lastname").val("Иванов");
    form.find("#email").val("mail@mail.ru");
    form.find("#phone").val("9101231221");
    form.find("#male").prop('checked', true);
    form.find("#moscow").prop("selected", true);
}

$("#error").on("click", function (el) {
    el.preventDefault();
    $("#client-info-form").find("#middlename").val("Ошибкович");
    setTestData();
});

$("#reject").on("click", function (el) {
    el.preventDefault();
    $("#client-info-form").find("#middlename").val("Отказович");
    setTestData();
});

$("#approve").on("click", function (el) {
    el.preventDefault();
    $("#client-info-form").find("#middlename").val("Иванович");
    setTestData();
});

$("#nmd").on("click", function (el) {
    el.preventDefault();
    $("#client-info-form").find("#middlename").val("Нидмордатович");
    setTestData();
});