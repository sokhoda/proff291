
var phone = [
    { number: '+380978183773', balance: '15'},
    { number: '+380678172763', balance: '73'},
    { number: '+380978378291', balance: '53'},
    { number: '+380978518989', balance: '278'}
];

var created = false;

function createTable() {
    if ( !created ) {
        var table = document.createElement('table');
        table.id = 'phones';
        table.border = '0';
        table.align = 'center';

        var div = document.getElementById("div");
        div.appendChild(table);

        var tr = document.createElement('tr');
        table.appendChild(tr);

        var colName = ['Number', 'Balance'];
        for ( var i = 0; i < colName.length; i++ ) {
            var th = document.createElement('th');
            th.border = '1';
            tr.appendChild(th);
            th.innerHTML = colName[i];
        }
        addPhones();

        created = true;
    }
}

function addPhones() {
    var table = document.getElementById('phones');
    for ( var i = 0; i < phone.length; i++ ) {
        var tr = document.createElement('tr');
        table.appendChild(tr);
        var td = document.createElement('td');
        td.border = '1';
        tr.appendChild(td);
        var input = document.createElement('input');
        td.appendChild(input);
        input.type = 'text';
        input.size = '13';
        input.disabled = true;
        input.value = phone[i].number;

        var td = document.createElement('td');
        td.border = '1;'
        tr.appendChild(td);
        var input = document.createElement('input');
        td.appendChild(input);
        input.type = 'text';
        input.size = '13';
        input.disabled = true;
        input.value = phone[i].balance;

        var editButton = document.createElement("button");
        var content = document.createTextNode('Edit');
        editButton.appendChild(content);
        editButton.onclick = function () {
            editPhone(this);
        };
        tr.appendChild(editButton);

        var deleteButton = document.createElement("button");
        var content = document.createTextNode('Delete');
        deleteButton.appendChild(content);
        deleteButton.onclick = function () {
            deletePhone(this);
        };
        tr.appendChild(deleteButton);
    }
}

function editPhone(element) {

}

function deletePhone(element) {

}


