function register(){

    if ($(".invalid")[0]){
        alert("invalid or missing fields");
        return;
    }
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let email = document.getElementById('email').value;
    let amka = document.getElementById('amka').value;
    let number = document.getElementById('number').value;
               $.ajax({
                        url: ROOT_PATH + '/citizens/register',
                        type: 'POST',
                         dataType: 'json',
                         data: JSON.stringify({
                         username:username,
                         password:password,
                         first_name:firstName,
                         last_name:lastName,
                         phone_num:number,
                         email:email,
                         amka:amka
                    }),
                    contentType: 'application/json',
                    success: function (result) {
                        //alert("Data Saved ");
                        window.location.replace("/citizens/dashboard.html")
                    },
                    error: function (xhr, resp, text) {
                        alert("NOT Saved: " + text);
                    }
                })
}

$(document).ready(function (){
    $("#registerForm").on("keyup",function(event){
        if(event.keyCode === 13){
            register();
        }
    })
})