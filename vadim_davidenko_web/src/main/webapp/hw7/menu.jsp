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
                <input type="button" value="New" onclick="submitEntity()" style="width: 80px"/>
                &nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="Edit" onclick="submitEntity()" style="width: 80px"/>
                &nbsp;Id:<input type="text" name="id" size="5" maxlength="5"/>
            </td>
        </tr>
    </table>

    <table cellpadding="3">
        <tr><td colspan="7"><b>Store operations</b></td></tr>
        <tr>
            <td><input type="button" value="Receive" onclick="submitReceive()" style="width: 80px"/></td>
            <td align="right">Note id:</td>
            <td><input type="text" name="noteId"  size="5" maxlength="5"/>
            <td align="right">Amount:</td>
            <td><input type="text" name="receiveAmount" size="5" maxlength="5"/></td>
            <td align="right">Price:</td>
            <td><input type="text" name="receivePrice"  size="7" maxlength="7"/>
        </tr>
        <tr>
            <td><input type="button" value="Remove" onclick="submitRemove()" style="width: 80px"/></td>
            <td align="right">Store id:</td>
            <td><input type="text" name="storeIdRemove"  size="5" maxlength="5"/>
            <td align="right">Amount:</td>
            <td><input type="text" name="removeAmount" size="5" maxlength="5"/></td>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td><input type="button" value="Sale" onclick="submitSale()" style="width: 80px"/></td>
            <td align="right">Store id:</td>
            <td><input type="text" name="storeIdSale"  size="5" maxlength="5"/>
            <td align="right">Amount:</td>
            <td><input type="text" name="saleAmount" size="5" maxlength="5"/></td>
            <td colspan="2"></td>
        </tr>
    </table>

    <table cellpadding="3">
        <tr><td colspan="3"><b>Reports</b></td></tr>
        <tr>
            <td><input type="radio" name="reportMenu" value="byPortion" checked></td>
            <td>Show notebooks by portion:</td>
            <td><input type="text" name="portion" size="2" maxlength="2"/></td>
        </tr>
        <tr>
            <td><input type="radio" name="reportMenu" value="gtAmount"></td>
            <td>Show notebooks greater then amount:</td>
            <td><input type="text" name="gtAmount" size="5" maxlength="5"/></td>
        </tr>
        <tr>
            <td><input type="radio" name="reportMenu" value="byCPU"></td>
            <td>Show notebooks by CPU vendor:</td>
            <td><input type="text" name="cpuVendor" size="20" maxlength="20"/></td>
        </tr>
        <tr>
            <td><input type="radio" name="reportMenu" value="storeAll" checked></td>
            <td colspan="2">Show notebooks from store</td>
        </tr>
        <tr>
            <td><input type="radio" name="reportMenu" value="storePresent"></td>
            <td colspan="2">Show notebooks present on market</td>
        </tr>
        <tr>
            <td><input type="radio" name="reportMenu" value="salesByDays"></td>
            <td colspan="2">Show notebook sales per day</td>
        </tr>
        <tr>
            <td></td>
            <td colspan="2"><input type="button" value="Select" onclick="submitReport()" style="width: 80px"/></td>
        </tr>
    </table>
    </td></tr></table>
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
        document.menuForm.menuOption.value = 'report';
        document.menuForm.submit();
    }
</script>

<%--<h4>Entity</h4>--%>
<%--<ul>--%>
  <%--<li><a href="../hw7_old/notebook_list.jsp">Notebook type</a></li>--%>
  <%--<li><a href="../hw7_old/vendor_list.jsp">Vendor</a></li>--%>
  <%--<li><a href="../hw7_old/cpu_list.jsp">CPU</a></li>--%>
  <%--<li><a href="../hw7_old/memory_list.jsp">Memory</a></li>--%>
<%--</ul>--%>


</body>
</html>
