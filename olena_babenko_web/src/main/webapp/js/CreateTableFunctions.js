/**
 * Created by lenchi on 25.01.16.
 */

//Table creating-------------------------------------------------------------------------
    //loading xml file


function getHash() {
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
        myFunction(xhttp);
    }
};
xhttp.open("GET", "Test.xml", true);
xhttp.send();

function myFunction(xml) {
    var xmlDoc = xml.responseXML;
    document.getElementById("demo").innerHTML =
        xmlDoc.getElementsByTagName("HashTable")[0].childNodes[0].nodeValue;
}
    createHashFromFile(xhttp);

    function createHashFromFile(xml) {
        var x, y, i, xlen, xmlDoc, txt;
        xmlDoc = xml.responseXML;
        x = xmlDoc.getElementsByTagName("HashTable")[0];
        xlen = x.childNodes.length;
        y = x.firstChild;
        txt = "";
        for (i = 0; i < xlen; i++) {
            if (y.nodeType == 1) {
                txt += i + " " + y.nodeName + "<br>";
            }
            y = y.nextSibling;
        }
        alert(txt);
    }
}
//----------------------------------------------------------------------------------------

var tableElement;

function getTableContent() {
    var dataHash = {1: 'Test1', 2: 'Test2', 3: 'Test3'};
    return dataHash;
}

function addDivTableElement(divElement) {
    divElement.setAttribute('id', 'placeTable');

    document.body.appendChild(divElement);
}

function createTable(hash) {
    //header
    tableElement = '<br/><table border=1 id="myTable"><tr><th>ID</th><th>Name</th><th colspan="2"></th></tr>';

    //other content
    for (var key in hash) {
        if (hash.hasOwnProperty(key)) {
            tableElement += '<tr><td>' + key + '</td><td>' + hash[key] + '</td><td><button onclick="removeTableRow(' + key + ')">Delete</button></td></tr>';
        }
    }

    var divElement = document.createElement('div');
    addDivTableElement(divElement);
    //add content to <div id='placeTable'> element
    document.getElementById('placeTable').innerHTML = tableElement;

    hash = getHashFromTable();
}

//Table Content editing-----------------------------------------------------------------

function confirmDelete(key) {
    return confirm('Are you sure in deletion the row with ID = ' + key + '?');
}

function removeTableRow(key) {
    var hash = getTableContent();
    delete hash[key];

    if (confirmDelete(key) == true) {
        createTable(hash);
    }
}

function getHashFromTable() {
    var updatedHash = {};

    function getKeyUpdatedHash(i) {
        return document.getElementById('myTable').rows[i].cells[0].innerHTML;
    }

    function getValueUpdatedHash(i) {
        return document.getElementById('myTable').rows[i].cells[1].innerHTML;
    }

    for (var i = 1; i < document.getElementById('myTable').rows.length; i++) {
        updatedHash[getKeyUpdatedHash(i)] = getValueUpdatedHash(i);
        //alert(getKeyUpdatedHash(i)+' '+getValueUpdatedHash(i));
    }

    return updatedHash;
}

