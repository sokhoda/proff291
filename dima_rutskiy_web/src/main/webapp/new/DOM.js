/**
 * Created by Rrr on 24.01.2016.
 */

val=55;
function createTree(el){
    document.write(el.tagName);
    for(var i=0; i<el.childNodes.length;i++){
        createTree(el.childNodes.item(i));
    }
}
