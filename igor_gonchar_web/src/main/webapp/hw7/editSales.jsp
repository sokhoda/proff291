<%@ page import="hw7.domain.Vendor" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.domain.Sales" %><%--
  Created by IntelliJ IDEA.
  User: i.gonchar
  Date: 2/24/2016
  Time: 1:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="js/advancedNotebooks.js" type="text/javascript"></script>
<h3>Edit Sales:</h3>
Select Sales: <br/>
<form id="editVendor" action="/editSales" method="post">

    <select size="4" name="salesId">
        <option disabled>No selected ...................</option>
        <%
            String salesId = (String) request.getAttribute("salesId");
            List<Sales> salesList = (List<Sales>) request.getAttribute("salesList");
            if (salesList != null && !salesList.isEmpty()) {
                for (Sales sales : salesList) {
        %>
        <option <%=(String.valueOf(sales.getId()).equals(salesId)) ? "selected" : ""%>
                value="<%=String.valueOf(sales.getId())%>"><%=sales.getAmount()%>
        </option>
        <% }
        } %>
    </select>
    <br/>
    Change Amount: <br/>
    <input id="editAmount" type="text" name="amount"> <br/>
    Change Price: <br/>
    <input id="editPrice" type="text" name="price"> <br/>
    <input name="editButton" type="submit" value="Edit Sales"/>
    <input name="deleteButton" type="button" onclick="confirmDelete()" value="Delete Sales"/>
</form>
<br/>
<a href="/hw7/notesAdvanced.jsp">
    <button>Back</button>
</a>
<p>
    ${reg_result}
</p>
<script>
    function confirmDelete() {
        var doc = document;
        var conf = confirm('Are you sure you want to delete?');
        if (conf) {
            var form = doc.getElementById('editVendor');
            form.submit();
        }
    }
</script>
</body>
</html>
