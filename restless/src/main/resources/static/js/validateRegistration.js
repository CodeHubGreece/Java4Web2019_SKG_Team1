$('document').ready(function(){ 

var lightishRed = "#f69893";
var lightishGreen = "#8fee7a";

function changeDOM(classToChange,message,color){
    	$('#' + classToChange).attr('title', message);
    	$('#' + classToChange).css("background-color", color);
}


//EMAIL VALIDATION
$('#email').on('blur', function(){
  var email = $('#email').val();
   var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(( !re.test(String(email).toLowerCase()))) changeDOM("email", "email not valid", lightishRed);  
    else changeDOM("email", "", lightishGreen);
});


//AMKA VALIDATION
$('#amka').on('blur', function(){
	var amka = $('#amka').val();
	if(amka.toString().length != 10) changeDOM("amka", "amka must be 10 numbers", lightishRed);
	else changeDOM("amka", "", lightishGreen);

	
});


//USERNAME VALIDATION

 $('#username').on('blur', function(){
  var username = $('#username').val();
  if (username == '') {
  	changeDOM("username","empty username",lightishRed);
  	return;
  }
  $.ajax({
    url:  ROOT_PATH + '/user/checkUsername',
    type: 'post',
    data: {  'username' : username, },
    success: function(response){
      if (response == 'taken' )changeDOM("username","username is taken",lightishRed);
      else if (response == 'not taken') changeDOM("username","",lightishGreen);
    }
  });
 });		
 });
