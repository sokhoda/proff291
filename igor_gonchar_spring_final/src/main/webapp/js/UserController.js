/**
 * Created by i.gonchar on 3/1/2016.
 */
var doc = document;

function registerFormValidation() {
    var emptyVal = emptyFieldsValidation();
    if (emptyVal) {
        rePasswordValidation();
    }
}

function rePasswordValidation() {
    var password = doc.getElementById("passwordField").value;
    var rePassword = doc.getElementById("rePasswordField").value;

    if (password != rePassword) {
        alert('Password is not not equal')
    } else {
        var form = doc.getElementById("registerForm");
        form.submit();
    }
}

function emptyFieldsValidation() {
    var password = doc.getElementById("passwordField").value;
    var rePassword = doc.getElementById("rePasswordField").value;
    var login = doc.getElementById("loginField").value;
    var idNumber = doc.getElementById("idNumberField").value;

    if (login == null || login == "" || idNumber == null || idNumber == "" || password == null || password == "" || rePassword == null || rePassword == "") {
        alert('Please fill all mandatory fields');
        return false;
    }
    return true;
}