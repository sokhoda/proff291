function Telephone(name, telephoneNumber, balance, operator) {

    this.name = name;
    this.telephoneNumber = telephoneNumber;
    this.balance = balance;
    this.operator = operator;


    this.func = function call(min) {
        if (min * operator > balance) {
            console.log('The call cannot be made');
        }
        else {

            balance -= operator * min;
            console.log('successful  ' + balance);
        }
    }
}
var person1 = new Telephone('Petr', '0984734291', 50, 5);
var person2 = new Telephone('Anna', '0632734291', 10, 5);
person1.func(10);
person2.func(12);

