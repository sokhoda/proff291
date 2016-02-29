/**
 * Created by v.davidenko on 29.02.2016.
 */

function submitRegisterForm() {
    var form = document.registerForm;
    if(checkFields(form)) {
        document.getElementById("msg").innerHTML = '';
        form.submit();
    }
}

function checkFields(form) {
    if(!form.login.value.trim() || !form.idNumber.value.trim() || !form.password.value.trim()) {
        alert("Please, fill in all fields with valid values!");
        return false;
    }
    return true;
}
