/**
 * Created by Сергей on 24.01.2016.
 */
var tarif = 10;

function Phone () {
    this.number;
    this.balance;
    this.call = function (minute) {
        if ((minute*tarif)>this.balance) {
            console.log('Нет возможности выполнить вызов, недостаточно средств. Номер '+ this.number);
        } else {
            console.log('Номер '+ this.number + ' выполняет звонок, со счета будет списано ' + minute*tarif);
            this.balance=this.balance-minute*tarif;
        }
    }
}

var phone1 = new Phone();
var phone2 = new Phone();

phone1.number=111;
phone2.number=222;
phone1.balance=50;
phone2.balance=100;

phone1.call(5);
console.log(phone1.balance);
phone2.call(11);
console.log(phone2.balance);