/**
 * Created by Пк2 on 24.01.2016.
 */
 function createTree(el, tabs) {
    tabs +='&nbsp;&nbsp;&nbsp;';
    document.write(el.tagName);
    for(var i=0; i<el.childNodes.length;i++){
        createTree(node.childNodes.item(i),tabs);
    }
}
