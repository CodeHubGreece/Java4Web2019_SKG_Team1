function register() {

    if ($(".invalid")[0]) {
        Swal.fire({
            icon: 'error',
            title: 'Registration error!',
            text: 'One or more fields are wrong',
        });
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
            username: username,
            password: password,
            first_name: firstName,
            last_name: lastName,
            phone_num: number,
            email: email,
            amka: amka
        }),
        contentType: 'application/json',
        success: function (citizen) {
            login(document.getElementById('username'), document.getElementById('password'));
        },
        error: function (xhr, resp, text) {
            Swal.fire({
                icon: 'error',
                title: 'Registration failed!',
                text: 'Something went wrong',
            });
        }
    })
}

$(document).ready(function () {
    $("#registerForm").on("keyup", function (event) {
        if (event.keyCode === 13) {
            register();
        }
    })
})