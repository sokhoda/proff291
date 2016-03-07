<%--
  Created by IntelliJ IDEA.
  User: tri___ton
  Date: 11.02.16
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dog and Animal</title>
</head>
<body>
<script>


//    var a=[1,2,3,4,5];
//    var result= a.filter(function(el){
//        return el%2;
//    });
//    console.log(result);


    function Animal(name) {
        this._name = name;
    }

    Animal.prototype.getName = function() {
        //alert( this._name );
        return this._name;
    };


    function Dog(name) {
        this._name = name;

    }


    Dog.prototype = Object.create(Animal.prototype);
    Dog.prototype.constructor = Dog;

    Dog.prototype.bark = function() {
        var name=Animal.prototype.getName.call(this);
        alert("Dog "+name+" is barking");
        return ("Dog "+name+" is barking");
    };


    var jack = new Dog("Jack");

    //jack.getName();
    jack.bark();

    var dog = new Dog ('Aban');
    alert( dog.getName () === 'Aban'); // true
    alert( dog.bark () === 'Dog Aban is barking'); // true



</script>

</body>
</html>
