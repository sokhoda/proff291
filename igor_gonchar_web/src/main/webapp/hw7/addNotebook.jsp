<%@ page import="hw7.domain.Vendor" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.domain.CPU" %>
<%@ page import="hw7.domain.Memory" %><%--
  Created by IntelliJ IDEA.
  User: i.gonchar
  Date: 2/15/2016
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add notebook</title>
</head>
<body>
<script src="js/advancedNotebooks.js" type="text/javascript"></script>
<h3>Add Notebook:</h3>

Select Vendor: <br/>
<form id="addNotebook" action="/addNotebook" method="post">

<%--    <input id="row4c1" type="text" name="vendorName"> <br/>--%>

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

    Enter Model: <br/>
    <input id="row4c2" type="text" name="model"> <br/>
    Enter Manufacture Date: <br/>
    <input id="row4c3" type="text" name="manufactureDate"> <br/>
    Select CPU: <br/>
   <%-- <input id="row4c4" type="text" name="cpu"> <br/>--%>

    <select size="4" name="cpuId">
        <option disabled>No selected ...................</option>
        <%
            String cpuId = (String) request.getAttribute("cpuId");
            List<CPU> cpuList = (List<CPU>) request.getAttribute("cpuList");
            if (cpuList != null && !cpuList.isEmpty()) {
                for (CPU cpu : cpuList) {
        %>
        <option <%=(String.valueOf(cpu.getId()).equals(cpuId)) ? "selected" : ""%>
                value="<%=String.valueOf(cpu.getId())%>"><%=cpu.getModel()%>
        </option>
        <% }
        } %>
    </select>
    <br/>

    Select Memory: <br/>
   <%-- <input id="row4c5" type="text" name="memory"> <br/>--%>

    <select size="4" name="memoryId">
        <option disabled>No selected ...................</option>
        <%
            String memoryId = (String) request.getAttribute("memoryId");
            List<Memory> memoryList = (List<Memory>) request.getAttribute("memoryList");
            if (memoryList != null && !memoryList.isEmpty()) {
                for (Memory memory : memoryList) {
        %>
        <option <%=(String.valueOf(memory.getId()).equals(memoryId)) ? "selected" : ""%>
                value="<%=String.valueOf(memory.getId())%>"><%=memory.getSize()%>
        </option>
        <% }
        } %>
    </select>
    <br/>

    <input type="submit" <%--onclick="validateRow4()"--%> value="Add Notebook"/>
</form>
<br/>
<a href="/hw7/notesAdvanced.jsp">
    <button>Back</button>
</a>

${reg_result}
</body>
</html>
