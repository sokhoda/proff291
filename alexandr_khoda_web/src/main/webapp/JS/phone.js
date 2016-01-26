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
    }
}

var phone1 = new Phone('067 070 07 07', 20);
var phone2 = new Phone('095 090 09 09', 25);
try {
    phone1.call('095 090 09 09', 10);
    phone2.call('067 070 07 07', 20);
    phone2.call('067 070 07 07', 5.5);
}
catch(e) {
    alert(e.name);
}

