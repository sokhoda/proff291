<%@ page import="hw7.domain.Vendor" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.domain.CPU" %><%--
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
<h3>Edit CPU:</h3>
Select CPU: <br/>
<form id="editCPU" action="/editCPU" method="post">

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
    Change Vendor: <br/>
    <input id="editCPUvendor" type="text" name="vendor"> <br/>
    Change frequency: <br/>
    <input id="editCPUfreq" type="text" name="frequency"> <br/>
    Change model: <br/>
    <input id="editCPUmodel" type="text" name="model"> <br/>
    <input name = "editButton" type="submit" value="Edit CPU"/>
    <input name="deleteButton" type="submit" value="Delete CPU"/>
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
