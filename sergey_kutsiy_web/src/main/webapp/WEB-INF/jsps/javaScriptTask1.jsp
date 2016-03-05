<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 23.01.2016
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script>
        var vector = [1,2,3,4,5,6,7,8,9];
        var temp;
        if (vector.length<6) {
            console.log("Длина массива меньше 6, замена невозможна");
        }
        console.log(vector);
        for (var i=0; i<3; i++) {
            temp=vector[vector.length-1-i];
            vector[vector.length-1-i]=vector[i];
            vector[i]=temp;
        }
        console.log(vector);
    </script>

</body>
</html>
