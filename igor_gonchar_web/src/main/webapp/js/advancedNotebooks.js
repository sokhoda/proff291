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
    var doc = document;

    var col1 = doc.getElementById("row2c1").value;
    var col2 = doc.getElementById("row2c2").value;

    var validated = true;

    if (col1 == "" || col2 == "") {
        alert('Please fill all fields');
        validated = false;
    }
    if (validated) {
        var form = doc.getElementById("addMemory");
        form.submit();
    }
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

function validateRow4(){
    var doc = document;

    var col1 = doc.getElementById("row4c1").value;
    var col2 = doc.getElementById("row4c2").value;
    var col3 = doc.getElementById("row4c3").value;
    var col4 = doc.getElementById("row4c4").value;
    var col5 = doc.getElementById("row4c5").value;

    var validated = true;
    if (col1 == "" || col2 == "" || col3 == "" || col4 == "" || col5 == "") {
        alert('Please fill all fields');
        validated = false;
    }

    if (validated) {
        var form = doc.getElementById("addNotebook");
        form.submit();
    }


}