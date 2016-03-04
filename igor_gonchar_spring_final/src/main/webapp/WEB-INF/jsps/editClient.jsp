<%@ page import="hw9.domain.Client" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: i.gonchar
  Date: 3/4/2016
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="js/clientController.js" type="text/javascript"></script>

<h3>Edit Client:</h3>
<form id="editClient" action="/editClient" method="post">
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
    <input type="button" onclick="editClientValidation()" value="Edit Client"/>
</form>

<a href="/choicePage">
    <button>Back</button>
</a>
<hr>
${reg_result}

</body>
</html>
