<%--
  Created by IntelliJ IDEA.
  User: i.gonchar
  Date: 2/15/2016
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advanced Notes</title>
</head>
<body>
<h3 align="center"> Select an action:</h3>
<div align="center">
<form id="generalForm" action="/notebooksAdvancedForm" method="post">
    <input type="radio" value="cpu" name="addOption" checked> CPU   <br/>
    <input type="radio" value="memory" name="addOption"> Memory  <br/>
    <input type="radio" value="vendor" name="addOption"> Vendor  <br/>
    <input type="radio" value="notebook" name="addOption"> Notebook  <br/>
    <input type="radio" value="store" name="addOption"> Store  <br/>
    <input name="addButton" type="submit" value="Add"/>
    <input name="editButton" type="submit" value="Edit"/>
    <input name="showButton" type="submit" value="Show All"/>
</form>
</div>
<p>
    ${reg_result}
</p>
</body>
</html>
