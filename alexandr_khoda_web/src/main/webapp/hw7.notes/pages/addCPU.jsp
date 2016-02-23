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

<html>
<c:if test="${mode == null}">
    <c:set var="mode" value="0"/>
</c:if>

<head>
    <title>${mode == 0 ? 'Add New': 'Update'} CPU Type</title>
    <style>
        <%@include file='/hw7.notes/css/addNotebook.css' %>
    </style>
    <center><h1>${mode == 0 ? 'Add New': 'Update'} CPU Type</h1></center><br>
</head>
<body>
<%! CPUDao cpuDao;
    VendorDao vendorDao;
    List<CPU> cpu;
%>
<%
    cpuDao = ((NotebookServiceImpl) Menu.service).getCpuDao();
%>

<c:if test="${mode == 1}">
    <% cpu = (List<CPU>)vendorDao.findAll();
        request.setAttribute("vendor", vendor);
    %>
</c:if>

    if (mode == 1) {
        vendor = (List<Vendor>)vendorDao.findAll();
        venSelInx = (String) request.getAttribute("venSelInx");
        venSelVal = (String) request.getAttribute("venSelVal");
    }
    request.setAttribute("vendor", vendor);

    String vendorInputText = getAttribValue(request, "nameA");


<form action="/AddCpu" method="get">
    <img src="/hw7.notes/img/addLaptop1.jpg" align="left" style="margin-right: 20px">

    <div id="divCpuSel">
        <c:if test="${mode == 1}">
            <label for="cpuSel">SELECT CPU:</label>
            <select size="1" name="cpuSel" id="cpuSel"
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



    <label for="vendors">VENDOR:</label>
    <input  type="text" value="${nameA == null ? '': nameA}"
            placeholder="TOSHIBA"
            name="name" id="vendors"><br>
    <label for="freq">FREQUENCY:</label>
    <input  type="text" value="<%=vendor%>" placeholder="TOSHIBA"
            name="name" id="freq"><br>
    <label for="model">MODEL:</label>
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
    <label id="message" style="width: 100%; margin-top:10%;
            color:${messageColor == null ? 'brown' : messageColor};
            text-align: center; font-size:x-large">${messageText}
    </label>
</form>

</body>
</html>