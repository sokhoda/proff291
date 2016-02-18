/**
 * Created by s_okhoda on 17.02.2016.
 */
function setSelectIndex(name, inx){
    var obj = document.getElementById(name);
    obj.options[inx].selected = true;
}


function setVisibility(name, dispType){
    var obj = document.getElementById(name);
    obj.style.display = dispType;
}
