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
    <title>Add Vendor</title>
</head>
<body>
<script src="js/advancedNotebooks.js" type="text/javascript"></script>
Enter name: <br/>
<form id ="addVendor" action="/addVendor" method="post">
    <input id="1row" type="text" name="vendorName"> <br/>
    <input type="button" onclick="validateRow1()" value="Add Vendor"/>
</form>
<p>
    ${reg_result}
</p>
</body>
</html>
</html>
