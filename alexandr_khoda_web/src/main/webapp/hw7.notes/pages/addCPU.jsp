<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static hw7.notes.view.Servlet.*" %>
<%@ page import="hw7.notes.domain.CPU" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.notes.dao.CPUDao" %>
<%@ page import="hw7.notes.view.Menu" %>
<%@ page import="hw7.notes.service.NotebookServiceImpl" %>
<%@ page import="hw7.notes.domain.Vendor" %>
<%@ page import="hw7.notes.dao.VendorDao" %>
<%--<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>--%>
<script src="/hw7.notes/JS/select.js" type="text/javascript">    </script>
<script src="/hw7.notes/JS/notebooks.js" type="text/javascript">    </script>

<%! CPUDao cpuDao;
    VendorDao vendorDao;
    Integer mode;
    List<CPU> cpu;
    String headPart;
    String venSelInx;
    String venSelVal;
%>
<html>
<%--<%--%>
    <%--mode = String2Integer(getAttribValue(request, "mode"));--%>
<%--%>--%>
<c:if test="${mode == null}">
    <c:set var="mode" value="0"/>
</c:if>
<c:set var="headPart" value="${mode == 0 ? 'Add New': 'Update'}"/>

<head>
    <title>${headPart} CPU Type</title>
    <style>
        <%@include file='/hw7.notes/css/addNotebook.css' %>
    </style>
    <center><h1>${headPart} CPU Type</h1></center><br>
</head>
<body>
<body>
<%
    cpuDao = ((NotebookServiceImpl) Menu.service).getCpuDao();

    if (mode == 1) {
        vendor = (List<Vendor>)vendorDao.findAll();
        venSelInx = (String) request.getAttribute("venSelInx");
        venSelVal = (String) request.getAttribute("venSelVal");
    }
    request.setAttribute("vendor", vendor);

    String vendorInputText = getAttribValue(request, "nameA");
    String[] message = getAttribArray(request);
//        message[0] = "brown";
//        message[1] = "";
%>

<form action="/AddCpu" method="get">
    <img src="/hw7.notes/img/addLaptop1.jpg" align="left" style="margin-right: 20px">
    <label for="vendors">VENDOR:</label>
    <input  type="text" value="<%=vendor%>" placeholder="TOSHIBA"
            name="name" id="vendors"><br>
    <label for="freq">VENDOR:</label>
    <input  type="text" value="<%=vendor%>" placeholder="TOSHIBA"
            name="name" id="freq"><br>
    <label for="model">VENDOR:</label>
    <input  type="text" value="<%=vendor%>" placeholder="TOSHIBA"
            name="name" id="model"><br>
    <br><br>
    <br><br>
    <p style="text-align: center;">
        <input type="submit" name="back" value="&longleftarrow; back">
        <input type="submit" name="add" value="Add">

        <input type="button" value="Clear All"
               onclick="clearElemContent('vendors');
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