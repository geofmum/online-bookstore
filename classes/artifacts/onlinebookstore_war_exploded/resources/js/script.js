(function($) {

})(jQuery);
function updateCart(itemnumber){
    var item;
    if(itemnumber==undefined){
        itemnumber=parseInt($("#shoppingItems").text())+1;
    }
    $("#shoppingItems").text(itemnumber);
}