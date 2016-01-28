/**
 * Created by Вадим on 23.01.2016.
 */

var PhonesTable = {
    phones: [],
    createTableHTML: function() {
        var table = document.createElement('table');
        document.body.appendChild(table);
        table.id = 'telephones';
        table.border = '0';
        table.cellPadding = '6';
        table.align = 'center';
        table.style = 'background-color: #d4ecff';

        addTableHeader(table);
        addPhonesData(table);
    }
};

PhonesTable.phones = [
    { phoneName: 'iPhone', number: '+380 5554433', balance: '1000.00' },
    { phoneName: 'Samsung', number: '+380 1112233', balance: '500.00' },
    { phoneName: 'Lenovo', number: '+380 9998877', balance: '300.00'},
    { phoneName: 'Sony', number: '+380 2225511', balance: '600.00'}
];
PhonesTable.createTableHTML();

function addTableHeader(table) {
    var doc = document;
    var tr = doc.createElement('tr');
    table.appendChild(tr);
    var colNames = ['Telephones', 'Number', 'Balance', 'Actions'];
    for (var i = 0; i < colNames.length; i++) {
        var th = doc.createElement('th');
        tr.appendChild(th);
        th.innerHTML = colNames[i];
        if (i == 3) {
            th.colSpan = '2';
            th.style = 'align: center';
        }
    }
    tr = document.createElement('tr');
    table.appendChild(tr);
    var td = doc.createElement('td');
    tr.appendChild(td);
    td.colSpan = '5';
    var hr = doc.createElement('hr');
    td.appendChild(hr);
}

function addPhonesData(table) {
    var doc = document;
    for (var i = 0; i <PhonesTable.phones.length; i++) {
        var tr = doc.createElement('tr');
        table.appendChild(tr);

        var td = doc.createElement('td');
        tr.appendChild(td);
        td.innerHTML = PhonesTable.phones[i].phoneName;

        td = doc.createElement('td');
        tr.appendChild(td);
        var input = doc.createElement('input');
        td.appendChild(input);
        input.id = 'phoneNumber';
        input.name = 'phoneNumber';
        input.type = 'text';
        input.size = '15';
        input.disabled = 'true';
        input.value = PhonesTable.phones[i].number;

        td = doc.createElement('td');
        tr.appendChild(td);
        input = doc.createElement('input');
        td.appendChild(input);
        input.id = 'balance';
        input.name = 'balance';
        input.type = 'text';
        input.size = '10';
        input.disabled = 'true';
        input.value = PhonesTable.phones[i].balance;

        td = doc.createElement('td');
        tr.appendChild(td);
        input = doc.createElement('input');
        td.appendChild(input);
        input.type = 'button';
        input.value = 'Update';
        input.onclick = function() {
            updatePhone(this);
        };

        td = doc.createElement('td');
        tr.appendChild(td);
        input = doc.createElement('input');
        td.appendChild(input);
        input.type = 'button';
        input.value = 'Delete';
        input.onclick = function() {
            deletePhone(this);
        };
    }
}

function updatePhone(input) {
    var tr = input.parentNode.parentNode;

    var td = tr.childNodes[1];
    var numberField = td.firstElementChild;
    numberField.disabled = false;

    td = tr.childNodes[2];
    var balanceField = td.firstElementChild;
    balanceField.disabled = false;

}

function deletePhone(input) {
    if(!confirm('Are you sure to delete this phone?')) {
        return;
    }
    var index = input.parentNode.parentNode.rowIndex;
    document.getElementById('telephones').deleteRow(index);



}
