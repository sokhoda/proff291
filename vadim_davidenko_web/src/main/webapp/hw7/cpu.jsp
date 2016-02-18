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
      <input type="hidden" name="action">
      <table border="0" cellpadding="6" style="background-color: #d4ecff">
        <tr><td colspan="2" align="center"><b>CPU</b></td></tr>
        <tr><td colspan="2"><hr/></td></tr>
        <tr>
          <td align="right">Id:</td>
          <td><input type="text" name="id" size="4" readonly></td>
        </tr>
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
          <td align="center">
            <input type="button" value="New" onclick="newEntity()" style="width: 70px"/>
          </td>
          <td align="center">
            <input type="button" value="Edit" onclick="editEntity()" style="width: 70px"/>
            &nbsp;id:&nbsp;<input type="text" name="selectedId" size="5" maxlength="5"/>
          </td>
        </tr>
        <tr>
          <td align="center">
            <input type="button" value="Save" onclick="submitForm()" style="width: 70px"/>
          </td>
          <td align="left">
            <a href="hw7/menu.jsp"><input type="button" value="Back" style="width: 70px"/></a>
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
  document.cpuForm.id.value = '${id}';
  document.cpuForm.selectedId.value = '${selectedId}';
  document.cpuForm.model.value = '${model}';
  document.cpuForm.vendor.value = '${vendor}';
  document.cpuForm.frequency.value = '${frequency}';

  function submitForm() {
    var form = document.cpuForm;
    if(checkFields(form)) {
      document.cpuForm.action.value = 'save';
      form.submit();
    }
  }

  function newEntity() {
    document.cpuForm.id.value = '';
    document.cpuForm.selectedId.value = '';
    document.cpuForm.model.value = '';
    document.cpuForm.vendor.value = '';
    document.cpuForm.frequency.value = '';

  }

  function editEntity() {
    var id = document.cpuForm.selectedId.value.trim();
    if(!id || isNaN(+id)) {
      alert("Please, fill in Id with numeric value!");
    } else {
      document.cpuForm.action.value = 'find';
      document.cpuForm.submit();
    }
  }

  function checkFields(form) {
    if(!form.model.value.trim() || !form.vendor.value.trim() || !form.frequency.value.trim()) {
      alert("Please, fill in all fields with valid values!");
      return false;
    }
    return true;
  }
</script>

</body>
</html>
