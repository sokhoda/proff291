<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 14.02.2016
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h2>MENU</h2>

<form name="menuForm" action="/menuServlet" method="post">
    <table cellpadding="3">

        <tr><td colspan="2"><h4>Entity</h4></td></tr>

        <tr><td colspan="2">
            <table cellpadding="3">
                <tr>
                    <td><input type="radio" name="menuOption" value="notebook" checked></td>
                    <td>Notebook model</td>
                </tr>
                <tr>
                    <td><input type="radio" name="menuOption" value="vendor"></td>
                    <td>Vendor name</td>
                </tr>
                <tr>
                    <td><input type="radio" name="menuOption" value="cpu"></td>
                    <td>CPU type</td>
                </tr>
                <tr>
                    <td><input type="radio" name="menuOption" value="memory"></td>
                    <td>Memory type</td>
                </tr>
            </table>
        </td></tr>

        <tr>
            <td align="center">
                <input type="button" value="New" onclick="submitEntity()" style="width: 80px"/>
            </td>
            <td align="center">
                <input type="submit" value="Edit" style="width: 80px"/>
                &nbsp;&nbsp;<input type="text" name="id" size="5" maxlength="5"/>
            </td>
        </tr>
    </table>
</form>

<script>
    function submitEntity() {
        document.menuForm.id.value = '';
        document.menuForm.submit();
    }
</script>

<%--<h4>Entity</h4>--%>
<%--<ul>--%>
  <%--<li><a href="../hw7_old/notebook_list.jsp">Notebook type</a></li>--%>
  <%--<li><a href="../hw7_old/vendor_list.jsp">Vendor</a></li>--%>
  <%--<li><a href="../hw7_old/cpu_list.jsp">CPU</a></li>--%>
  <%--<li><a href="../hw7_old/memory_list.jsp">Memory</a></li>--%>
<%--</ul>--%>


</body>
</html>
