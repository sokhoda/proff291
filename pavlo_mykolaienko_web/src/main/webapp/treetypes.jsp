<%--
  Created by IntelliJ IDEA.
  User: Павло
  Date: 24.01.2016
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выводим дерево элементов</title>
    <script type="text/javascript">

        var doc = document.documentElement;

        function treeWrite(n) {

            document.write(n.tagName + '<br>');

            for (var i = 0; i < n.childNodes.length; i++) {



                //     treeWrite(n.childNodes.item(i))  ;

            }

        }


        treeWrite(doc);
    </script>

</head>
<body>
<p>true result</p>
<p>true result</p>
<p>true result</p>
<p>true result</p>
</body>
</html>
