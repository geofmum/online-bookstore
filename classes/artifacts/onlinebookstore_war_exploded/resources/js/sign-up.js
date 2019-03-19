(function () {
    $(() => {



    });
})();

$('#signup').click(function(){

    const user = {
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#pass").val()
    };

    console.log(user);
    const address = {

        street: $("#street").val(),
        phonenumber: $("#phone").val(),
        appartment: $("#apt").val(),
        city: $("#city").val(),
        state: $("#state").val(),
        zipcode: $("#zip").val()
    };

    console.log(user);

   $.ajax({
        "url":"/ajaxAuth",
        "type":"POST",
        "data":{user: JSON.stringify(user), address: JSON.stringify(address)},
        "success": function(response) {
            if(response=="success") location.href="/";
            else
            alert(response);
        }
    });

    return false;
});