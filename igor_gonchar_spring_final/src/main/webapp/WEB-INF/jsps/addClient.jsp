<%--
  Created by IntelliJ IDEA.
  User: i.gonchar
  Date: 3/3/2016
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>

<%--- зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Client</title>
</head>
<body>
<script src="js/clientController.js" type="text/javascript"></script>

<h3>Add Client:</h3>
Enter First Name: <br/>
<form id ="addClientForm" action="/addClient" method="post">
    <input id="clientName" type="text" name="clientName"> <br/>
    Enter Last Name: <br/>
    <input id="clientSurname" type="text" name="clientSurname"> <br/>
    Enter Phone Number: <br/>
    <input id="clientPhone" type="text" name="clientPhone"> <br/>
    Enter Address: <br/>
    <input id="clientAddress" type="text" name="clientAddress"> <br/>
    <input type="button" onclick="clientDataValidation()" value="Add Client"/>
</form>
<a href="/choicePage">
    <button>Back</button>
</a>
<hr>
${reg_result}

</body>
</html>
