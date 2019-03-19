(function () {
    $(() => {



    });
})();

$('#signup').click(function(){
    var myForm = $('#myForm');
    const user = {
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#pass").val()
    };
    const address = {

        street: $("#street").val(),
        phonenumber: $("#phone").val(),
        appartment: $("#apt").val(),
        city: $("#city").val(),
        state: $("#state").val(),
        zipcode: $("#zip").val()
    };
    console.log(myForm[0].checkValidity());
   if( myForm[0].checkValidity()==true) {
       $.ajax({
           "url": "/ajaxAuth",
           "type": "POST",
           "data": {user: JSON.stringify(user), address: JSON.stringify(address)},
           "success": function (response) {
               if (response == "success") location.href = "/";
               else
                   alert(response);
           }
       });
   }
   else alert("Please submit required fields!");
    //return false;
});