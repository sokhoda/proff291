/**
 * Created by s_okhoda on 24.01.2016.
 */

function Phone(no, balance) {
    this.no = no;
    this.balance  = balance;
    this.tariff = 1;
    this.call = function (toNo, minutes){
        if(minutes * this.tariff > this.balance){
            //alert(new Date() + ': невозможно установить соединение:' +
            //    ' недостаточно средств на счету (' + this.balance + ')');
            throw new Error('my error');
        }
        else {
            this.balance -= minutes * this.tariff;
            alert(new Date() + ': абонент номер = ' + this.no + ' звонит' +
                ' абоненту номер = ' + toNo +".\n Новый баланс " + this.balance);
        }
    };
    this.getNo = function(){
        return this.no;
    };
    this.setNo = function(no){
        this.no = no;
    };
    this.getBalance = function(){
        return this.balance;
    };
    this.setBalance = function(balance){
        this.balance = balance;
    };
    this.toString1 = function(){
        return this.getNo() + ', ' + this.getBalance();
    };

}

var tableRows = 3;

function generatePhoneTable(){
    var arr = new Array();
    var i;
    //debugger;
    for ( i = 0; i < tableRows; i++){
        arr.push(new Phone(getRandNumber(), Math.round(Math.random() * 1000)));
        //document.write(arr[i].toString1() + '<br>')
    }
    removeStartButton('createTableButton');
    createTable(arr);
    setAttr('css/table.css');
};

function setAttr(cssFile){
    var head  = document.getElementsByTagName('head')[0];
    var link  = document.createElement('link');
    link.rel  = 'stylesheet';
    link.type = 'text/css';
    link.href = cssFile;
    head.appendChild(link);

}

function getNewTextEdit(value, name, id, clas){
    var edit = document.createElement('input');
    edit.setAttribute("type","text");
    edit.setAttribute("name", name);
    edit.setAttribute("value", value);
    edit.setAttribute("id", id);
    edit.setAttribute("class", clas);

    return edit;
}


function getNewButton(text, name, id, clas){
    var button = document.createElement('button');
    button.setAttribute("type","submit");
    button.setAttribute("name", name);
    button.setAttribute("id", id);
    button.setAttribute("class", clas);
    button.innerText = text;
    return button;
}

function removeStartButton(id){
    var myNode = document.getElementById(id);

    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
    myNode.parentNode.removeChild(myNode);
}

function createTable(arr){
    var body = document.getElementsByTagName('body')[0];


    var tbl = document.createElement('table');
    var row, cell, button;

    for (var i = 0; i < arr.length; i++){
        row = tbl.insertRow(i);
        //row.style.borderBottom = "1px";
        cell = row.insertCell(0);
        cell.setAttribute("class","column-left-bottom");
        cell.appendChild(getNewTextEdit(arr[i].getNo(), 'edit', i + 'edNo', "column-left-bottom"));
        //cell.innerHTML = arr[i].getNo();

        cell = row.insertCell(1);
        cell.setAttribute("class","column-left-bottom right");
        cell.innerHTML = arr[i].getBalance();

        cell = row.insertCell(2);
        cell.setAttribute("class","but");
        cell.appendChild(getNewButton("delete",'delButton', i + 'delButton', "but"));

        cell = row.insertCell(3);
        cell.setAttribute("class","but");
        cell.appendChild(getNewButton("edit",'edButton', i + 'edButton', "but"));
    }

    var theader =  tbl.createTHead();
    row = theader.insertRow(0);

    cell = row.insertCell(0);
    cell.setAttribute("class","column-left-bottom top");
    cell.innerHTML = "<b> Phone Numbers </b>";

    cell = row.insertCell(1);
    cell.setAttribute("class","column-left-bottom top right");
    cell.innerHTML = "<b> Balance </b>"

    //tbl.setAttribute("border","2px");
    //tbl.setAttribute("color","#f00");
    body.appendChild(tbl);

}


function getRandNumber(){
    var codes = ['095', '050', '067', '099', '097'];
    var inx = Math.floor(codes.length * Math.random());
    var str1 = codes[inx];
    for (i = 0; i < 7; i++){
        if (i == 0 || i == 3 || i == 5) {
            str1 += ' ';
        }
        str1 += Math.floor(Math.random() * 10);
    }
    return str1;
}


//var phone1 = new Phone('067 070 07 07', 20);
//alert(phone1.getNo());
//var phone2 = new Phone('095 090 09 09', 25);
//try {
//    phone1.call('095 090 09 09', 10);
//    phone2.call('067 070 07 07', 20);
//    phone2.call('067 070 07 07', 5.5);
//}
//catch(e) {
//    alert(e.name);
//}

