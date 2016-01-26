/**
 * Created by Сергей on 24.01.2016.
 */
var doc = document.documentElement;
var level1 = doc.childNodes.item(0).childNodes;

for (var i=0; i<doc.childNodes.length; i++) {
    document.write(doc.childNodes.item(i));
    document.write('<br/>');

    doc.innerHTML
}

var tree = function () {
    var count=doc.childNodes.length;
    while (count > 0) {
        document.write(doc.childNodes.item(count));
        document.write('<br/>');
        count--;
    }

}