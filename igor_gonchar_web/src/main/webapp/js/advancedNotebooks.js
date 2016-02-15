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