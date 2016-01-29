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

<h3>Client registration</h3>
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
      <tr><td colspan="2"><hr/></td></tr>
      <tr>
        <td align="center"><input type="button" value="Submit" onclick="submitForm(document.regForm)" style="width: 70px"/></td>
        <td align="center"><a href="index.jsp">Welcome page</a></td>
      </tr>
    </table>
  </form>

</div>
<div style="clear: both"></div>
<p style="color: red"><b>${server_msg}</b></p>

<script>
  function submitForm(form) {
    if(!checkEmptyFields(form)) {
      alert("Please, fill in all fields!");
      return;
    }
    if(!checkPhoneNumber(form)) {
      alert("Please, enter correct phone number (12 digits)");
      return;
    }
    form.submit();
  }

  function checkEmptyFields(form) {
    return (form.clientName.value.trim() &&
            form.clientSurname.value.trim() &&
            form.clientPhone.value.trim());
  }

  function checkPhoneNumber(form) {
      var phoneNumber = +form.clientPhone.value.replace(' ', '');
      return (!isNaN(phoneNumber) && phoneNumber.length == 12);
  }

</script>


</body>
</html>
