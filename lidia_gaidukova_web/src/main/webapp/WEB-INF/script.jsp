<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 23.01.2016
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scriptTofile</title>
</head>
<body>
<script>
    function fun1(){
        alert('Fun function'+arguments.length);
    }
    fun1();
   var functionfun = function fun3() {
       val = 3;
      function closure(){
          val= 6;
      } ;
       return 3;
   }(fun1());
    alert (functionfun);
</script>

</body>
</html>
