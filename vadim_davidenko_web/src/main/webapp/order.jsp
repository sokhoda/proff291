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
                <td><input type="text" name="selectAction" hidden/>&nbsp;&nbsp;</td>
                <td><input type="button" value="Edit order" onclick="submitSelectForm(document.selectForm, 'edit')" style="width: 100px"/></td>
                <td><input type="text" name="id" size="4" maxlength="4"/></td>
            </tr>
        </table>
    </form>

<%--Order registration form--%>
    <form name="regForm" action="/orderServlet" method="post">
        <table border="0" cellpadding="6" style="background-color: #d4ecff">
            <tr>
                <td>Order ID: </td>
                <td><input type="text" name="formAction" hidden/>
                    <input type="text" name="orderId" size="5" maxlength="5" disabled/></td>
            </tr>
            <tr>
                <td>Client full name:</td>
                <td><select size="5" id="client" name="client">
                    <option disabled>Select ......................</option>
                    <%
                        String clientId = (String)request.getAttribute("clientId");
                        List<Client> clients = (List<Client>)request.getAttribute("clientList");
                        if(clients != null && !clients.isEmpty()){
                            for (Client client : clients){
                    %>
                    <option <%=(String.valueOf(client.getId()).equals(clientId)) ? "selected" : "" %>
                            value="<%=String.valueOf(client.getId())%>">
                        <%=client.getName() + " " + client.getSurname()%></option>
                    <%
                            }
                        }
                    %>
                </select></td>
            </tr>
            <tr>
                <td>Order cost amount:</td>
                <td><input type="text" name="amount" size="5" maxlength="5"/></td>
            </tr>
            <tr>
                <td>Original address:</td>
                <td><input type="text" name="addressFrom" size="20" maxlength="50"/></td>
            </tr>
            <tr>
                <td>Destination address:</td>
                <td><input type="text" name="addressTo" size="20" maxlength="50"/></td>
            </tr>
            <tr><td colspan="2" align="center">
                <hr/>
                <input type="button" value="Save" onclick="submitRegForm(document.regForm)" style="width: 100px"/>
            </td></tr>
        </table>
    </form>

</div>
<div style="clear: both"></div>

<script>
    document.regForm.formAction.value = '${formAction}';
    document.regForm.orderId.value = '${orderId}';
    document.regForm.amount.value = '${amount}';
    document.regForm.addressFrom.value = '${addressFrom}';
    document.regForm.addressTo.value = '${addressTo}';
</script>

<%--Server messages--%>
<p style="color: green"><b>${orderServlet_msg}</b></p>
<p style="color: red"><b>${orderServlet_err_msg}</b></p>

<%--Checking fields script--%>
<script>
    function submitSelectForm(form, action) {
        if (action == 'edit') {
            if (!form.id.value.trim() || isNaN(+form.id.value)) {
                alert("Please, enter order ID as integer number");
                return;
            }
        }
        form.selectAction.value = action;
        form.submit();
    }

    function submitRegForm(form) {
        if(!form.amount.value.trim() ||
                isNaN(+form.amount.value) ||
                !form.client.value ||
                !form.addressFrom.value.trim() ||
                !form.addressTo.value.trim()) {
            alert("Please, fill in all fields!");
            return
        }
        form.submit();
    }

</script>

</body>
</html>
