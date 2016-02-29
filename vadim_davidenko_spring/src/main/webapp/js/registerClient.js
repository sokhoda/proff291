/**
 * Created by v.davidenko on 29.02.2016.
 */

function submitRegisterClientForm() {
    var form = document.registerClientForm;
    if(checkFields(form)) {
    document.getElementById("msg").innerHTML = '';
    form.submit();
    }
    }

function checkFields(form) {
    if(!form.firstName.value.trim() || !form.lastName.value.trim() || !form.phone.value.trim()) {
    alert("Please, fill in all fields with valid values!");
    return false;
    }
    return true;
    }