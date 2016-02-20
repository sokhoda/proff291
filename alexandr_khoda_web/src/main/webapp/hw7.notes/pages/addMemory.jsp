<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static hw7.notes.view.Servlet.*" %>
<%@ page import="hw7.notes.domain.Vendor" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%--<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>--%>
<script src="/hw7.notes/JS/select.js" type="text/javascript">    </script>
<script src="/hw7.notes/JS/notebooks.js" type="text/javascript">    </script>

<html>
<head>
    <title>Add Memory</title>
    <style>
        <%@include file='/hw7.notes/css/addNotebook.css' %>
    </style>
    <center><h1>Add New Memory Type</h1></center>
    <br>

</head>
<body>

<%!
    List<Vendor> vendor = null;
    List<String> size = Arrays.asList("512M", "1G", "2G", "4G", "8G", "16G");

%>
<%
    vendor = (List<Vendor>)request.getAttribute("vendorA");

    String[] message = getAttribArray(request);
//        message[0] = "brown";
//        message[1] = "";
%>

<form action="/AddMem" method="get">
    <img src="/hw7.notes/img/addLaptop1.jpg" align="left" style="margin-right: 20px">
<% if(vendor != null){
%>
        <label for="vendors">VENDOR:</label>
        <select size="<%vendor.size();%>" name="vendor" id="vendors">
        <option disabled>select item</option>
        <%
            for (Vendor v : vendor) {
        %>
        <option value="<%=v.getId()%>"><%=v.getName()%></option>
        <%
            }
        %>
        </select>
        <script> setSelectIndex('vendors',0); </script>
        <br>
<%
    }
%>

    <label for="size">SIZE:</label>
    <select size="<%size.size();%>" name="size" id="size">
        <option disabled>select item</option>
        <%
            for (String sz : size) {
        %>
        <option value="<%=sz%>"><%=sz%></option>
        <%
            }
        %>
    </select>
    <script> setSelectIndex('size',0); </script>
    <br>

    <br><br>
    <br><br>
    <p style="text-align: center;">
        <input type="submit" name="back" value="&longleftarrow; back">
        <input type="submit" name="add" value="Add">

        <input type="button" value="Clear All"
               onclick="setSelectIndex('vendors',0);
               setSelectIndex('size',0);
               clearElemContent('message');">
    </p>
    <br>
    <br>
    <label id="message" style="width: 100%; margin-top:10%; color:<%=message[0]%>;
            text-align: center; font-size:x-large"><%=message[1]%>
    </label>
</form>

</body>
</html>