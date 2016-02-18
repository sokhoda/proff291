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
    <title>Add notebook</title>
</head>
<body>
<script src="js/advancedNotebooks.js" type="text/javascript"></script>
<h3>Add Notebook:</h3>

Enter Vendor: <br/>
<form id ="addNotebook" action="/addNotebook" method="post">
    <input id="row4c1" type="text" name="vendorName"> <br/>
    Enter Model: <br/>
    <input id="row4c2" type="text" name="model"> <br/>
    Enter Manufacture Date: <br/>
    <input id="row4c3" type="text" name="manufactureDate"> <br/>
    Enter CPU: <br/>
    <input id="row4c4" type="text" name="cpu"> <br/>
    Enter Memory: <br/>
    <input id="row4c5" type="text" name="memory"> <br/>
    <input type="button" onclick="validateRow4()" value="Add Notebook"/>
</form>

${reg_result}
</body>
</html>
