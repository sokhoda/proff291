<%--
  Created by IntelliJ IDEA.
  User: Павло
  Date: 23.01.2016
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">

        ar = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        l = ar.length;
        v = ar[0];
        ar[0] = ar[l - 1];
        ar[l - 1] = v;
        v = ar[1];
        ar[1] = ar[l - 2];
        ar[l - 2] = v;
        v = ar[2];
        ar[2] = ar[l - 3];
        ar[l - 3] = v;

        document.write("array= " + ar);
        alert("array= " + ar);

    </script>
</head>
<body>


<h1>Вывод на экран </h1>
</body>
</html>
