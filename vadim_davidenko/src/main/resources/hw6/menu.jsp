<%@ page import="hw6.Notebook" %>
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
  <tr><td align="center">
      <h2>Notebooks Reference</h2>
  </td></tr>

  <tr><td align="center" valign="top">

<%--Notebooks menu form--%>
    <form name="menuForm" action="/notebookServlet" method="get">
        <table border="0" cellpadding="3" style="background-color: #d4ecff" width="1000">
            <tr>
                <td><input type="radio" name="menuOption" value="add_new"></td>
                <td>Add new notebook</td>
                <td colspan="8"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="edit_price"></td>
                <td>Change market price</td>
                <td align="right">Id:</td>
                <td><input type="text" name="id_2" size="5" maxlength="5"/></td>
                <td align="right">Price:</td>
                <td><input type="text" name="price_2" size="10" maxlength="10"/></td>
                <td colspan="4"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="edit_serial_vendor"></td>
                <td>Change serial number and vendor</td>
                <td align="right">Id:</td>
                <td><input type="text" name="id_3" size="5" maxlength="5"/></td>
                <td align="right">Serial:</td>
                <td><input type="text" name="serial_3" size="10" maxlength="20"/></td>
                <td align="right">Vendor:</td>
                <td><input type="text" name="vendor_3" size="10" maxlength="20"/></td>
                <td colspan="2"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="del_by_id"></td>
                <td>Remove notebook</td>
                <td align="right">Id:</td>
                <td><input type="text" name="id_4" size="5" maxlength="5"/></td>
                <td colspan="2"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="del_by_model"></td>
                <td>Remove notebooks by model</td>
                <td align="right">Model:</td>
                <td><input type="text" name="model_5" size="10" maxlength="20"/></td>
                <td colspan="6"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="show_all"></td>
                <td>Show all notebooks</td>
                <td colspan="8"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="show_by_vendor"></td>
                <td>Show notebooks by vendor</td>
                <td align="right">Vendor:</td>
                <td><input type="text" name="vendor_7" size="10" maxlength="20"/></td>
                <td colspan="6"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="show_by_price_date"></td>
                <td>Show notebooks by price and date</td>
                <td align="right">Price:</td>
                <td><input type="text" name="price_8" size="10" maxlength="10"/></td>
                <td align="right">Date:</td>
                <td colspan="2">
                    <input type="text" name="date_8" hidden/>
                    <input type="text" name="dd_8" size="2" maxlength="2"/>.
                    <input type="text" name="mm_8" size="2" maxlength="2"/>.
                    <input type="text" name="yyyy_8" size="4" maxlength="4"/>
                </td>
                <td colspan="5"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="show_by_price_range_vendor_date_before"></td>
                <td width="290">Show by price range, vendor and date before</td>
                <td align="right">From:</td>
                <td><input type="text" name="priceFrom" size="10" maxlength="10"/></td>
                <td align="right">To:</td>
                <td><input type="text" name="priceTo" size="10" maxlength="10"/></td>
                <td align="right">Vendor:</td>
                <td><input type="text" name="vendor_9" size="10" maxlength="20"/></td>
                <td align="right">Date:</td>
                <td>
                    <input type="text" name="date_9" hidden/>
                    <input type="text" name="dd_9" size="2" maxlength="2"/>.
                    <input type="text" name="mm_9" size="2" maxlength="2"/>.
                    <input type="text" name="yyyy_9" size="4" maxlength="4"/>
                </td>
            </tr>
            <tr><td colspan="10"><hr/></td></tr>
            <tr>
                <td></td>
                <td align="center">
                    <input type="button" value="Select" onclick="submitMenuForm(document.menuForm)" style="width: 110px"/>
                </td>
                <td align="center" colspan="3"><a href="../index.jsp">Log off</a></td>
                <td colspan="5"></td>
            </tr>
        </table>
    </form>

<%--Form fields default values--%>
<script>
    document.menuForm.menuOption.value = ('${menuOption}' == '') ? 'add_new' : '${menuOption}';
    document.menuForm.id_2.value = ('${id_2}' == '') ? '1' : '${id_2}';
    document.menuForm.price_2.value = ('${price_2}' == '') ? '0.00' : '${price_2}';
    document.menuForm.id_3.value = ('${id_3}' == '') ? '1' : '${id_3}';
    document.menuForm.serial_3.value = ('${serial_3}' == '') ? '' : '${serial_3}';
    document.menuForm.vendor_3.value = ('${vendor_3}' == '') ? '' : '${vendor_3}';
    document.menuForm.id_4.value = ('${id_4}' == '') ? '1' : '${id_4}';
    document.menuForm.model_5.value = ('${model_5}' == '') ? '' : '${model_5}';
    document.menuForm.vendor_7.value = ('${vendor_7}' == '') ? '' : '${vendor_7}';
    document.menuForm.price_8.value = ('${price_8}' == '') ? '0.00' : '${price_8}';
    if ('${date_8}'.length == 10) {
        document.menuForm.dd_8.value = '${date_8}'.substring(0, 2);
        document.menuForm.mm_8.value = '${date_8}'.substring(3, 5);
        document.menuForm.yyyy_8.value = '${date_8}'.substring(6);
    }
    document.menuForm.priceFrom.value = ('${priceFrom}' == '') ? '0.00' : '${priceFrom}';
    document.menuForm.priceTo.value = ('${priceTo}' == '') ? '0.00' : '${priceTo}';
    document.menuForm.vendor_9.value = ('${vendor_9}' == '') ? '' : '${vendor_9}';
    if ('${date_9}'.length == 10) {
        document.menuForm.dd_9.value = '${date_9}'.substring(0, 2);
        document.menuForm.mm_9.value = '${date_9}'.substring(3, 5);
        document.menuForm.yyyy_9.value = '${date_9}'.substring(6);
    }
</script>

<%--Server messages--%>
<p style="color: green"><b>${server_msg}</b></p>
<p style="color: red"><b>${server_err_msg}</b></p>

</td></tr>

<%--Notebooks list--%>
<tr><td>
<br/>
<table border="1" cellpadding="3">
    <tr style="background-color: #d4ecff">
        <th width="70px">Id</th>
        <th width="175px">Model</th>
        <th width="175px">Vendor</th>
        <th width="175px">Serial</th>
        <th width="170px">Manufacture date</th>
        <th width="170px">Price</th>
    </tr>
    <%
        List<Notebook> notes = (List<Notebook>)request.getAttribute("notesList");
        if(notes != null && !notes.isEmpty()){
        for (Notebook note : notes) {
    %>
    <tr>
        <td align="center"><%= String.valueOf(note.getId()) %></td>
        <td align="center"><%= note.getModel() %></td>
        <td align="center"><%= note.getVendor() %></td>
        <td align="center"><%= note.getSerial() %></td>
        <%--<td align="center"><%= String.valueOf(note.getManufactureDate()).substring(0, 10) %></td>--%>
        <td align="center"><%= note.getManufactureDateStr() %></td>
        <td align="center"><%= String.valueOf(note.getPrice()) %></td>
    </tr>
    <%
            }
        }
    %>
</table>

</td>
</tr>
</table>

<%--Checking fields script--%>
<script>
    function submitMenuForm(form) {
        if (checkMenuFields(form)) {
            if (form.menuOption.value == 'del_by_id' || form.menuOption.value == 'del_by_model') {
                if (!confirm("Are you sure to remove this notebook(s)?")) return;
            }
            form.date_8.value = readDate(form.dd_8, form.mm_8, form.yyyy_8);
            form.date_9.value = readDate(form.dd_9, form.mm_9, form.yyyy_9);
            form.submit();
        }
    }

    function checkMenuFields(form) {
        var isEmpty = false;
        switch (form.menuOption.value) {
            case 'edit_price':
                if(!form.id_2.value.trim() || !form.price_2.value.trim()) isEmpty = true;
                break;
            case 'edit_serial_vendor':
                if(!form.id_3.value.trim() || !form.serial_3.value.trim() ||
                        !form.vendor_3.value.trim()) isEmpty = true;
                break;
            case 'del_by_id':
                if(!form.id_4.value.trim()) isEmpty = true;
                break;
            case 'del_by_model':
                if(!form.model_5.value.trim()) isEmpty = true;
                break;
            case 'show_by_vendor':
                if(!form.vendor_7.value.trim()) isEmpty = true;
                break;
            case 'show_by_price_date':
                if(!form.price_8.value.trim() || !form.dd_8.value.trim() ||
                   !form.mm_8.value.trim() || !form.yyyy_8.value.trim()) isEmpty = true;
                break;
            case 'show_by_price_range_vendor_date_before':
                if(!form.priceFrom.value.trim() || !form.priceTo.value.trim() ||
                   !form.vendor_9.value.trim() || !form.dd_9.value.trim() ||
                   !form.mm_9.value.trim() || !form.yyyy_9.value.trim()) isEmpty = true;
                break;
            default:
        }
        if (isEmpty) {
            alert("Please, fill in all fields with valid values!");
            return false;
        }
        return true;
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
