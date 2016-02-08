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

<h2>Notebooks reference list</h2>

<%--Notebooks menu form--%>
<div style="float: left">

    <form name="menuForm" action="/notebookServlet" method="post">
        <table border="0" cellpadding="2" style="background-color: #d4ecff">
            <tr>
                <td><input type="radio" name="menuOption" value="1" checked="true"></td>
                <td>Add new notebook</td>
                <td colspan="8"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="2" checked="false"></td>
                <td>Change notebook price</td>
                <td align="right">Id:</td>
                <td><input type="text" name="id" size="5" maxlength="5"/></td>
                <td align="right">Price:</td>
                <td><input type="text" name="price" size="7" maxlength="7"/></td>
                <td colspan="4"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="3" checked="false"></td>
                <td>Change notebook serial and vendor</td>
                <td align="right">Id:</td>
                <td><input type="text" name="id" size="5" maxlength="5"/></td>
                <td align="right">Serial:</td>
                <td><input type="text" name="serial" size="10" maxlength="20"/></td>
                <td align="right">Vendor:</td>
                <td><input type="text" name="vendor" size="15" maxlength="20"/></td>
                <td colspan="4"></td>
            </tr>
            <tr><td colspan="10"><hr/></td></tr>
            <tr>
                <td><input type="radio" name="menuOption" value="4" checked="false"></td>
                <td>Remove notebook</td>
                <td align="right">Id:</td>
                <td><input type="text" name="id" size="5" maxlength="5"/></td>
                <td colspan="6"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="5" checked="false"></td>
                <td>Remove notebook by model</td>
                <td align="right">Model:</td>
                <td colspan="2"><input type="text" name="model" size="15" maxlength="20"/></td>
                <td colspan="5"></td>
            </tr>
            <tr><td colspan="10"><hr/></td></tr>
            <tr>
                <td><input type="radio" name="menuOption" value="6" checked="false"></td>
                <td>Show all notebooks</td>
                <td colspan="8"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="7" checked="false"></td>
                <td>Show by vendor</td>
                <td align="right">Vendor:</td>
                <td colspan="2"><input type="text" name="vendor" size="15" maxlength="20"/></td>
                <td colspan="5"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="8" checked="false"></td>
                <td>Show by price and manufacture date</td>
                <td align="right">Price:</td>
                <td><input type="text" name="price" size="7" maxlength="7"/></td>
                <td align="right">Date:</td>
                <td><input type="text" name="date" size="10" maxlength="10"/></td>
                <td colspan="4"></td>
            </tr>
            <tr>
                <td><input type="radio" name="menuOption" value="9" checked="false"></td>
                <td>Show by price range, vendor and manufacture date before</td>
                <td align="right">From:</td>
                <td><input type="text" name="priceFrom" size="7" maxlength="7"/></td>
                <td align="right">To:</td>
                <td><input type="text" name="priceTo" size="7" maxlength="7"/></td>
                <td align="right">Vendor:</td>
                <td><input type="text" name="vendor" size="15" maxlength="20"/></td>
                <td align="right">Date:</td>
                <td><input type="text" name="date" size="10" maxlength="10"/>&nbsp;</td>
            </tr>
            <tr><td colspan="10"><hr/></td></tr>
            <tr>
                <td></td>
                <td align="center"><input type="submit" value="Submit" style="width: 120px"/></td>
                <td><a href="index.jsp">Log off</a></td>
                <td colspan="7"></td>
            </tr>
        </table>
    </form>

</div>
<div style="clear: both"></div>

<%--Form fields values--%>
<script>
    document.menuForm.menuOption.value = ('${menuOption}' == '') ? '1' : '${menuOption}';
</script>

<%--Server error message--%>
<p style="color: red"><b>${server_err_msg}</b></p>


</body>
</html>
