(function ($) {
    if ($("#shoppingItems").text().trim().length == 0) updateCart(0);
})(jQuery);

function updateCart(itemnumber) {
    var item;
    if (itemnumber == undefined) {
        let oldCount = $("#shoppingItems").text().trim();

        if (oldCount.length == 0) {
            oldCount = 0;
        } else {
            oldCount = parseInt(oldCount)
        }

        itemnumber = oldCount + 1;
    }
    $("#shoppingItems").text(itemnumber);
}

$(".ajaxAuthorName").click(function () {
    var data = $(this).text();
    var url = '/ajax';
    $(".ajaxChange").html(data);
    $(".authorbooks").html('');
    $("#loading").show();
    $.ajax({
        "url": url,
        "type": "POST",
        "data": {name: data, type: 1},
        "success": function (response) {
            var obj = JSON.parse(response);
            var html = '';
            for (let i = 0; i < obj.length; i++)
                html += book(obj[i]);
            //console.log(html);
            $("#loading").hide();
            $(".authorbooks").html(html);
        }
    });
});
$(".ajaxPublisherName").click(function () {

    var data = $(this).text();
    var url = '/ajax';
    $(".ajaxChange").html(data);
    $(".authorbooks").html('');
    $("#loading").show();
    $.ajax({
        "url": url,
        "type": "POST",
        "data": {name: data, type: 2},
        "success": function (response) {
            var obj = JSON.parse(response);
            var html = '';
            for (let i = 0; i < obj.length; i++)
                html += book(obj[i]);
            //console.log(html);
            $("#loading").hide();
            $(".authorbooks").html(html);

        }
    });
});

function book(obj) {
    var discountedPrice = (obj.price - (obj.price * obj.discount / 100)).toFixed(2);
    let html = "<div class=\"col-md-3\">" +
        '<div class="book">' +
        '<div class="book-img">' +
        '<span>Save ' + obj.discount + '%</span>' +
        '<a href="book-details?id=' + obj.id + '"><img src="' + obj.thumb_url + '" class="center"  height="200" alt=""></a>' +
        '</div>' +
        '<div class="book-body">' +

        '<h5 class="book-title"><a href="book-details?id=' + obj.id + '">' + obj.title + '</a> </h5>' +
        '<p class="book-text">' + obj.description.substring(0, 46) + '<br>' +
        '<span class="text-danger">$' + discountedPrice + '</span>';
    if (obj.discount > 0)
        html += '<strike> $' + obj.price + '</strike>';
    html += '</p><a href="book-details?id=' + obj.id + '" class="btn btn-warning btn-sm"><i class="fas fa-shopping-cart"></i> Add to cart</a>' +
        '</div>' +
        '</div>' +
        '</div>';
    return html;
}