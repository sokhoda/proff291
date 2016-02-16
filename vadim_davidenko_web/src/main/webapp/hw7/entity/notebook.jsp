<%@ page import="hw7.notes.domain.Vendor" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.notes.domain.CPU" %>
<%@ page import="hw7.notes.domain.Memory" %>
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
    <form name="notebookForm" action="/noteServlet" method="post">
        <input type="hidden" name="entityId">
      <table border="0" cellpadding="6" style="background-color: #d4ecff">
        <tr><td colspan="2" align="center"><h3>Notebook registration</h3></td></tr>
        <tr>
          <td align="right">Model name:</td>
          <td><input type="text" name="model" size="25" maxlength="25"/></td>
        </tr>
        <tr>
          <td align="right">Manuf. date:</td>
          <td>
            <input type="text" name="date" hidden/>
            <input type="text" name="dd" size="2" maxlength="2"/>.
            <input type="text" name="mm" size="2" maxlength="2"/>.
            <input type="text" name="yyyy" size="4" maxlength="4"/>
          </td>
        </tr>

        <tr>
          <td align="right">Vendor name:</td>
          <td>
            <select size="3" id="vendor" name="vendor">
            <option disabled>No selected ...................</option>
            <%
              String vendorId = (String)request.getAttribute("vendorId");
              List<Vendor> vendorList = (List<Vendor>)request.getAttribute("vendorList");
              if(vendorList != null && !vendorList.isEmpty()){
                for (Vendor vendor : vendorList){
            %>
            <option <%=(String.valueOf(vendor.getId()).equals(vendorId)) ? "selected" : ""%>
                    value="<%=String.valueOf(vendor.getId())%>"><%=vendor.getName()%></option>
            <% } } %>
            </select>
          </td>
        </tr>

        <tr>
          <td align="right">CPU name:</td>
          <td>
            <select size="3" id="cpu" name="cpu">
              <option disabled>No selected ...................</option>
              <%
                String cpuId = (String)request.getAttribute("cpuId");
                List<CPU> cpuList = (List<CPU>)request.getAttribute("cpuList");
                if(cpuList != null && !cpuList.isEmpty()){
                  for (CPU cpu : cpuList){
              %>
              <option <%=(String.valueOf(cpu.getId()).equals(cpuId)) ? "selected" : ""%>
                      value="<%=String.valueOf(cpu.getId())%>"><%=cpu.getModel()%></option>
              <% } } %>
            </select>
          </td>
        </tr>

        <tr>
          <td align="right">Memory type:</td>
          <td>
            <select size="3" id="memory" name="memory">
              <option disabled>No selected ...................</option>
              <%
                String memoryId = (String)request.getAttribute("memoryId");
                List<Memory> memoryList = (List<Memory>)request.getAttribute("memoryList");
                if(memoryList != null && !memoryList.isEmpty()){
                  for (Memory memory : memoryList){
              %>
              <option <%=(String.valueOf(memory.getId()).equals(memoryId)) ? "selected" : ""%>
                      value="<%=String.valueOf(memory.getId())%>">
                <%=memory.getVendor() + " " + memory.getSize()%></option>
              <% } } %>
            </select>
          </td>
        </tr>

        <tr><td colspan="2"><hr/></td></tr>
        <tr>
          <td colspan="2" align="center">
            <input type="button" value="Save" onclick="submitForm()" style="width: 80px"/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/hw7/menu.jsp"><input type="button" value="Back" style="width: 80px"/></a>
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
  document.notebookForm.entityId.value = '${entityId}';
  document.notebookForm.model.value = '${model}';
  if ('${date}'.length == 10) {
    document.notebookForm.dd.value = '${date}'.substring(0, 2);
    document.notebookForm.mm.value = '${date}'.substring(3, 5);
    document.notebookForm.yyyy.value = '${date}'.substring(6);
  }

  function submitForm() {
    var form = document.notebookForm;
    if(!form.model.value.trim() || !form.vendor.value.trim() ||
            !form.cpu.value.trim() || !form.memory.value.trim() ||
            !form.dd.value.trim() || !form.mm.value.trim() ||
            !form.yyyy.value.trim()) {
      alert("Please, fill in all fields with valid values!");
    } else {
      form.date.value = readDate(form.dd, form.mm, form.yyyy);
      form.submit();
    }
  }

  function readDate(dd, mm, yyyy) {
    var d = (dd.value.length == 1) ? '0' + dd.value : dd.value;
    var m = (mm.value.length == 1) ? '0' + mm.value : mm.value;
    var y = yyyy.value;
    return d + '.' + m + '.' + y;
  }
</script>

</body>
</html>
