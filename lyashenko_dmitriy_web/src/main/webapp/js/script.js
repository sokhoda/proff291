/**
 * Created by Solyk on 23.01.2016.
 */

var vector = [1,2,3,4,5,6,7,8,9];

var i,tmp;
for(i = 0; i < 3; i++){
    tmp = vector[i];
    vector[i] =  vector[vector.length - (i + 1)];
    vector[vector.length -(i + 1)] = tmp;

}
console.log(vector);

function fin(ar1,ar2){

    alert('Fun function' + arguments.length);
}
fin();
