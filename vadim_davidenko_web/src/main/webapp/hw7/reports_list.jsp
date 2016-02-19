<%@ page import="hw7.notes.domain.Notebook" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: v.davidenko
  Date: 15.02.2016
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form name="listForm" action="/listServlet" method="post">
    <input type="hidden" name="reportMenu">
    <input type="hidden" name="portion">
    <input type="hidden" name="gtAmount">
    <table align="center" cellpadding="3">

        <tr><td align="center" colspan="3"><b>NOTEBOOK LIST</b></td></tr>

        <tr><td colspan="3">
            <table border="1" cellpadding="3">
                <tr style="background-color: #d4ecff">
                    <th align="center" width="40px">Id</th>
                    <th align="center" width="220px">Model</th>
                    <th align="center" width="100px">Manuf. date</th>
                    <th align="center" width="120px">Vendor</th>
                    <th align="center" width="220px">CPU</th>
                    <th align="center" width="120px">Memory</th>
                    <th align="center" width="50px">Store</th>
                    <th align="center" width="50px">Amount</th>
                    <th align="center" width="100px">Price</th>
                </tr>
                <%
                    List<Notebook> notebookList = (List<Notebook>)request.getAttribute("reportList");
                    if(notebookList != null && !notebookList.isEmpty()){
                        for (Notebook notebook : notebookList) {
                %>
                <tr>
                    <td align="center"><%= String.valueOf(notebook.getId()) %></td>
                    <td align="center"><%= notebook.getModel() %></td>
                    <td align="center"><%= notebook.getManufactureDateStr() %></td>
                    <td align="center"><%= notebook.getVendor().getName() %></td>
                    <td align="center"><%= notebook.getCpu().getModel() + " " + notebook.getCpu().getFrequency() %></td>
                    <td align="center"><%= notebook.getMemory().getVendor().getName() + " " + notebook.getMemory().getSize() %></td>
                    <td align="center"><%= (notebook.getStore() != null) ? String.valueOf(notebook.getStore().getId()) : "-" %></td>
                    <td align="center"><%= (notebook.getStore() != null) ? String.valueOf(notebook.getStore().getAmount()) : "-" %></td>
                    <td align="center"><%= (notebook.getStore() != null) ? String.valueOf(notebook.getStore().getPrice()) : "-" %></td>
                </tr>
                <% } } %>
            </table>
        </td></tr>

        <tr style="background-color: #d4ecff">
            <td colspan="2">
                <input type="button" value="Prev" style="width: 80px"/>
                &nbsp;&nbsp;&nbsp;
                <input type="button" value="Next" style="width: 80px"/>
            </td>
            <td align="right">
                <input type="button" value="Back" onclick="submitForm()" style="width: 80px"/>
            </td>
        </tr>

    </table>
</form>

<script>
    document.listForm.reportMenu.value = '${reportMenu}';
    document.listForm.portion.value = '${portion}';
    document.listForm.gtAmount.value = '${gtAmount}';

    function submitForm() {
        document.listForm.submit();
    }
</script>

</body>
</html>
