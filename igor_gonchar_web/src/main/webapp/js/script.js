var mainArray = [1, 2, 3, 4, 5, 6, 7, 8];
var temp;
for (var i = 0; i < 3; i++) {
    temp = mainArray[i];
    mainArray[i] = mainArray[mainArray.length - i - 1];
    mainArray[mainArray.length - i - 1] = temp;
}

function functionName() {
    alert('Function message');
}

function aaa() {

    var conf = confirm('Do you want to start telephones?');

    if (conf) {
        function Telephone(telNumber, balance) {
            this.balanceTotal = balance;
            this.tarif = 2;
            this.call = function (duration) {
                var amount = duration * this.tarif;
                if (amount < this.balanceTotal) {
                    this.balanceTotal -= amount;
                    alert('You may call, your balance left' + this.balanceTotal);
                } else {
                    alert('Not enough money');
                }
            }
        }

        var phone1 = new Telephone(11111, 30);
        var phone2 = new Telephone(22222, 20);
        phone1.call(10);
        phone1.call(2);
        phone1.call(40);
    }
    else {
        alert('As you wish');
    }

}

function createTree(el, tabs) {
    tabs = '&nbsp;&nbsp;&nbsp;'
    document.write(tabs + node.tagName + '<br/>');
    for (var i = 0; i < node.childNodes.length; i++) {
        createTree(node.childNodes.item(i), tabs);
    }
}
/*    var doc = document.documentElement;

 document.write(doc.nodeType);
 document.write(doc.tagName);
 document.write(doc.childNodes);*/
