/**
 * Created by Solyk on 24.01.2016.
 */

function Phone(){
    this.tor = 2;
    this.numberOfPhone = '';
    this.balance = 100;

    this.call = function(min){
        var titi = this.tor * min;
        if(this.balance < titi){
            console.log('Не достаточно средств для звонка');
            //throw 'Error';
        } else {
            this.balance = this.balance - (this.tor * min);
        }
    };
};

var phone1 = new Phone();
phone1.numberOfPhone = '0937042674';
phone1.call(5);
var phone2 = new Phone();
phone2.tor = 4;
phone2.numberOfPhone = '0937042675';
phone2.call(10);
alert(phone1.numberOfPhone + ' balance ' + phone1.balance.toString());
alert(phone2.numberOfPhone + ' balance ' + phone2.balance.toString());
phone2.call(40);
alert(phone2.numberOfPhone + ' balance ' + phone2.balance.toString());

var doc  = document.documentElement;
//document.write('empty');
var i = 0;

while(i < doc.childNodes.length){
    document.write(doc.childNodes.length);
    document.write(doc.childNodes.item(i));
    i++
}
//document.write(doc.nodeType);//1
//document.write(doc.tagName);//HTML
//document.write(doc.childNodes);//[object NodeList]
//document.write(doc.childNodes.length);//length()
//document.write(doc.childNodes.item());
