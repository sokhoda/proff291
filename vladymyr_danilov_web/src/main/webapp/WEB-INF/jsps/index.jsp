<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 28.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JavaScript</title>
    <script>
        x = 3;
        console.log('Hello JS' + 3);
        document.write('Hello JS');
    </script>

    <script type="text/javascript" src="/script/script.js"></script>
</head>
<body onload="/*fun()*/">
    <h2 id="elh" onclick="ajaxic('Sestra')">Header</h2>
    <form action="/hello.html" onsubmit="return check()">
        <input id="text" name="login" type="text" value="user name"/>
        <input type="submit" value="send"/>
    </form>
    <p><a href="/angularController">Angular AJAX</a></p>
    <p><a href="/angularNameController">Angular Random</a></p>

</body>
</html>
