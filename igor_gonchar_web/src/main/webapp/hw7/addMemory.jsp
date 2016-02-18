<%--
  Created by IntelliJ IDEA.
  User: i.gonchar
  Date: 2/15/2016
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Memory</title>
</head>
<body>
<script src="js/advancedNotebooks.js" type="text/javascript"></script>
<h3>Add Memory:</h3>
Enter vendor: <br/>
<form id ="addMemory" action="/addMemory" method="post">
    <input id="row2c1" type="text" name="vendorName"> <br/>
    Enter size: <br/>
    <input id="row2c2" type="text" name="size"> <br/>
    <input type="button" onclick="validateRow2()" value="Add Memory"/>
</form>
<p>
    ${reg_result}
</p>
</body>
</html>
