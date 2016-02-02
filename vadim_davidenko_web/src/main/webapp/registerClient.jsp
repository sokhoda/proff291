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

<h2>Client registration</h2>

<%--Menu line--%>
<table width="600px" border="0" cellpadding="3" style="background-color: #d4ecff">
  <tr>
    <td width="16%" align="center"><a href="dashboard.jsp">Home</a></td>
    <td width="16%" align="center"><a href="orders.jsp">Orders</a></td>
    <td width="16%" align="center"><a href="order.jsp">New order</a></td>
    <td width="16%" align="center"><a href="clients.jsp">Clients</a></td>
    <td width="16%" align="center" style="background-color: lightgreen"
            ><b><a href="registerClient.jsp">New client</a></b></td>
    <td width="16%" align="center"><a href="index.jsp">Logout</a></td>
  </tr>
</table>
<br/>

<%--Client registration form--%>
<div style="float: left">

  <form name="regForm" action="/clientServlet" method="post">
    <table border="0" cellpadding="6" style="background-color: #d4ecff">
      <tr>
        <td>Name:</td>
        <td><input type="text" name="clientName" size="20" maxlength="20"/></td>
      </tr>
      <tr>
        <td>Surname:</td>
        <td><input type="text" name="clientSurname" size="20" maxlength="20"/></td>
      </tr>
      <tr>
        <td>Address:</td>
        <td><input type="text" name="clientAddress" size="20" maxlength="50"/></td>
      </tr>
      <tr>
        <td>Phone:</td>
        <td><input type="text" name="clientPhone" value="380" size="12" maxlength="12"/></td>
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
<p style="color: green"><b>${clientServlet_msg}</b></p>
<p style="color: red"><b>${clientServlet_err_msg}</b></p>

<%--Checking fields script--%>
<script>

  function submitRegForm(form) {
    if (checkFields(form)) form.submit();
  }
  function checkFields(form) {
      if(!form.clientName.value.trim() ||
              !form.clientSurname.value.trim() ||
              !form.clientPhone.value.trim()) {
          alert("Please, fill in all fields!");
          return false;
      }
      var phoneNumber = form.clientPhone.value;
      if(isNaN(+phoneNumber) || phoneNumber.length != 12) {
          alert("Please, enter correct phone number (12 digits)");
          return false;
      }
      return true;
  }

</script>


</body>
</html>
