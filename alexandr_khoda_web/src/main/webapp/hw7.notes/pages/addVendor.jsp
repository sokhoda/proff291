<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="static hw6.notes.view.Menu.*" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.notes.domain.Vendor" %>
<%@ page import="sun.plugin2.gluegen.runtime.CPU" %>
<%@ page import="hw7.notes.domain.Memory" %>
<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>
<script src="/hw7.notes/JS/select.js" type="text/javascript">    </script>
<script src="/hw7.notes/JS/notebooks.js" type="text/javascript">    </script>

<html>
<head>
    <title>Add Vendor</title>
    <style>
        <%@include file='/hw7.notes/css/addNotebook.css' %>
    </style>
</head>
<body>
<%
    String vendor = getAttribValue(request, "vendorA");

    String[] message = getAttribArray(request);
%>

<form>
    <img src="/hw7.notes/img/addLaptop1.jpg" align="left" style="margin-right: 20px">
    <label for="vendors">VENDOR:</label>
    <input  type="text" value="<%=vendor%>" placeholder="TOSHIBA"
            name="vendor" id="vendors"><br>

    <br><br>
    <br><br>
    <p style="text-align: center;">
        <input type="submit" name="back" value="&longleftarrow; back"  action="/addVen" method="get">
        <input type="submit" name="add" value="Add"  action="/addVen" method="get">
        <button name="clear" onclick="clearElemContent('vendors');">Clear All</button>
    </p>
    <br>
    <br>
    <label id="message" style="width: 100%; margin-top:10%; color:<%=message[0]%>;
            text-align: center; font-size:x-large"><%=message[1]%>
    </label>
</form>

</body>
</html>