<%@ page import="hw7.notes.domain.CPU" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: v.davidenko
  Date: 15.02.2016
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form name="regForm" action="/cpuListServlet" method="post">

    <table align="center" cellpadding="3" style="background-color: #d4ecff">

        <tr><td align="center" colspan="3"><h3>CPU list</h3></td></tr>

        <tr><td colspan="3">
            <table border="1" cellpadding="3">
                <tr style="background-color: #d4ecff">
                    <th></th>
                    <th align="center" width="70px">Id</th>
                    <th align="center" width="170px">Model</th>
                    <th align="center" width="170px">Vendor</th>
                    <th align="center" width="170px">Frequency</th>
                </tr>
                <%
                    List<CPU> cpuList = (List<CPU>)request.getAttribute("cpuList");
                    if(cpuList != null && !cpuList.isEmpty()){
                        for (CPU cpu : cpuList) {
                %>
                <tr>
                    <td><input type="radio" name="item" value="<%=String.valueOf(cpu.getId())%>"></td>
                    <td align="center"><%= String.valueOf(cpu.getId()) %></td>
                    <td align="center"><%= cpu.getModel() %></td>
                    <td align="center"><%= cpu.getVendor() %></td>
                    <td align="center"><%= String.valueOf(cpu.getFrequency()) %></td>
                </tr>
                <% } } %>
            </table>
        </td></tr>

        <tr>
            <td align="center">
                <input type="submit" value="New" style="width: 80px"/>
            </td>
            <td align="center">
                <input type="submit" value="Edit" style="width: 80px"/>
            </td>
            <td align="center">
                <a href="../hw7/menu.jsp"><input type="button" value="Back" style="width: 80px"/></a>
            </td>
        </tr>

    </table>
</form>

</body>
</html>
