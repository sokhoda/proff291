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
    <title>Add CPU</title>
</head>
<body>
<script src="js/advancedNotebooks.js" type="text/javascript"></script>
<h3>Add CPU:</h3>
Enter vendor: <br/>
<form id ="addCPU" action="/addCPU" method="post">
    <input id="row3c1" type="text" name="vendorName"> <br/>
    Enter frequency: <br/>
    <input id="row3c2" type="text" name="frequency"> <br/>
    Enter model: <br/>
    <input id="row3c3" type="text" name="model"> <br/>
    <input type="button" onclick="validateRow3()" value="Add CPU"/>
</form>
<br/>
<a href="/hw7/notesAdvanced.jsp">
    <button>Back</button>
</a>
<p>
    ${reg_result}
</p>
</body>
</html>
