/**
 * Created by i.gonchar on 3/3/2016.
 */
var doc = document;

function clientDataValidation(){
    var emptyVal = emptyFieldsValidation();

    if(emptyVal){
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

function editClientValidation(){

}