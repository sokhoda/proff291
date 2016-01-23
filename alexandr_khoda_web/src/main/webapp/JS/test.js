/**
 * Created by s_okhoda on 23.01.2016.
 */

function mirrorArray(vector, uBound){
    var temp, i;
    for(i = 0; i < uBound; i++){
        temp = vector[i];
        console.log('vect[i]=' + vector[i] + ' vector[vector.length - 1 - i]=' +
            vector[vector.length - 1 - i]);
        vector[i] = vector[vector.length - 1 - i];
        vector[vector.length - 1 - i] = temp;
    }
    return vector;
}
 global = 1;

 functionFun = function (){
    //alert('Fun function' + arguments.length);
    alert('global =' + global);
}();
//alert(functionFun());