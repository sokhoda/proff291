<%@ page import="hw7.domain.Vendor" %>
<%@ page import="java.util.List" %><%--
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
<h3>Edit Vendor:</h3>
Select Vendor: <br/>
<form id="editVendor" action="/editVendor" method="post">

    <select size="4" name="vendorId">
        <option disabled>No selected ...................</option>
        <%
            String vendorId = (String) request.getAttribute("vendorId");
            List<Vendor> vendorList = (List<Vendor>) request.getAttribute("vendorList");
            if (vendorList != null && !vendorList.isEmpty()) {
                for (Vendor vendor : vendorList) {
        %>
        <option <%=(String.valueOf(vendor.getId()).equals(vendorId)) ? "selected" : ""%>
                value="<%=String.valueOf(vendor.getId())%>"><%=vendor.getName()%>
        </option>
        <% }
        } %>
    </select>
    <br/>
    Change Name: <br/>
    <input id="editVendorName" type="text" name="name"> <br/>
    <input type="submit" value="Edit Vendor"/>
</form>

<p>
    ${reg_result}
</p>
</body>
</html>
