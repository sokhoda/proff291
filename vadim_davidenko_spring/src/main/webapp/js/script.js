/**
 * Created by v.davidenko on 02.03.2016.
 */

//////////////////////////////////////////////////////////////////
// Dashboard

function onOrderEditClick() {
    var id = document.getElementById('id').value;
    if (!id.trim() || isNaN(+id)) {
        alert("Please, fill in Id field with valid value!");
        return;
    }
    document.location='/order/edit/' + id;
}

function onShowClientsByGtSumClick() {
    var sum = document.getElementById('sum').value;
    if (!sum.trim() || isNaN(+sum)) {
        alert("Please, fill in Sum field with valid value!");
        return;
    }
    document.location='/clients/' + sum;
}

function onShowOrdersOnSumClick() {
    var sumFrom = document.getElementById('sumFrom').value;
    if (!sumFrom.trim() || isNaN(+sumFrom)) {
        alert("Please, fill in Sum field with valid value!");
        return;
    }
    var sumTo = document.getElementById('sumTo').value;
    if (!sumTo.trim() || isNaN(+sumTo)) {
        alert("Please, fill in Sum field with valid value!");
        return;
    }
    document.location='/orders/?sumFrom=' + sumFrom + '?sumTo=' + sumTo;
}

//////////////////////////////////////////////////////////////////
// Order form

function submitOrderForm() {
    var form = document.getElementById("orderForm");
    if(checkOrderFields(form)) {
        document.getElementById("msg").innerHTML = '';
        form.submit();
    }
}

function checkOrderFields(form) {
    if(!form.amount.value.trim() || isNaN(+form.amount.value) ||
        !form.addressFrom.value.trim() || !form.addressTo.value.trim()) {
        alert("Please, fill in all fields with valid values!");
        return false;
    }
    return true;
}

//////////////////////////////////////////////////////////////////
// User form

function submitUserForm() {
    var form = document.getElementById("userForm");
    if(checkUserFields(form)) {
        document.getElementById("msg").innerHTML = '';
        form.submit();
    }
}

function checkUserFields(form) {
    if(!form.login.value.trim() || !form.idNumber.value.trim() || !form.password.value.trim()) {
        alert("Please, fill in all fields with valid values!");
        return false;
    }
    return true;
}

//////////////////////////////////////////////////////////////////
// Client form

function submitClientForm() {
    var form = document.getElementById("clientForm");
    if(checkClientFields(form)) {
        document.getElementById("msg").innerHTML = '';
        form.submit();
    }
}

function checkClientFields(form) {
    if(!form.name.value.trim() || !form.surname.value.trim() ||
        !form.phone.value.trim()) {
        alert("Please, fill in all fields with valid values!");
        return false;
    }
    return true;
}


