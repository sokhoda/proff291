/**
 * Created by Вадим on 23.01.2016.
 */

var phones = [ {
    phoneName: 'iPhone',
    number: '+380 5554433',
    balance: '1000.00'
},{
    phoneName: 'Samsung',
    number: '+380 1112233',
    balance: '500.00'
}, {
    phoneName: 'Lenovo',
    number: '+380 9998877',
    balance: '300.00'
} ];

var table = document.getElementById('telephones');

init(phones, table);

function init(phones, table) {

    for (var i=0; i<phones.length; i++) {
        var tr = document.createElement('tr');
        table.appendChild(tr);

        var td1 = document.createElement('td');
        td1.innerHTML = phones[i].phoneName;
        tr.appendChild(td1);

        var td2 = document.createElement('td');
        tr.appendChild(td2);
        var input2 = document.createElement('input');
        input2.id = 'phoneNumber';
        input2.name = 'phoneNumber';
        input2.type = 'text';
        input2.size = '15';
        input2.disabled = 'true';
        input2.value = phones[i].number;
        td2.appendChild(input2);

        var td3 = document.createElement('td');
        tr.appendChild(td3);
        var input3 = document.createElement('input');
        input3.id = 'balance';
        input3.name = 'balance';
        input3.type = 'text';
        input3.size = '15';
        input3.disabled = 'true';
        input3.value = phones[i].balance;
        td3.appendChild(input3);

        var td4 = document.createElement('td');
        tr.appendChild(td4);
        var input4 = document.createElement('input');
        input4.type = 'button';
        input4.value = 'Update';
        input4.onclick = updatePhone(this);
        td4.appendChild(input4);

        var td5 = document.createElement('td');
        tr.appendChild(td5);
        var input5 = document.createElement('input');
        input5.type = 'button';
        input5.value = 'Delete';
        input5.onclick = deletePhone(this);
        td5.appendChild(input5);
    }

}

function updatePhone(phone) {

}

function deletePhone(phone) {

}
