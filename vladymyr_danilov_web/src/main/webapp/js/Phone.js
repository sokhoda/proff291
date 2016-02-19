
function Phone(number, balance) {
    Number _num;
    Number _balance;
    this.tarif = 0.5;

    this.getNumber = function() {
        return _num;
    };

    this.getBalance = function() {
        return _balance;
    };

    this.setNumber = function(number) {
        this._num = number;
    };

    this.setBalance = function(balance) {
        this._balance = balance;
    };

    this.call = function(duration) {
        var amount = duration * this.tarif;

        if ( amount < balance ) {
            _balance -= amount;
            alert(_balance);
        } else {
            alert("You have't lot of money on the balance");
        }
    };
}

var phone1 = new Phone(1111, 100);

phone1.call(5);

