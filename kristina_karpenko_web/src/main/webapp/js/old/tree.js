
function Tree(el, tabs) {


    tabs += '&nbsp;&nbsp;&nbsp';
    document.write(el.tagName);
    for (var i = 0; i < el.childNodes.length; i++) {

        Tree(el.childNodes.item(i), tabs);
    }


}

