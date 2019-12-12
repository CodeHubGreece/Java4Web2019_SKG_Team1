const ROOT_PATH = "http://localhost:8080";

    function login(){

        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;
        let email = document.getElementById('email').value;
        let amka = document.getElementById('amka').value;
        let firstName = document.getElementById('firstName').value;
        let lastName = document.getElementById('lastName').value;
        let phoneNum = document.getElementById('phone').value;

        $.ajax({
          url: ROOT_PATH + '/citizen/registration',
          type: 'POST',
          dataType: 'json',
          data: JSON.stringify({

            	username: username,
            	password: password,
            	first_name: firstName,
            	last_name:lastName,
            	phone_num: phoneNum
            	email : email,
            	amka :amka
            }),
          contentType: 'application/json',
           success: function (result) {
                             alert("Data Saved: " + JSON.stringify(result));
                              },
                              error: function (xhr, resp, text) {
                               alert("NOT Saved: " + text);
                              }
        });
       }










(function ($) {
    "use strict";

    
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }


})(jQuery);
