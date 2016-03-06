/**
 * Created by Rrr on 24.01.2016.
 */


function Tel(balance) {
    this.balance = balance;
    this.price = 20;
    this.during ;
    this.makeACall=function(during){
        this.during=during;
        if (this.balance > (this.price * this.during))
            alert("call is sucsesfull"+this.balance);
            //alert("call is sucsesfull"+this.balance);
        else{
            alert("call is not sucsesfull"+this.balance);
        }

}}
    var tel1=new Tel(100);
    tel1.makeACall(20);

    var tel2=new Tel(1000);
    tel2.makeACall(10);





