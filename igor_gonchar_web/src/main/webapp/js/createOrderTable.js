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
            for (var i = 0; i < 5; i++) {
                rowColumn = doc.createElement('td');
                setDataInTd(rowColumn, i);

                tableRow.appendChild(rowColumn);
            }
            table.appendChild(tableRow);
        }

        function setDataInTd(rowColumn, count) {
            if (count === 0) {
                content = doc.createTextNode(phones[j].phoneName);
            } else if (count === 1) {
                content = doc.createTextNode(phones[j].number);
            } else if (count === 2) {
                content = doc.createTextNode(phones[j].balance);
            } else if (count === 3){
                editButton = doc.createElement("button");
                content = doc.createTextNode('Edit');
                editButton.appendChild(content);
                rowColumn.appendChild(editButton);
                return;
            } else {
                deleteButton = doc.createElement("button");
                content = doc.createTextNode('Delete');
                deleteButton.appendChild(content);
                rowColumn.appendChild(deleteButton);
                return;
            }
                rowColumn.appendChild(content);
        }
    }
}

