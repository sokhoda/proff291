/**
 * Created by Pavel on 26.01.2016.
 */

function createRow(row, phone, rest){

    var coll_phone = document.createElement('td');
    var coll_phone_text = document.createElement('input');
    coll_phone_text.setAttribute("value", phone);
    coll_phone_text.disabled = true;
    coll_phone.appendChild(coll_phone_text);
    row.appendChild(coll_phone);

    var coll_rest = document.createElement('td');
    var coll_rest_test = document.createElement('input');
    coll_rest_test.setAttribute("value", rest);
    coll_rest_test.disabled = true;
    coll_rest.appendChild(coll_rest_test);
    row.appendChild(coll_rest);

    var coll_remove = document.createElement('td');
    var coll_remove_button = document.createElement('button');
    coll_remove_button.innerHTML = 'remove';
    coll_remove_button.onclick = function() {
        coll_remove.parentNode.parentNode.removeChild(coll_remove.parentNode);
    }
    coll_remove.appendChild(coll_remove_button);
    row.appendChild(coll_remove);

    var coll_edit = document.createElement('td');
    var coll_edit_button = document.createElement('button');
    coll_edit_button.innerHTML = 'edit';
    coll_edit_button.onclick = function ()  {
        coll_phone_text.disabled = !coll_phone_text.disabled;
        coll_rest_test.disabled = !coll_rest_test.disabled;
        if(coll_edit_button.innerHTML == 'save'){
            coll_edit_button.innerHTML = 'edit';
        } else {
            coll_edit_button.innerHTML = 'save';
        }
    }
    coll_edit.appendChild(coll_edit_button);
    row.appendChild(coll_edit);
}

function createTableTitle(table){
    var row = document.createElement('tr');
    table.appendChild(row);

    var td1 = document.createElement('th');
    var td2 = document.createElement('th');
    td1.setAttribute('align', 'center');
    td1.innerHTML = 'phone'
    td2.innerHTML = 'rest'
    row.appendChild(td1);
    row.appendChild(td2);
}
