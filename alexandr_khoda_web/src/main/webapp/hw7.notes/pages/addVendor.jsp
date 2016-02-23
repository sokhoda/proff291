<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static hw7.notes.view.Servlet.*" %>
<%@ page import="hw7.notes.dao.VendorDao" %>
<%@ page import="hw7.notes.service.NotebookService" %>
<%@ page import="hw7.notes.domain.Vendor" %>
<%@ page import="hw7.notes.service.NotebookServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.notes.view.Menu" %>
<%--<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>--%>
<script src="/hw7.notes/JS/select.js" type="text/javascript">    </script>
<script src="/hw7.notes/JS/notebooks.js" type="text/javascript">    </script>

<html>

<%!
    VendorDao vendorDao;
    Integer mode;
    List<Vendor> vendor = null;
    String headPart;
    String venSelInx;
    String venSelVal;
%>
<%
    mode = String2Integer(getAttribValue(request, "mode"));
    headPart =  (mode == 0 ? "Add New" : "Update");
%>

<head>
    <title><%=headPart%> Vendor Type</title>
    <style>
        <%@include file='/hw7.notes/css/addNotebook.css' %>
    </style>
    <center><h1><%=headPart%> Vendor Type</h1></center><br>
</head>
<body>


<%
    vendorDao = ((NotebookServiceImpl) Menu.service).getVendorDao();

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

<form action="/AddVen" method="get">
    <img src="/hw7.notes/img/addLaptop1.jpg" align="left" style="margin-right: 20px">


    <div id="divVenSel">
        <c:if test="${mode == 1}">
            <label for="venSel">SELECT VENDOR:</label>
            <select size="1" name="venSel" id="venSel"
                    onchange="this.form.submit();">
                <option disabled>select item</option>
                <c:forEach var="v" items="${vendor}" varStatus="cnt">
                    <c:choose>
                        <c:when test="${venSelInx != null}">
                            <c:if test="${cnt.index == venSelInx}">
                                <option value="${v.id}" selected>${v.name}</option>
                            </c:if>
                            <c:if test="${cnt.index != venSelInx}">
                                <option value="${v.id}">${v.name}</option>
                            </c:if>
                        </c:when>
                        <c:when test="${venSelVal != null}">
                            <c:if test="${v.id == venSelVal}">
                                <option value="${v.id}" selected>${v.name}</option>
                            </c:if>
                            <c:if test="${v.id != venSelVal}">
                                <option value="${v.id}">${v.name}</option>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <option value="${v.id}">${v.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select><br>
        </c:if>
    </div>

    <label for="vendors">NAME:</label>
    <input  type="text" value="<%=vendorInputText%>" placeholder="TOSHIBA"
            name="name" id="vendors"><br>

    <br><br>
    <br><br>
    <p style="text-align: center;">
        <input type="submit" name="back" value="&longleftarrow; back">
        <input type="submit" name="add" value="Add" id="addBtn">
        <input type="submit" name="update" value="Update" id="updateBtn">

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

<%
    if(mode == 1){ //update
%>
<script type="text/javascript">
    setVisibility('divVenSel', 'block');
    setVisibility('updateBtn','inline');
    setVisibility('addBtn','none');
</script>
<%
}
else{
%>
<script type="text/javascript">
    setVisibility('divVenSel', 'none');
    setVisibility('updateBtn','none');
    setVisibility('addBtn','inline');
</script>
<%
    }
%>
</body>
</html>