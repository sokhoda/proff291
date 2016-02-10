<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page errorPage="/hw5.users/errorPage.jsp" %>

<html>
<head>
    <title>User management</title>
    <style>
        <%@include file='/hw6.notes/css/addNotebook.css' %>
    </style>
</head>
<body>
<%!
    private String checkDate(GregorianCalendar gc) {
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        if (gc == null) {
            return "null";
        }
        else {
            return format1.format(gc.getTime());
        }
    }
%>
<form action="/MenuNote" method="get">
    <img src="/hw6.notes/img/addLaptop1.jpg" align="left" style="margin-right: 20px">
    <label for="1">SERIAL:</label>
    <input type="text" placeholder="SN-0000-0000-0000" name="serial" id="1"><br>

    <label for="2">VENDOR:</label>
    <input type="text" placeholder="TOSHIBA" name="vendor" id="2"><br>

    <label for="3">MODEL:</label>
    <input  type="text" placeholder="Satellite S-2535LX" name="model"
            id="3"><br>

    <label for="4">DATE OF MANUFACTURE:</label>
    <input  type="text" placeholder="<%=checkDate(new GregorianCalendar())%>"
                name="manDate" id="4"><br>

    <label for="5">PRICE:</label>
    <input  type="text" name="price" id="5">

    <br><br>
    <br><br>
    <p style="text-align: center;">
        <input type="submit" name="back" value="&longleftarrow; back">
        <input type="submit" name="addNoteB" value="Add Notebook">
    </p>
    <%
        String messageColor = "red";
        String messageText = "";
        if (request.getAttribute("FailedCreation") != null) {
            messageColor = "red";
            messageText = (String) request.getAttribute("FailedCreation");
        }
        else if (request.getAttribute("UserAddedSuccess") != null) {
            messageColor = "green";
            messageText = (String) request.getAttribute("UserAddedSuccess");
        }
    %>
    <br>
    <label style="width: 100%; margin-top:10%; color:<%=messageColor%>;
            text-align: center; font-size:x-large"><%=messageText%>
    </label>
</form>

</body>
</html>