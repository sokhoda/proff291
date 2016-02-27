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
    <title>Add Sales</title>
</head>
<body>
<script src="js/advancedNotebooks.js" type="text/javascript"></script>
<h3>Add Sales:</h3>

Select Store: <br/>
<form id="addSales" action="/addSales" method="post">
    <select size="4" name="storeId">
        <option disabled>No selected ...................</option>
        <%
            String storeId = (String) request.getAttribute("storeId");
            List<Store> storeList = (List<Store>) request.getAttribute("storeList");
            if (storeList != null && !storeList.isEmpty()) {
                for (Store store : storeList) {
        %>
        <option <%=(String.valueOf(store.getId()).equals(storeId)) ? "selected" : ""%>
                value="<%=String.valueOf(store.getId())%>"><%=store.getAmount()%>
        </option>
        <% }
        } %>
    </select>
    <br/>
    Enter Amount: <br/>
    <input id="row6c1" type="text" name="amount"> <br/>
    Enter Price For 1 Note: <br/>
    <input id="row6c2" type="text" name="price"> <br/>
    <input type="submit" <%--onclick="validateRow4()"--%> value="Add Sales"/>
</form>
<br/>
<a href="/hw7/notesAdvanced.jsp">
    <button>Back</button>
</a>
<br/>
${reg_result}

</body>
</html>
