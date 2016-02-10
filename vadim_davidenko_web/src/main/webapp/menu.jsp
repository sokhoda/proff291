<%@ page import="hw6.notes.domain.Notebook" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: v.davidenko
  Date: 08.02.2016
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<table align="center">
  <tr><td colspan="3"><div style="background-color: #d4ecff">
     <h2>&nbsp;&nbsp;Notebooks Reference</h2>
  </div></td></tr>
  <tr>

  <td width="570px">
<%--Notebooks menu form--%>
    <form name="menuForm" action="/notebookServlet" method="post">
        <table border="0" cellpadding="2" style="background-color: #d4ecff">
            <tr>
                <td><input type="radio" name="menuOption" value="1"></td>
                <td>Add new notebook</td>
                <td colspan="4"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="2"></td>
                <td>Change market price</td>
                <td align="right">Id:</td>
                <td><input type="text" name="id_2" size="4" maxlength="5"/></td>
                <td align="right">Price:</td>
                <td><input type="text" name="price_2" size="6" maxlength="7"/></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="3"></td>
                <td>Change serial number and vendor</td>
                <td align="right">Id:</td>
                <td><input type="text" name="id_3" size="4" maxlength="5"/></td>
                <td align="right">Serial:</td>
                <td><input type="text" name="serial_3" size="10" maxlength="20"/></td>
            </tr>
            <tr>
                <td colspan="4"></td>
                <td align="right">Vendor:</td>
                <td><input type="text" name="vendor_3" size="12" maxlength="20"/>&nbsp;</td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="4"></td>
                <td>Remove notebook</td>
                <td align="right">Id:</td>
                <td><input type="text" name="id_4" size="4" maxlength="5"/></td>
                <td colspan="2"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="5"></td>
                <td>Remove notebooks by model</td>
                <td align="right">Model:</td>
                <td><input type="text" name="model_5" size="12" maxlength="20"/></td>
                <td colspan="2"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="6"></td>
                <td>Show all notebooks</td>
                <td colspan="4"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="7"></td>
                <td>Show notebooks by vendor</td>
                <td align="right">Vendor:</td>
                <td><input type="text" name="vendor_7" size="12" maxlength="20"/></td>
                <td colspan="2"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="8"></td>
                <td>Show by price and date</td>
                <td align="right">Price:</td>
                <td><input type="text" name="price_8" size="6" maxlength="7"/></td>
                <td align="right">Date:</td>
                <td><input type="text" name="date_8" size="10" maxlength="10"/></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="9"></td>
                <td>Show by price range, vendor</td>
                <td align="right">From:</td>
                <td><input type="text" name="priceFrom" size="6" maxlength="7"/></td>
                <td align="right">To:</td>
                <td><input type="text" name="priceTo" size="6" maxlength="7"/></td>
            </tr>
            <tr>
                <td></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;and date before</td>
                <td align="right">Vendor:</td>
                <td><input type="text" name="vendor_9" size="12" maxlength="20"/></td>
                <td align="right">Date:</td>
                <td><input type="text" name="date_9" size="10" maxlength="10"/></td>
            </tr>
            <tr><td colspan="6"><hr/></td></tr>
            <tr>
                <td></td>
                <td align="center"><input type="submit" value="Select" style="width: 110px"/></td>
                <td align="center" colspan="3"><a href="index.jsp">Log off</a></td>
                <td colspan="2"></td>
            </tr>
        </table>
    </form>

<%--Form fields default values--%>
<script>
    document.menuForm.menuOption.value = ('${menuOption}' == '') ? '1' : '${menuOption}';
    document.menuForm.id_2.value = ('${id_2}' == '') ? '1' : '${id_2}';
    document.menuForm.price_2.value = ('${price_2}' == '') ? '0.00' : '${price_2}';
    document.menuForm.id_3.value = ('${id_3}' == '') ? '1' : '${id_3}';
    document.menuForm.serial_3.value = ('${serial_3}' == '') ? '' : '${serial_3}';
    document.menuForm.vendor_3.value = ('${vendor_3}' == '') ? '' : '${vendor_3}';
    document.menuForm.id_4.value = ('${id_4}' == '') ? '1' : '${id_4}';
    document.menuForm.model_5.value = ('${model_5}' == '') ? '' : '${model_5}';
    document.menuForm.vendor_7.value = ('${vendor_7}' == '') ? '' : '${vendor_7}';
    document.menuForm.price_8.value = ('${price_8}' == '') ? '0.00' : '${price_8}';
    document.menuForm.date_8.value = ('${date_8}' == '') ? '' : '${date_8}';
    document.menuForm.priceFrom.value = ('${priceFrom}' == '') ? '0.00' : '${priceFrom}';
    document.menuForm.priceTo.value = ('${priceTo}' == '') ? '0.00' : '${priceTo}';
    document.menuForm.vendor_9.value = ('${vendor_9}' == '') ? '' : '${vendor_9}';
    document.menuForm.date_9.value = ('${date_9}' == '') ? '' : '${date_9}';
</script>

<%--Server messages--%>
<p style="color: green"><b>${server_msg}</b></p>
<p style="color: red"><b>${server_err_msg}</b></p>

</td>
<td width="30"></td>
<td width="700px" valign="top">

<%--Notebook registration form--%>
<%
    String option = (String) request.getAttribute("menuOption");
    if (option != null && option.equals("1")) {
%>
<h3>&nbsp;Notebook registration</h3>
<form name="regForm" action="/notebookServlet" method="post">
    <table border="0" cellpadding="6" style="background-color: #d4ecff">
        <tr>
            <td>Model name:</td>
            <td><input type="text" name="model" size="20" maxlength="20"/>&nbsp;</td>
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
            <td><input type="text" name="date" size="10" maxlength="10"/></td>
        </tr>
        <tr>
            <td>Market price:</td>
            <td><input type="text" name="price" size="6" maxlength="7"/></td>
        </tr>
        <tr><td colspan="2"><hr/></td></tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Save" style="width: 110px"/></td>
        </tr>
    </table>
</form>
<% } %>


<%--Notebooks list--%>
<table border="1" cellpadding="3"  style="background-color: #d4ecff">
    <%
        List<Notebook> notes = (List<Notebook>)request.getAttribute("notesList");
        if(notes != null && !notes.isEmpty()){
    %>
    <h3>Notebooks list</h3>
    <tr>
        <th>Id</th>
        <th>Model</th>
        <th>Vendor</th>
        <th>Serial</th>
        <th>Manuf. date</th>
        <th>Price</th>
    </tr>
    <tr><td colspan="6"><hr/></td></tr>
    <%
        for (Notebook note : notes){
    %>
    <tr>
        <td><%= String.valueOf(note.getId()) %></td>
        <td><%= note.getModel() %></td>
        <td><%= note.getVendor() %></td>
        <td><%= note.getSerial() %></td>
        <td><%= String.valueOf(note.getManufactureDate()) %></td>
        <td><%= String.valueOf(note.getPrice()) %></td>
    </tr>
    <%
            }
        }
    %>
</table>

</td>
</tr>
</table>

</body>
</html>
