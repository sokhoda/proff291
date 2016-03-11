/**
 * Created by i.gonchar on 3/2/2016.
 */
var doc = document;

function emptyValidation() {
    var login = doc.getElementById('inputLogin').value;
    var password = doc.getElementById('inputPassword').value;

    if (login == null || login == "" || password == null || password == "") {
        alert('Please fill all mandatory fields');
        return false;
    }
    return true;
}

function loginFormValidation(){
var notEmpty = emptyValidation();
    if(notEmpty){
        var form = doc.getElementById('loginForm');
        form.submit();
    }
}

function validateUserEmail() {
    var email = $('#inputEmail').val()
    alert(email)
}
