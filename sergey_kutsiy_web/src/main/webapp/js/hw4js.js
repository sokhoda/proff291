/**
 * Created by skuciy on 27.01.2016.
 */
var doc = document.documentElement;
var tableSise;
var table;
var newRow;

var addRow = function () {
    tableSise = prompt('Number of rows:', 1);
    table = document.getElementById("table");
    for (var i=0; i<tableSise; i++) {
        newRow = document.createElement('tr');
        newRow.innerHTML='<tr><td width="200"></td> <td width="200"></td></tr> <td width="200"><button style="width: 50px" name="Edit" onclick="editRow(this)">Edit</button><button name="Delete" onclick="deleteRow(this)">Delete</button></td>';
        table.appendChild(newRow);
    }
}

var editRow = function (elemEdit) {
    var curBut = elemEdit.parentNode;
    var curTd = curBut.parentNode;
    curTd.innerHTML='<tr><td width="200"><input type="text" size="13"/></td> <td width="200"><input type="text" size="4"/></td></tr> <td width="200"><button style="width: 50px" name="Save" onclick="saveRow(this)">Save</button><button name="Delete" onclick="deleteRow(this)" disabled>Delete</button></td>';
}

var deleteRow = function (elemDel) {
    var curBut = elemDel.parentNode;
    var curTd = curBut.parentNode;
    var curTr = curTd.parentNode;
    curTr.removeChild(curTd);
}

var saveRow = function (elemSave) {
    var curBut = elemSave.parentNode;
    var curTd = curBut.parentNode;
    var curTr = curTd.parentNode;
    curTd.innerHTML='<tr><td width="200">'+curTr.getElementsByTagName('input')[0].value+'</td> <td width="200">'+curTr.getElementsByTagName('input')[1].value+'</td></tr> <td width="200"><button  style="width: 50px" name="Edit" onclick="editRow(this)">Edit</button><button name="Delete" onclick="deleteRow(this)">Delete</button></td>';
}