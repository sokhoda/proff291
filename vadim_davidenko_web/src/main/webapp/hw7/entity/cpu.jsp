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

<table align="center">
  <tr><td>
    <form name="cpuForm" action="/cpuServlet" method="post">
      <table border="0" cellpadding="6" style="background-color: #d4ecff">
        <tr><td colspan="2" align="center"><h3>CPU registration</h3></td></tr>
        <tr>
          <td align="right">Model name:</td>
          <td><input type="text" name="model" size="20" maxlength="20"/></td>
        </tr>
        <tr>
          <td align="right">Vendor name:</td>
          <td><input type="text" name="vendor" size="20" maxlength="20"/></td>
        </tr>
        <tr>
          <td align="right">Frequency:</td>
          <td><input type="text" name="frequency" size="10" maxlength="10"/></td>
        </tr>
        <tr><td colspan="2"><hr/></td></tr>
        <tr>
          <td colspan="2" align="center">
            <input type="button" value="Save" onclick="submitForm()" style="width: 80px"/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="../menu.jsp"><input type="button" value="Back" style="width: 80px"/></a>
          </td>
        </tr>
      </table>
    </form>
  </td></tr>
  <tr><td colspan="2" align="center">
    <b>${server_msg}</b>
  </td></tr>
</table>

<script>
  document.cpuForm.model.value = '${model}';
  document.cpuForm.vendor.value = '${vendor}';
  document.cpuForm.frequency.value = '${frequency}';

  function submitForm() {
    var form = document.cpuForm;
    if(!form.model.value.trim() || !form.vendor.value.trim() ||
            !form.frequency.value.trim() || isNaN(+form.frequency.value)) {
      alert("Please, fill in all fields with valid values!");
    } else {
      form.submit();
    }
  }
</script>

</body>
</html>
