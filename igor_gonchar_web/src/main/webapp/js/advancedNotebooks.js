/**
 * Created by i.gonchar on 2/15/2016.
 */

function validateRow1(){
    var doc = document;
    var col1 = doc.getElementById("row1").value;

    var validated = true;

    if (col1 == "") {
        alert('Please fill in name of Vendor');
        validated = false;
    }
    if (validated) {
        var form = doc.getElementById("addVendor");
        form.submit();
    }
}

function validateRow2(){

}

function validateRow3(){
    var doc = document;

    var col1 = doc.getElementById("row3c1").value;
    var col2 = doc.getElementById("row3c2").value;
    var col3 = doc.getElementById("row3c3").value;

    var validated = true;

    if (col1 == "" || col2 == "" || col3 == "") {
        alert('Please fill all fields');
        validated = false;
    }

    if (validated) {
        var form = doc.getElementById("addCPU");
        form.submit();
    }
}