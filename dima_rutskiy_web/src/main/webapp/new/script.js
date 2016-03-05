/**
 * Created by Rrr on 23.01.2016.
 */
var ar=new Array(1,2,3,4,5,6,7,8,9,0);
console.log(ar);
var temp;
for(var i=0;i<3;i++){
    temp=ar[i];
    ar[i]=ar[ar.length-i-1];
    ar[ar.length-i-1]=temp;
}
console.log(ar);
function fun(ar1,ar2){
    alert('Alll'+ar1+ar2);
}
fun();