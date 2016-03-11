<%@ page import="hw9.domain.Client" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: i.gonchar
  Date: 3/3/2016
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Order</title>
</head>
<body>
<script src="js/orderController.js" type="text/javascript"></script>

<form id="addOrder" action="/addOrder" method="post">
    <script src="js/order.js" type="text/javascript"></script>
    <h3>Add Order:</h3>
    Select Client:<br/>
    <select size="4" name="clientId">
        <option disabled>No selected ...................</option>
        <%
            String clientId = (String) request.getAttribute("clientId");
            List<Client> clientList = (List<Client>) request.getAttribute("clientList");
            if (clientList != null && !clientList.isEmpty()) {
                for (Client client : clientList) {
        %>
        <option <%=(String.valueOf(client.getId()).equals(clientId)) ? "selected" : ""%>
                value="<%=String.valueOf(client.getId())%>"><%=client.getName()%> <%=client.getSurname()%>
        </option>
        <% }
        } %>
    </select>
    <br/>
    Enter Date:<br/>
    <input id="addOrderDate" type="text" name="orderDate"> <br/>
    Enter Address From:<br/>
    <input id="addOrderAddressFrom" type="text" name="fromAddress"> <br/>
    Enter Address To:<br/>
    <input id="addOrderAddressTo" type="text" name="toAddress"> <br/>
    Enter Amount:<br/>
    <input id="addOrderAmount" type="text" name="orderAmount"> <br/>
    <input type="button" onclick="orderDataValidation()" value="Add Order"/>
</form>
<a href="/choicePage">
    <button>Back</button>
</a>

<hr>
${reg_result}
</body>
</html>
