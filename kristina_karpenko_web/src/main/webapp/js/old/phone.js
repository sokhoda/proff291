

function addPhone(name, telephoneNumber, balance, operator) {
    var entry = [name, telephoneNumber,balance,operator],
        tableContent = "<tr>";

    for(var i = 0; i < 4; i++){
        tableContent += "<td>" + entry[i] + "</td>" ;

    };
     tableContent += "<td>"+'<input type="button" value="Edit" onclick="edit(this)" />'+'</td>'+'<td>'+'<input type="button" value="Delete" onclick="Delete(this)"/>'+"</td>"+"</tr>";
    tableBodyExample.innerHTML += tableContent;
}
//-------------------------------------------------------------------
function Delete(obj) {
    var row = obj.parentNode.parentNode;
    row.parentNode.removeChild(row);
}
//-------------------------------------------------------------------
function edit(input) {
    var tr = input.parentNode.parentNode;

    var td = tr.childNodes[0];
    var SurName = td.firstElementChild;
    SurName.disabled = false;

    var td  = tableBodyExample.innerHTML;
    /* td = tr.childNodes[2];
     var balanceField = td.firstElementChild;
     balanceField.disabled = false;
 */
}
