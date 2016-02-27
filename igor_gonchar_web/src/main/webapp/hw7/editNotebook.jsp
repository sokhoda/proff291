<%@ page import="hw7.domain.CPU" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.domain.Notebook" %>
<%@ page import="hw7.domain.Vendor" %>
<%@ page import="hw7.domain.Memory" %><%--
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
<form id="editNotebook" action="/editNotebook" method="post">
    Select Notebook: <br/>
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
    Change Vendor: <br/>
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
    Change model: <br/>
    <input id="editCPUmodel" type="text" name="model"> <br/>

    Change Memory: <br/>
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
    Change CPU: <br/>
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
    <input name = "editButton" type="submit" value="Edit Notebook"/>
    <input name="deleteButton" type="submit"<%-- onclick="confirmDelete()"--%> value="Delete Notebook"/>

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
            var form = doc.getElementById('editCPU');
            form.submit();
        }
    }
</script>
</body>
</html>
