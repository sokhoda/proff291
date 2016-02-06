/**
 * Created by Юлия on 24.01.2016.
 */


function telephone(number, balance) {

    this.number = number;
    this.balance = balance;
}
var vector = new Array();
vector[0] = new telephone("09312123123", 100);
vector[1] = new telephone("09876545123", 150);
vector[2] = new telephone("0543241892", 200);
vector[3] = new telephone("0972627861", 600);
vector[4] = new telephone("0671928767", 50);
vector[5] = new telephone("0502721718", 10);
vector[6] = new telephone("0631818181", 0);
vector[7] = new telephone("0981425626", 78);


/*
 function createTable() {
 var table='<table border="1" align="center"> <tr>';
 table+='<th> Telephone Number</th><th>Balance</th></tr>'
 for(var i=0; i<=vector.length-1; i++){

 table +='<tr><td>'+vector[i].number+'</td><td>'+vector[i].balance+'</td></tr>';

 }
 table += '<table>';
 document.write(table);

 }*/

//function title(table) {
//
//    for (var i = 0; i < vector.length; i++) {
//        var tr = document.createElement('tr');
//        for (var j = 0; j < i; j++) {
//            var th = document.createElement('th');
//            if (i === 0) {
//                th.appendChild(document.createTextNode('Number'));
//                tr.appendChild(th);
//            }
//            if (i === 1) {
//                th.appendChild(document.createTextNode('Balance'));
//                tr.appendChild(th);
//            }
//            if (i === 2) {
//                th.appendChild(document.createTextNode('Delete'));
//                tr.appendChild(th);
//            }
//            if (i === 3) {
//                th.appendChild(document.createTextNode('Edit'));
//                tr.appendChild(th);
//            }
//
//        }
//
//    }
//    table.appendChild(tr);
//
//
//}

function tableCreate() {
    var body = document.getElementsByTagName('body')[0];
    var tbl = document.createElement('table');
    tbl.id = 'Table';
    tbl.setAttribute('border', '1');
    tbl.setAttribute('align', 'center');
    tbl.setAttribute('style', '25%')
    var tbdy = document.createElement('tbody');


    for (var i = 0; i < vector.length; i++) {
        var tr = document.createElement('tr');


        for (var j = 0; j < 4; j++) {
            var td = document.createElement('td');
            if (j < 1) {

                td.appendChild(document.createTextNode(vector[i].number));
                tr.appendChild(td);
            }
            if (j === 1) {

                td.appendChild(document.createTextNode(vector[i].balance));
                tr.appendChild(td);


            }
            if (j === 2) {

                td.appendChild(createButtonDel());
                tr.appendChild(td);


            }
            if (j === 3) {

                td.appendChild(createButtonEdit());
                tr.appendChild(td);

            }
        }
        tbdy.appendChild(tr);
    }
    tbl.appendChild(tbdy);
    body.appendChild(tbl)
}

function createButtonDel() {
    var button = document.createElement('input');
    button.type = 'button';
    button.value = 'Delete';
    button.id = 'remove';
    button.style = '25%';
    button.onclick = function () {
        btnDel(this);
    }
    return button;
}

function createButtonEdit() {
    var button = document.createElement('input');
    button.type = 'button';
    button.style = '25%';
    button.value = 'Edit';
    button.id = 'Input';
    button.onclick = function () {
        btnEdit(this);
    }

    return button;
}


function btnEdit(value) {
    var row = value.parentNode.parentNode;




}


function btnDel(obj) {
    var row = obj.parentNode.parentNode;
    row.parentNode.removeChild(row);


}


