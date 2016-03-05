function f1 (a, b){
    console.log(a,b);
}
var f2=f1.bind('gap', 'foo');
f2('bar', 'baz');