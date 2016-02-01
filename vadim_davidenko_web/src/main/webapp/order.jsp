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
                <td><input type="button" value="New order" onclick="submitSelectForm(selectForm, regForm, 'new')" style="width: 100px"/></td>
                <td><input type="text" name="selectAction" hidden/>&nbsp;&nbsp;&nbsp;</td>
                <td><input type="button" value="Edit order" onclick="submitSelectForm(selectForm, regForm, 'edit')" style="width: 100px"/></td>
                <td><input type="text" name="orderId" size="3" maxlength="10"/></td>
            </tr>
        </table>
    </form>

<%--Order registration form--%>
    <form name="regForm" action="/orderServlet" method="post" hidden>
        <table border="0" cellpadding="6" style="background-color: #d4ecff">
            <tr>
                <td>Client full name:</td>
                <td><select size="5" name="client">
                    <option disabled>Select client name &nbsp;&nbsp;&nbsp;</option>
                    <option value="client 1">Client 1</option>
                    <option value="client 2">Client 2</option>
                    <option value="client 3">Client 3</option>
                    <option value="client 4">Client 4</option>
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

<%--Server messages--%>
<p style="color: green"><b>${orderServlet_msg}</b></p>
<p style="color: red"><b>${orderServlet_err_msg}</b></p>

<%--Checking fields script--%>
<script>
    function submitSelectForm(selectForm, regForm, selectedValue) {
        var orderId = selectForm.orderId.value;
        if (selectedValue === 'edit') {
            if (orderId.trim() || isNaN(+orderId) || orderId.search('.') || orderId.search(',')) {
                alert("Please, enter order ID as integer number");
                return;
            }
        }
        regForm.hidden = false;
        selectForm.selectAction.value = selectedValue;
        selectForm.submit();
    }

    function submitRegForm(form) {
        if(form.client.value.trim() ||
                form.amount.value.trim() ||
                form.addressFrom.value.trim() ||
                form.addressTo.value.trim()) {
            alert("Please, fill in all fields!");
            return;
        }
        var amount = form.amount.value;
        if(isNaN(+amount) || amount.search('.') || amount.search(',')) {
            alert("Please, enter cost amount as integer number");
            return;
        }
        form.submit();
    }

</script>

</body>
</html>
