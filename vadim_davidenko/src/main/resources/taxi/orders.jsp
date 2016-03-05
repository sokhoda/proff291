<%@ page import="hw8.taxi.domain.Order" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: v.davidenko
  Date: 29.01.2016
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h2>Orders list</h2>

<%--Menu line--%>
<table width="600px" border="0" cellpadding="3" style="background-color: #d4ecff">
  <tr>
    <td width="16%" align="center"><a href="dashboard.jsp">Home</a></td>
    <td width="16%" align="center" style="background-color: lightgreen">
      <b><a href="order.jsp">Orders</a></b></td>
    <td width="16%" align="center"><a href="order.jsp">New order</a></td>
    <td width="16%" align="center"><a href="clients.jsp">Clients</a></td>
    <td width="16%" align="center"><a href="registerClient.jsp">New client</a></td>
    <td width="16%" align="center"><a href="index.jsp">Logout</a></td>
  </tr>
</table>
<br/>

<%--Orders list selection form--%>
<div style="float: left">

  <form name="selectListForm" action="/orderServlet" method="get">
    <table border="0" cellpadding="6" style="background-color: #d4ecff">
      <tr>
        <td><input type="radio" name="showBy" value="portion" checked="true"></td>
        <td>Show by portion of records (5 per portion)</td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td><input type="radio" name="showBy" value="sum"></td>
        <td>Show by sum of orders (from, to):</td>
        <td><input type="text" name="fromSum" size="5" maxlength="5"/></td>
        <td><input type="text" name="toSum" size="5" maxlength="5"/></td>
      </tr>
      <tr><td colspan="4" align="center">
        <hr/>
        <input type="submit" value="Show" style="width: 100px"/>
      </td></tr>
    </table>
  </form>

</div>
<div style="clear: both"></div>

<%--Form fields values--%>
<script>
  document.selectListForm.showBy.value = ('${showBy}' == '') ? 'portion' : '${showBy}';
  document.selectListForm.fromSum.value = ('${fromSum}' == '') ? '0' : '${fromSum}';
  document.selectListForm.toSum.value = ('${toSum}' == '') ? '0' : '${toSum}';
</script>

<%--Server error message--%>
<p style="color: red"><b>${orderServlet_err_msg}</b></p>

<%--Orders list--%>
<table border="0" cellpadding="6"  style="background-color: #d4ecff">
  <%
    List<Order> orders = (List<Order>)request.getAttribute("orderList");
    if(orders != null && !orders.isEmpty()){
  %>
  <h3>${orderListTitle}</h3>
  <tr>
    <th>ID</th>
    <th>Client ID</th>
    <th>Amount</th>
    <th>From</th>
    <th>To</th>
    <th>Date</th>
  </tr>
  <tr><td colspan="6"><hr/></td></tr>
  <%
    for (Order order : orders){
  %>
  <tr>
    <td><%= order.getId() %></td>
    <td><%= order.getClientId() %></td>
    <td><%= order.getAmount() %></td>
    <td><%= order.getAddressFrom() %></td>
    <td><%= order.getAddressTo() %></td>
    <td><%= order.getOrderDate() %></td>
  </tr>
  <%
      }
    }
  %>
</table>

</body>
</html>