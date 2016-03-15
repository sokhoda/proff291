/**
 * Created by i.gonchar on 3/3/2016.
 */
var doc = document;

function clientDataValidation() {
    var emptyVal = emptyFieldsValidation();

    if (emptyVal) {
        var form = doc.getElementById("addClientForm");
        form.submit();
    }
}

function emptyFieldsValidation() {
    var name = doc.getElementById("clientName").value;
    var surname = doc.getElementById("clientSurname").value;
    var number = doc.getElementById("clientPhone").value;
    var address = doc.getElementById("clientAddress").value;

    if (name == null || name == "" || surname == null || surname == "" || number == null || number == "" || address == null || address == "") {
        alert('Please fill all mandatory fields');
        return false;
    }
    return true;
}

function editClientValidation() {

}

function deleteConfirmation() {
    var conf = confirm('Are you sure you want to delete?');
    if (conf) {
        var form = doc.getElementById("editClientForm");
        form.submit();
    }
}

function clientPathDataValidation() {
    var name = doc.getElementById("addClientFilePath").value;
    if (name == null || name == "") {
        alert('Please fill all mandatory fields');
    } else {
        var form = doc.getElementById("massAddClientForm");
        form.submit();
    }
}
