<%--
  Created by IntelliJ IDEA.
  User: i.gonchar
  Date: 2/10/2016
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! public int counter = 1; %>
<html>
<head>
    <title>Notebooks</title>
</head>
<body>
<script src="js/notebooks.js" type="text/javascript"></script>
<h2>Notebooks List</h2>
<table style="width:100%" border="1">
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
    <td>New Price:</td>
    </tr>
    <tr>
        <form id="form3" action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row3"/>
            <td><input id="r3c1" type="text" name="id"/></td>
            <td><input id="r3c2" type="text" name="price"/></td>
            <td><input type="button" onclick="validateRow3()" value="Edit"/></td>
        </form>
    </tr>
    <tr>
        <input type="hidden" name="pageName" value="row1Labe4"/>
        <td>Put ID:</td>
        <td>New Price:</td>
        <td>New Serial:</td>
    </tr>
    <tr>
        <form id="form4" action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row4"/>
            <td><input id="r4c1" type="text" name="id"/></td>
            <td><input id="r4c2" type="text" name="price"/></td>
            <td><input id="r4c3" type="text" name="serial"/></td>
            <td><input type="button" onclick="validateRow4()" value="Edit"/></td>
        </form>
    </tr>
    <tr>
        <input type="hidden" name="pageName" value="row1Labe5"/>
        <td>Put Model:</td>
    </tr>
    <tr>
        <form id="form5" action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row5"/>
            <td><input  id="r5c1" type="text" name="model"/></td>
            <td><input type="button" onclick="validateRow5()" value="Delete"/></td>
        </form>
    </tr>
    <tr>
        <input type="hidden" name="pageName" value="row1Labe6"/>
        <td>Put Vendor:</td>
    </tr>
    <tr>
        <form id="form6" action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row6"/>
            <td><input type="text" name="vendor"/></td>
            <td><input type="submit" value="Show"/></td>
        </form>
    </tr>
    <tr>
        <input type="hidden" name="pageName" value="row1Labe7"/>
        <td>Put Price:</td>
        <td>Put Year:</td>
    </tr>
    <tr>
        <form id="form7" action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row7"/>
            <td><input type="text" name="price"/></td>
            <td><input type="text" name="year"/></td>
            <td><input type="submit" <%--onclick="validateRow7()"--%> value="Show"/></td>
        </form>
    </tr>
        <td>
            <form action="/notebooksForm" method="post">
            <input type="hidden" name="pageName" value="row8"/>
            <td><input type="submit" value="Show All"/></td>
        </form>
        </td>
    </tr>
</table>
<a href="index.jsp">
    <button style="width:100%">Back Home</button>
</a>
<p>
    ${reg_result} <%--: <%=  counter++  %>--%>
</p>
<div id="tableDiv">

</div>
</body>
</html>
