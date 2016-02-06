<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! public static int counter = 0; %>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <form action="/form" method="post" >
        <input type="text" name="login" value="Sveta"/>
        <input type="password" name="password" size="15" maxlength="25">
        <input type="submit" value="POST"/>
        </form>
        <%= ++counter %>
    </body>
</html>