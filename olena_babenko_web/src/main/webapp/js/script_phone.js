/**
 * Created by lenchi on 24.01.16.
 */

/*Создать класс телефон со след св-вами: номер телефона, остаток на счету.
 И метод "звонок" (в качестве аргументов - к-во минут, которые говорите)
 Когда звонишь, должен изменяться баланс
 Если звонок нельзя осуществить "Невозможно установить соединение"*/

function Phone1() {
    this.phoneNumber = 123456;
    var balans;

   this.call = function (minutes, balans) {
        this.minutes;
        if (minutes > balans) {
            alert('Call is unavailable');
        } else {
            balans = balans - minutes;
            alert('You were talking for ' + minutes + ' minutes.\n Your balans is ' + balans);
        }
    }
    call(9,10);
}



