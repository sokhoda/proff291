/**
 * Created by Пк2 on 24.01.2016.
 */

function Class(){   //конструкторная ф-я
    this.field=12;
    this.method=function(){ //ф-я св-во
        this.field=45;
    }
};

var obj= new Class();
alert(obj.field+ obj.method());
