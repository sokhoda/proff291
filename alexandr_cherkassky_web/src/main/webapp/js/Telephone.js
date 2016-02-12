/**
 * Created by Пк2 on 24.01.2016.
 */

function ClassTelephone(number,balanceLeft,minuteCost){
    this.number=number;
    this.balanceLeft=balanceLeft;
    this.cost=minuteCost;
    this.call=function (minutes){ // анонимная ф-я
        if(minutes*minuteCost>balanceLeft){
            console.log('Can not make call'+this.number);
        } else{
            console.log('Call in progress'+'number:'+this.number+minutes);
            balanceLeft=balanceLeft-minutes*minuteCost
        }


    }
}

function makeTelephones(){
    var arrTelephones=new Array();
    arrTelephones[0]= new ClassTelephone('15-45', 450);
    arrTelephones[1]= new ClassTelephone('800', 1000);
    arrTelephones[2]= new ClassTelephone('477', 1);
    return arrTelephones;
}