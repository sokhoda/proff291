<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: v.davidenko
  Date: 29.01.2016
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h2>Clients list</h2>

<%--Menu line--%>
<table width="600px" border="0" cellpadding="3" style="background-color: #d4ecff">
  <tr>
    <td width="16%" align="center"><a href="dashboard.jsp">Home</a></td>
    <td width="16%" align="center"><a href="orders.jsp">Orders</a></td>
    <td width="16%" align="center"><a href="order.jsp">New order</a></td>
    <td width="16%" align="center" style="background-color: lightgreen">
      <b><a href="clients.jsp">Clients</a></b></td>
    <td width="16%" align="center"><a href="registerClient.jsp">New client</a></td>
    <td width="16%" align="center"><a href="index.jsp">Logout</a></td>
  </tr>
</table>
<br/>

<%--Clients list selection form--%>
<div style="float: left">

  <form name="selectListForm" action="/clientServlet" method="get">
    <table border="0" cellpadding="6" style="background-color: #d4ecff">
      <tr>
        <td><input type="radio" name="showBy" value="portion" checked="true"></td>
        <td>Show by portion of records:</td>
        <td align="right"><input type="text" name="portionSize" value="10" size="2" maxlength="2"/></td>
      </tr>
      <tr>
        <td><input type="radio" name="showBy" value="sum"></td>
        <td>Show by sum of orders, more:</td>
        <td align="right"><input type="text" name="gtSum" value="1000" size="4" maxlength="10"/></td>
      </tr>
      <tr>
        <td><input type="radio" name="showBy" value="month"></td>
        <td>Show by last month ordered:</td>
        <td></td>
      </tr>
      <tr><td colspan="3" align="center">
        <hr/>
        <input type="submit" value="Select" style="width: 100px"/>
      </td></tr>
    </table>
  </form>

</div>
<div style="clear: both"></div>

<%--Server error message--%>
<p style="color: red"><b>${clientServlet_err_msg}</b></p>

<%--Clients list--%>
<table border="0" cellpadding="6"  style="background-color: #d4ecff">
  <%
    List<Client> clients = (List<Client>)request.getAttribute("clientList");
    if(clients != null && !clients.isEmpty()){
  %>
  <h3>${clientListTitle}</h3>
  <tr>
    <th>Name</th>
    <th>Surname</th>
    <th>Phone</th>
    <th>Address</th>
    <th>Sum</th>
    <th>Last date</th>
  </tr>
  <tr>
    <td colspan="6"><hr/></td>
  </tr>
  <%
    for (Client client : clients){
  %>
  <tr>
    <td><%=client.getName()%></td>
    <td><%=client.getSurname()%></td>
    <td><%=client.getPhone()%></td>
    <td><%=client.getAddress()%></td>
    <td><%=client.getAmount()%></td>
    <td><%=client.getLastOrderDate()%></td>
  </tr>
  <%
      }
    }
  %>
</table>

</body>
</html>
