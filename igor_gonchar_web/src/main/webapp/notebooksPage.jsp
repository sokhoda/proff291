<%--
  Created by IntelliJ IDEA.
  User: i.gonchar
  Date: 2/10/2016
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notebooks</title>
</head>
<body>
<script src="js/notebooks.js" type="text/javascript"></script>
<h2>Notebooks List</h2>
<table border="1">
    <tr>

            <input type="hidden" name="pageName" value="row1Label"/>
            <td>Put Serial:</td>
            <td>Put Vendor:</td>
            <td>Put Model:</td>
            <td>Put Manuf.Date:</td>
            <td>Put Price:</td>
    </tr>
    <tr>
        <form id="form1" action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row1"/>
            <td><input id="r1c1" type="text" name="serial"/></td>
            <td><input id="r1c2" type="text" name="vendor"/></td>
            <td><input id="r1c3" type="text" name="model"/></td>
            <td><input id="r1c4" type="text" name="manufactureDate"/></td>
            <td><input id="r1c5" type="text" name="price"/></td>
            <td><input type="button" onclick="validateRow1()" value="Add Notebook"/></td>
        </form>
    </tr>
    <tr>

        <input type="hidden" name="pageName" value="row1Labe2"/>
        <td>Put ID:</td>
    </tr>
    <tr>
        <form id="form2" action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row2"/>
            <td><input id="r2c1" type="text" name="id"/></td>
            <td><input type="button" onclick="validateRow2()" value="Delete"/></td>
        </form>
    </tr>
    <tr>
    <input type="hidden" name="pageName" value="row1Labe3"/>
    <td>Put ID:</td>
    <td>Put Serial:</td>
    <td>Put Vendor:</td>
    </tr>
    <tr>
        <form action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row3"/>
            <td><input type="text" name="id"/></td>
            <td><input type="text" name="serial"/></td>
            <td><input type="text" name="vendor"/></td>
            <td><input type="submit" value="Show"/></td>
        </form>
    </tr>
    <tr>
    <input type="hidden" name="pageName" value="row1Labe4"/>
    <td>Put Model:</td>
    </tr>
    <tr>
        <form action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row4"/>
            <td><input type="text" name="model"/></td>
            <td><input type="submit" value="Delete"/></td>
        </form>
    </tr>
    <tr>
        <input type="hidden" name="pageName" value="row1Labe5"/>
        <td>Put Vendor:</td>
    </tr>
    <tr>
        <form action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row5"/>
            <td><input type="text" name="vendor"/></td>
            <td><input type="submit" value="Show"/></td>
        </form>
    </tr>
    <tr>
        <input type="hidden" name="pageName" value="row1Labe6"/>
        <td>Put Price:</td>
        <td>Put Year:</td>
    </tr>
    <tr>
        <form action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row6"/>
            <td><input type="text" name="price"/></td>
            <td><input type="text" name="year"/></td>
            <td><input type="submit" value="Show"/></td>
        </form>
    </tr>
    <tr>
        <td>
            <input type="hidden" name="pageName" value="row7"/>
            <button onclick="connectionSuccess()">Show All</button>
        </td>
    </tr>
</table>
<p>
    ${reg_result}
</p>
<div id="tableDiv">

</div>
</body>
</html>
