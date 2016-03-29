/**
 * Created by i.gonchar on 3/3/2016.
 */
var doc = document;

function orderDataValidation(){
    var amount = doc.getElementById('addOrderAmount').value;

    if(isNaN(amount) || amount === '' || amount == null){
        alert('Please enter numbers');
        return;
    }
    var form = doc.getElementById('addOrder');
    form.submit();
}