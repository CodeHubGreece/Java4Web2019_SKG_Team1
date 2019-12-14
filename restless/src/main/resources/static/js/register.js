

function register(){
  

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let email = document.getElementById('email').value;
    let amka = document.getElementById('amka').value;
    let number = document.getElementById('number').value;

       
               $.ajax({
                        url: ROOT_PATH + '/citizen/registration',
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
                        alert("Data Saved: " + JSON.stringify(result));
                    },
                    error: function (xhr, resp, text) {
                        alert("NOT Saved: " + text);
                    }
                })
}

