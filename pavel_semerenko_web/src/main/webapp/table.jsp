<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mini fb</title>
</head>
<body>
<table width="100%" border="1">
    <thead>
    <tr>
        <th colspan="2">Section 1</th>
        <th colspan="2">Section 2</th>
        <th colspan="2">Section 3</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td colspan="6">реклама</td>
    </tr>
    <tr>
        <td><a href="http://www.google.com.ua">link 1</a> </td>
        <td><a href="http://www.google.com.ua">link 2</a> </td>
        <td><a href="http://www.google.com.ua">link 3</a> </td>
        <td><a href="http://www.google.com.ua">link 4</a> </td>
        <td><a href="http://www.google.com.ua">link 5</a> </td>
        <td><a href="http://www.google.com.ua">link 6</a> </td>
    </tr>
    <tr>
        <td colspan="2">
            <ul>
                <li>step 1</li>
                <li>step 2</li>
                <li>step 3</li>
            </ul>
        </td>
        <td colspan="4">
            <%--img src="img/fillin.jpg" width="25%"/--%>
            text
        </td>
    </tr>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="6">all rights reserved. copyright 2016</td>
    </tr>
    </tfoot>
</table>
<form action="/form" method="post">
    <input type="text" name="login" value=""/>
    <input type="submit" value="post">
</form>
</body>
</html>