/**
 * Created by i.gonchar on 1/28/2016.
 */
/*phonesArray = {
 phone1: {number: '1111', balance: 100},
 phone2: {number: '2222', balance: 200},
 phone3: {number: '3333', balance: 300}
 };*/

phones = [
    {phoneName: 'iPhone', number: '+380 5554433', balance: '1000.00'},
    {phoneName: 'Samsung', number: '+380 1112233', balance: '500.00'},
    {phoneName: 'Lenovo', number: '+380 9998877', balance: '300.00'},
    {phoneName: 'Lenovo', number: '+380 9998877', balance: '300.00'},
    {phoneName: 'Sony', number: '+380 2225511', balance: '600.00'}
];

createdTable = false;

function createTable() {

    if (!createdTable) {
        var doc = document;
        wrappedDiv = doc.getElementById("tableDiv");


        table = doc.createElement('table');
        table.border = "1";
        table.id = 'mainTable';

        createTableHeader(table);
        wrappedDiv.appendChild(table);
        successTony();
        createdTable = true;
    }

    else {
        alert('Table is already created');
    }

    /* removeTable(wrappedDiv);
     function removeTable(wrappedDiv){
     wrappedDiv.removeChild(doc.getElementById('mainTable'));*/

    function createTableHeader(table) {
        var doc = document;

        for (var j = 0; j < phones.length; j++) {

            tableRow = doc.createElement('tr');
            for (var i = 0; i < 6; i++) {
                rowColumn = doc.createElement('td');
                setDataInTd(rowColumn, i);

                tableRow.appendChild(rowColumn);
            }
            table.appendChild(tableRow);
        }

        function setDataInTd(rowColumn, count) {
            var input = doc.createElement('input');
            if (count === 0) {
                // content = doc.createTextNode(phones[j].phoneName);
                input.value = phones[j].phoneName;

            } else if (count === 1) {
                // content = doc.createTextNode(phones[j].number);
                input.value = phones[j].number;
            } else if (count === 2) {
                //  content = doc.createTextNode(phones[j].balance);
                input.value = phones[j].balance;
            } else if (count === 3) {
                editButton = doc.createElement("button");
                content = doc.createTextNode('Edit');
                editButton.appendChild(content);
                editButton.onclick = function () {
                    editPhone(this);
                };
                rowColumn.appendChild(editButton);
                return;
            } else if (count === 4) {
                deleteButton = doc.createElement("button");
                content = doc.createTextNode('Delete');
                deleteButton.appendChild(content);
                deleteButton.onclick = function () {
                    deletePhone(this);
                };
                rowColumn.appendChild(deleteButton);
                return;
            }
            else {
                confirmButton = doc.createElement("button");
                content = doc.createTextNode('Confirm');
                confirmButton.appendChild(content);
                confirmButton.onclick = function () {
                    submitPhone(this);
                };
                rowColumn.appendChild(confirmButton);
                return;
            }
            // input.appendChild(content);
            input.disabled = true;
            input.id = 'row' + j + 'colmn' + count;
            rowColumn.appendChild(input);
            console.log(input.id);
        }
    }

}
function deletePhone(elem) {
    var reply = confirm('Delete this row?');
    if (reply) {
        var index = elem.parentNode.parentNode.rowIndex;
        document.getElementById('mainTable').deleteRow(index);
    }
}

function editPhone(elem) {
    var tr = elem.parentNode.parentNode;
    var numberField = tr.childNodes[1].firstElementChild;
    numberField.disabled = false;
    var balanceField = tr.childNodes[2].firstElementChild;
    balanceField.disabled = false;
}

function submitPhone(elem) {

    var tr = elem.parentNode.parentNode;
    var numberField = tr.childNodes[1].firstElementChild;
    numberField.disabled = true;
    var balanceField = tr.childNodes[2].firstElementChild;
    balanceField.disabled = true;
}

function successTony() {
    var doc = document;
    elem = doc.createElement('img');
    elem.setAttribute("src", "http://dayfun.ru/wp-content/uploads/2014/11/%D0%9A%D0%B0%D0%BA-%D1%80%D0%B8%D1%81%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-%D0%A0%D0%BE%D0%B1%D0%B5%D1%80%D1%82%D0%B0-%D0%94%D0%B0%D1%83%D0%BD%D0%B8.jpg");
    document.getElementById("imagePlage").appendChild(elem);
}
