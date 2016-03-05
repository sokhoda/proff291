
val = 55;
console.log('Hello JS' + val);
function createTree(node, tabs) {
    tabs += '&nbsp;&nbsp;&nbsp;';
    document.writeln(tabs + node.tagName + '<br/>');
    for (var i=0; i < node.childNodes.length; i++) {
        createTree(node.childNodes.item(i), tabs);
    }
}

var functionFun = function fun() {
    var val = 5;
    var obj = {
        field: 1,
        field2: 'name',
        //alert('Fun Function'+arguments.length);
        // return 3;
        du: function () {
            alert(this.field + this.field2 + this.id);
        }
    };
    obj['id'] = 1;
    obj.du();

//    function Class() {
//        this.field = 12;
//        this.method = function () {
//            this.field = 45;
//            return this.field;
//        }
//    };
//    var obj = new Class();
//    alert(obj.field + obj.method());
//    var vector = new Array(3);
//    var sub = Object.create(obj);
//    sub.__proto__ = (vector);
//    //  second way
////var sub={};
////    sub.prototype=obj;
//
//    //  alert(sub.field);
//
//    alert(sub.hasOwnProperty('field'));

    var doc=document.documentElement;
    //can write in tree
    document.write('empty');
    document.write(doc.nodeType);
    document.write(doc.tagName);
    document.write(doc.childNodes);


};
//fun("", 2);