<%@ page import="hw7.domain.Store" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.domain.Notebook" %><%--
  Created by IntelliJ IDEA.
  User: i.gonchar
  Date: 2/19/2016
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Store</title>
</head>
<body>
<script src="js/advancedNotebooks.js" type="text/javascript"></script>
<h3>Add Store:</h3>
Select Notebook: <br/>
<form id="addStore" action="/addStore" method="post">
    <select size="4" name="notebookId">
        <option disabled>No selected ...................</option>
        <%
            String notebookId = (String) request.getAttribute("notebookId");
            List<Notebook> notebookList = (List<Notebook>) request.getAttribute("notebookList");
            if (notebookList != null && !notebookList.isEmpty()) {
                for (Notebook notebook : notebookList) {
        %>
        <option <%=(String.valueOf(notebook.getId()).equals(notebookId)) ? "selected" : ""%>
                value="<%=String.valueOf(notebook.getId())%>"><%=notebook.getModel()%>
        </option>
        <% }
        } %>
    </select>
    <br/>
    Enter Quantity: <br/>
    <input id="row4c2" type="text" name="quantity"> <br/>
    Enter Price: <br/>
    <input id="row4c3" type="text" name="price"> <br/>
    <input type="submit" <%--onclick="validateRow4()"--%> value="Add Store"/>
</form>
<br/>
<a href="/hw7/notesAdvanced.jsp">
    <button>Back</button>
</a>

${reg_result}

</body>
</html>
