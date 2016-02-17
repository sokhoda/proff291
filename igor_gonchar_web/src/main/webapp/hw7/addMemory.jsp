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
    <title>Title</title>
</head>
<body>
<script src="js/advancedNotebooks.js" type="text/javascript"></script>
<h3>Add Memory:</h3>
Enter vendor: <br/>
<form id ="addVendor" action="/addMemory" method="post">
    <input id="1row" type="text" name="vendorName"> <br/>
    Enter size: <br/>
    <input id="2row" type="text" name="size"> <br/>
    <input type="button" onclick="validateRow2()" value="Add Vendor"/>
</form>
<p>
    ${reg_result}
</p>
</body>
</html>
