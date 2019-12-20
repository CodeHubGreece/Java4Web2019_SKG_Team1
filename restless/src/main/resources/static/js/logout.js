function logout() {
    $.ajax({
        url: ROOT_PATH + '/logout',
        type: 'POST',
        success: function () {
            sessionStorage.removeItem(LOCAL_STORAGE_LOGIN_TOKEN_ID);
            sessionStorage.removeItem(LOCAL_STORAGE_LOGIN_TOKEN_NAME);
            sessionStorage.removeItem(LOCAL_STORAGE_LOGIN_TOKEN_ROLE);
            window.location.replace(ROOT_PATH);
        },
        error: function () {
            Swal.fire({
                icon: 'error',
                title: 'Logout failed!',
                text: 'Something went wrong',
            });
        }
    });
}