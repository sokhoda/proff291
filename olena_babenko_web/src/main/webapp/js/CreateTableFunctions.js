/**
 * Created by lenchi on 25.01.16.
 */
//Table creating-------------------------------------------------------------------------

function getTableContent() {
    dataHash = {1: 'Test1', 2: 'Test2', 3: 'Test3'};
    return dataHash;
}

function addDivTableElement() {
    var divElement = document.createElement('div');
    divElement.setAttribute('id', 'placeTable');

    document.body.appendChild(divElement);
}

function createTable(hash) {
    var tableElement;

    //header
    tableElement = '<br/><table border=1><tr><td>ID</td><td>Name</td></tr>';

    //other content
    for (var key in hash) {
        if (hash.hasOwnProperty(key)) {
            tableElement += '<tr><td>' + key + '</td><td>' + hash[key] + '</td></tr>';
        }
    }

    addDivTableElement();
    //add content to <div id='placeTable'> element
    document.getElementById('placeTable').innerHTML = tableElement;
}

//Table Content editing-----------------------------------------------------------------


