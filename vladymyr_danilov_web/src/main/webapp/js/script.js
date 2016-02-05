

var doc = document.documentElement;

for ( var i = 0; i < doc.childElementCount - 1; i++ ) {
    document.writeln(doc.get(i));
    alert("temp");
}