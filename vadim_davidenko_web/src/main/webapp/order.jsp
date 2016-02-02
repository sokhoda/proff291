<%@ page import="hw8.taxi.domain.Client" %>
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

<h2>Order management</h2>

<%--Menu line--%>
<table width="600px" border="0" cellpadding="3" style="background-color: #d4ecff">
  <tr>
    <td width="16%" align="center"><a href="dashboard.jsp">Home</a></td>
    <td width="16%" align="center"><a href="orders.jsp">Orders</a></td>
    <td width="16%" align="center" style="background-color: lightgreen">
      <b><a href="order.jsp">New order</a></b></td>
    <td width="16%" align="center"><a href="clients.jsp">Clients</a></td>
    <td width="16%" align="center"><a href="registerClient.jsp">New client</a></td>
    <td width="16%" align="center"><a href="index.jsp">Logout</a></td>
  </tr>
</table>
<br/>

<div style="float: left">

<%--Order management form--%>
    <form name="selectForm" action="/orderServlet" method="post">
        <table border="0" cellpadding="6" style="background-color: #d4ecff">
            <tr>
                <td><input type="button" value="New order" onclick="submitSelectForm(document.selectForm, 'new')" style="width: 100px"/></td>
                <td><input type="text" name="selectAction" hidden/>&nbsp;&nbsp;&nbsp;</td>
                <td><input type="button" value="Edit order" onclick="submitSelectForm('edit')" style="width: 100px"/></td>
                <td><input type="text" name="id" size="4" maxlength="4"/></td>
            </tr>
        </table>
    </form>

<%--Order registration form--%>
    <form name="regForm" action="/orderServlet" method="post">
        <table border="0" cellpadding="6" style="background-color: #d4ecff">
            <%
                List<Client> clients = (List<Client>)request.getAttribute("clientList");
                String clientId = (String)request.getAttribute("clientId");
                if(clients != null && !clients.isEmpty()){
            %>
            <tr><td><input type="text" name="formAction" value="${action}" hidden/>&nbsp;&nbsp;&nbsp;</td></tr>
            <tr>
                <td>Order ID:</td>
                <td><input type="text" name="orderId" value="${orderId}" size="4" maxlength="4"/></td>
            </tr>
            <tr>
                <td>Client full name:</td>
                <td><select size="5" name="clientId">
                    <option disabled>Select client name &nbsp;&nbsp;&nbsp;</option>
                    <%
                        for (Client client : clients){
                    %>
                    <option value="<%= String.valueOf(client.getId()) %>"
                            <% if (String.valueOf(client.getId()).equals(clientId)) { %><%= "selected"%><% } %> >
                        <%= client.getName() + " " + client.getSurname() %></option>
                    <%
                        }
                    %>
                </select></td>
            </tr>
            <tr>
                <td>Order cost address:</td>
                <td><input type="text" name="address" value="${address}" size="10" maxlength="10"/></td>
            </tr>
            <tr>
                <td>Original address:</td>
                <td><input type="text" name="addressFrom" value="${addressFrom}" size="20" maxlength="50"/></td>
            </tr>
            <tr>
                <td>Destination address:</td>
                <td><input type="text" name="addressTo" value="${addressTo}" size="20" maxlength="50"/></td>
            </tr>
            <tr><td colspan="2" align="center">
                <hr/>
                <input type="button" value="Save" onclick="submitRegForm(document.regForm)" style="width: 100px"/>
            </td></tr>
            <%
                }
            %>
        </table>
    </form>

</div>
<div style="clear: both"></div>

<%--Server messages--%>
<p style="color: green"><b>${orderServlet_msg}</b></p>
<p style="color: red"><b>${orderServlet_err_msg}</b></p>

<%--Checking fields script--%>
<script>
    function submitSelectForm(form, selectedValue) {
        if (selectedValue === 'edit') {
            var orderId = form.id.value;
            if (isNaN(+orderId) || orderId.search('.') || orderId.search(',')) {
                alert("Please, enter order ID as integer number");
                return;
            }
        }
        form.selectAction.value = selectedValue;
        form.submit();
    }

    function submitRegForm(form) {
        if (checkFields(form)) form.submit();
    }
    function checkFields(form) {
        if(!form.clientId.value.trim() ||
                !form.address.value.trim() ||
                !form.addressFrom.value.trim() ||
                !form.addressTo.value.trim()) {
            alert("Please, fill in all fields!");
            return false;
        }
        var address = form.address.value;
        if(isNaN(+address) || address.search('.') || address.search(',')) {
            alert("Please, enter cost address as integer number");
            return false;
        }
        return true;
    }

</script>

</body>
</html>
