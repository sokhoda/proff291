<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: s_okhoda
  Date: 17.02.2016
  Time: 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>

<script src="/hw7.notes/JS/select.js" type="text/javascript">    </script>

<html>
<head>
    <title>Add notebooks</title>
    <style>
        <%@include file='../css/addNote2Store.css' %>
    </style>
</head>
<body>
<%!
    List<String> list1;
%>
<%
    list1 = (List<String>) request.getAttribute("list");
%>
<form action="/add2Store" method="post">
    <p>
        <select size="<%list1.size();%>" name="list1" id="list1">
            <option disabled>select item</option>
            <%
                for (String s : list1) {
            %>
            <option value="<%s%>"><%s%></option>
            <%
                }
            %>
        </select>
    </p>
    <p><input type="submit" value="Отправить"></p>

    <script type="text/javascript">
        document.getElementById("list1").selectedindex = 0;
    </script>
</form>
</body>
</html>
