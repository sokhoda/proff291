/**
 * Created by i.gonchar on 2/10/2016.
 */


function connectionSuccess() {
    alert('Evrth is OK');
}

function validateRow1() {
    /* var doc = document;
     var col1 = doc.getElementById("r1c1").value();
     alert(col1);*/

    var doc = document;
    var col1 = doc.getElementById("r1c1").value;
    var col2 = doc.getElementById("r1c2").value;
    var col3 = doc.getElementById("r1c3").value;
    var col5 = doc.getElementById("r1c5").value;

    var validated = true;

    if (col1 == "" || col2 == "" || col3 == "" || col5 == "") {
        alert('Please fill all mandatory fields');
        validated = false;
    }

    if (validated) {
        var form = doc.getElementById("form1");
        form.submit();
    }
}

function validateRow2() {

    var doc = document;
    var col1 = doc.getElementById("r2c1").value;

    var validated = true;

    if (col1 == "") {
        alert('Please fill in ID');
        validated = false;
    }

    if (validated) {
        var form = doc.getElementById("form2");
        form.submit();
    }
}