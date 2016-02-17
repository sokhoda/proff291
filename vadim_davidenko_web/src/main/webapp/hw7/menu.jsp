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

<form name="menuForm" action="/menuServlet" method="post">
    <input type="hidden" name="menuOption">

    <table cellpadding="4" align="center" style="background-color: #d4ecff">
        <tr><td align="center"><b>NOTEBOOKS MARKET</b></td></tr>
        <tr><td><hr/></td></tr>
        <tr><td>

    <table cellpadding="3">
        <tr><td colspan="2"><b>Entity management</b></td></tr>
        <tr>
            <td width="20"><input type="radio" name="entityMenu" value="notebook" checked></td>
            <td>Notebook model</td>
        </tr>
        <tr>
            <td width="20"><input type="radio" name="entityMenu" value="vendor"></td>
            <td>Vendor name</td>
        </tr>
        <tr>
            <td width="20"><input type="radio" name="entityMenu" value="cpu"></td>
            <td>CPU type</td>
        </tr>
        <tr>
            <td width="20"><input type="radio" name="entityMenu" value="memory"></td>
            <td>Memory type</td>
        </tr>
        <tr>
            <td colspan="2" align="left">
                <input type="button" value="Select" onclick="submitEntity()" style="width: 80px"/>
            </td>
        </tr>
    </table>

    <table cellpadding="3">
        <tr><td colspan="7"><hr/></td></tr>
        <tr><td colspan="7"><b>Store operations</b></td></tr>
        <tr>
            <td><input type="button" value="Receive" onclick="submitReceive()" style="width: 80px"/></td>
            <td align="right">Note id:</td>
            <td><input type="text" name="noteIdReceive"  size="5" maxlength="5"/>
            <td align="right">Amount:</td>
            <td><input type="text" name="amountReceive" size="5" maxlength="5"/></td>
            <td align="right">Price:</td>
            <td><input type="text" name="priceReceive"  size="7" maxlength="7"/>
        </tr>
        <tr>
            <td><input type="button" value="Remove" onclick="submitRemove()" style="width: 80px"/></td>
            <td align="right">Note id:</td>
            <td><input type="text" name="noteIdRemove"  size="5" maxlength="5"/>
            <td align="right">Amount:</td>
            <td><input type="text" name="amountRemove" size="5" maxlength="5"/></td>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td><input type="button" value="Sale" onclick="submitSale()" style="width: 80px"/></td>
            <td align="right">Store id:</td>
            <td><input type="text" name="storeIdSale"  size="5" maxlength="5"/>
            <td align="right">Amount:</td>
            <td><input type="text" name="amountSale" size="5" maxlength="5"/></td>
            <td colspan="2"></td>
        </tr>
        <tr><td colspan="7" align="center"><i>${server_msg}</i></td></tr>
        <tr><td colspan="7"><hr/></td></tr>
        <tr><td colspan="7"><b>Reports</b></td></tr>
        <tr>
            <td colspan="2"><input type="button" value="Menu" onclick="submitReport()" style="width: 80px"/></td>
            <td colspan="5" align="right"><a href="../index.jsp">Log off</a></td>
        </tr>
    </table>

    </td></tr>
    </table>
</form>

<script>
    function submitEntity() {
        document.menuForm.menuOption.value = 'entity';
        document.menuForm.submit();
    }

    function submitReceive() {
        document.menuForm.menuOption.value = 'receive';
        document.menuForm.submit();
    }

    function submitRemove() {
        document.menuForm.menuOption.value = 'remove';
        document.menuForm.submit();
    }

    function submitSale() {
        document.menuForm.menuOption.value = 'sale';
        document.menuForm.submit();
    }

    function submitReport() {
        document.menuForm.menuOption.value = 'reports';
        document.menuForm.submit();
    }
</script>


</body>
</html>
