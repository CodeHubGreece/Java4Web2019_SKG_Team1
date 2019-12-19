$('document').ready(function(){ 

var lightishRed = "#ff8787";
var lightishGreen = "#8fee7a";

function changeDOM(classToChange,message,color,isValid){
    	$('#' + classToChange).attr('title', message);
    	$('#' + classToChange).css("background-color", color);
        if(isValid) $('#' + classToChange).addClass("valid").removeClass("invalid");
        else  $('#' + classToChange).addClass("invalid").removeClass("valid");

}


//EMAIL VALIDATION
$('#email').on('blur', function(){
  var email = $('#email').val();
   var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(( !re.test(String(email).toLowerCase()))) changeDOM("email", "email not valid", lightishRed,false);
    else changeDOM("email", "", lightishGreen,true);
});


//AMKA VALIDATION
$('#amka').on('blur', function(){
	var amka = $('#amka').val();
	if(amka.toString().length != 11) {
        changeDOM("amka", "amka must be 11 numbers", lightishRed, false);
        return;
    }

    changeDOM("amka", "", lightishGreen,true);
    $.ajax({
        url:  ROOT_PATH + '/users/checkAmka',
        type: 'post',
        data: {  'amka' : amka, },
        success: function(response){
            if (response ==  true)changeDOM("amka","AMKA is taken",lightishRed,false);
            else if (response == false) changeDOM("amka","",lightishGreen,true);
        },
        statusCode: {
            400: function(){
                changeDOM("amka", "Wrong AMKA", lightishRed, false);
            }
        }
    });
	
});


//USERNAME VALIDATION
 $('#username').on('blur', function(){
  var username = $('#username').val();
  if (username == '') {
  	changeDOM("username","empty username",lightishRed,false);
  	return;
  }
  $.ajax({
    url:  ROOT_PATH + '/users/checkUsername',
    type: 'post',
    data: {  'username' : username, },
    success: function(response){
      if (response == true )changeDOM("username","Username is taken",lightishRed,false);
      else if (response == false) changeDOM("username","",lightishGreen,true);
    }
  });
 });

 //PASSWORD
    $('#password').on('blur', function() {
        var password = $('#password').val();
        if (password.toString().length < 4) {
            changeDOM("password","Password is too small",lightishRed,false);
        }
        else  changeDOM("password","",lightishGreen,true);

    });

    //FIRSTNAME
    $('#firstName').on('blur', function() {
        var firstName = $('#firstName').val();
        if (firstName.toString().length ===0) {
            changeDOM("firstName","First name is too small",lightishRed,false);
        }
        else  changeDOM("firstName","",lightishGreen,true);

    });

    //LASTNAME
    $('#lastName').on('blur', function() {
        var lastName = $('#lastName').val();
        if (lastName.toString().length ===0) {
            changeDOM("lastName","Last name is too small",lightishRed,false);
        }
        else  changeDOM("lastName","",lightishGreen,true);

    });

    //PHONENUMBER
    $('#number').on('change', function() {
        var number = $('#number').val();
        if (number.toString().length < 5) {
            changeDOM("number"," Phone number is too small",lightishRed,false);
        }
        else  changeDOM("number","",lightishGreen,true);

    });

 });