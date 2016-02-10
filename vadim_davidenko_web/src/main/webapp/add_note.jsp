<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 10.02.2016
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<table align="center">
  <tr><td align="center">
    <h3>Notebook registration</h3>
  </td></tr>

  <tr><td>
    <form name="regForm" action="/notebookServlet" method="post">
      <table border="0" cellpadding="7" style="background-color: #d4ecff">
        <tr>
          <td>Model name:</td>
          <td><input type="text" name="model" size="20" maxlength="20"/></td>
        </tr>
        <tr>
          <td>Vendor name:</td>
          <td><input type="text" name="vendor" size="20" maxlength="20"/></td>
        </tr>
        <tr>
          <td>Serial number:</td>
          <td><input type="text" name="serial" size="20" maxlength="50"/></td>
        </tr>
        <tr>
          <td>Manufacture date:</td>
          <td>
            <input type="text" name="date" hidden/>
            <input type="text" name="dd" size="2" maxlength="2"/>.
            <input type="text" name="mm" size="2" maxlength="2"/>.
            <input type="text" name="yy" size="4" maxlength="4"/>
          </td>
        </tr>
        <tr>
          <td>Market price:</td>
          <td><input type="text" name="price" size="10" maxlength="10"/></td>
        </tr>
        <tr><td colspan="2"><hr/></td></tr>
        <tr>
          <td align="center">
            <input type="button" value="Save" onclick="submitRegForm(document.regForm)" style="width: 100px"/>
          </td>
          <td align="center"><a href="menu.jsp">Menu</a></td>
        </tr>
      </table>
    </form>
  </td></tr>
  <tr><td colspan="2" align="center">
    <p style="color: green"><b>${server_msg}</b></p>
    <p style="color: red"><b>${server_err_msg}</b></p>
  </td></tr>
</table>

<script>
  document.regForm.model.value = '${model}';
  document.regForm.vendor.value = '${vendor}';
  document.regForm.serial.value = '${serial}';
  document.regForm.dd.value = '${date}'.substring(0, 2);
  document.regForm.mm.value = '${date}'.substring(3, 5);
  document.regForm.yy.value = '${date}'.substring(6);
  document.regForm.price.value = '${price}';

  function submitRegForm(form) {
    if (checkRegFields(form)) {
      form.date.value = readDate(form);
      form.submit();
    }
  }

  function checkRegFields(form) {
    if(!form.model.value.trim() || !form.vendor.value.trim() ||
            !form.serial.value.trim() || !form.dd.value.trim() ||
            !form.mm.value.trim() || !form.yy.value.trim() |
            !form.price.value.trim() || isNaN(+form.price.value))
    {
      alert("Please, fill in all fields with valid values!");
      return false;
    }
    return true;
  }

  function readDate(form) {
    var dd = (form.dd.value.length == 1) ? '0' + form.dd.value : form.dd.value;
    var mm = (form.mm.value.length == 1) ? '0' + form.mm.value : form.mm.value;
    return dd + '.' + mm + '.' + form.yy.value;
  }
</script>

</body>
</html>
