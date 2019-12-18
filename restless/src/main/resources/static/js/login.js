function login(usernameElement, passwordElement) {
    let username =
        usernameElement && usernameElement.value ? usernameElement.value : "";
    let password =
        passwordElement && passwordElement.value ? passwordElement.value : "";

    let fd = new FormData();
    fd.append("username", username);
    fd.append("password", password);

    $.ajax({
        url: ROOT_PATH + "/login",
        data: fd,
        processData: false,
        contentType: false,
        type: "POST",
        success: function () {
            sessionStorage.setItem(LOCAL_STORAGE_LOGIN_TOKEN_NAME, username);
            $.ajax({
                url: ROOT_PATH + '/users',
                type: 'POST',
                data: { 'username': sessionStorage.getItem(LOCAL_STORAGE_LOGIN_TOKEN_NAME), },
                success: function (response) {
                    sessionStorage.setItem(LOCAL_STORAGE_LOGIN_TOKEN_ID, response.id);
                    sessionStorage.setItem(LOCAL_STORAGE_LOGIN_TOKEN_ROLE, response.type);
                    if (response.type == 'c') {
                        window.location.replace(ROOT_PATH + "/citizens/dashboard.html");
                    }
                    else if (response.type == 'd') {
                        window.location.replace(ROOT_PATH + "/doctors/dashboard.html");
                    }
                }
            });
        },
        statusCode: {
            401: function () {
                alert("Invalid username or password!");
            }
        }
    });
}

$(document).ready(function () {
    $("#loginForm").on("keyup", function (event) {
        if (event.keyCode === 13) {
            login(
                document.getElementById("username"),
                document.getElementById("password")
            );
        }
    });
});
