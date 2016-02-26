<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.notes.domain.Vendor" %>
<%@ page import="sun.plugin2.gluegen.runtime.CPU" %>
<%@ page import="hw7.notes.domain.Memory" %>
<%@ page import="java.util.Date" %>
<%@ page import="hw7.notes.dao.CPUDao" %>
<%@ page import="hw7.notes.dao.VendorDao" %>
<%@ page import="hw7.notes.service.NotebookServiceImpl" %>
<%@ page import="hw7.notes.view.Menu" %>
<%@ page import="hw7.notes.dao.MemoryDao" %>
<%@ page import="hw7.notes.dao.NotebookDao" %>
<%@ page import="hw7.notes.domain.Notebook" %>
<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>
<script src="/hw7.notes/JS/select.js" type="text/javascript">    </script>

<html>
<head>
    <title>Add Store</title>
    <style>
        <%@include file='/hw7.notes/css/addNotebook.css' %>
    </style>
    <center><h1>Add Store</h1></center>
</head>
<body>
<%!
    NotebookDao notebookDao;
    List<Notebook> notebook;
%>
<%
    notebookDao = ((NotebookServiceImpl) Menu.service).getNoteDao();
    notebook = (List<Notebook>)notebookDao.findAll();
    request.setAttribute("notebook", notebook);
%>

<form action="/AddSellStore" method="get">
    <img src="/hw7.notes/img/addLaptop1.jpg" align="left"
         style="margin-right: 20px">

    <div id="divNtbSel">
        <label for="notebookSel">NOTEBOOK TYPE:</label>
        <select size="1" name="notebookSel" id="notebookSel">
            <option disabled>select item</option>
            <c:forEach var="n" items="${notebook}" varStatus="cnt">
                <c:choose>
                    <c:when test="${fn:length(SelInx) > 0}">
                        <c:if test="${cnt.index == SelInx}">
                            <option value="${n.id}" selected>${n.vendor},
                            ${n.model}, ${n.manDate}, ${n.cpu}, ${n.memory}</option>
                        </c:if>
                        <c:if test="${cnt.index != SelInx}">
                            <option value="${n.id}">${n.vendor}, ${n.model},
                            ${n.manDate}, ${n.cpu}, ${n.memory}</option>
                        </c:if>
                    </c:when>
                    <c:when test="${fn:length(SelVal) > 0}">
                        <c:if test="${v.id == SelVal}">
                            <option value="${n.id}" selected>${n.vendor},
                                    ${n.model}, ${n.manDate}, ${n.cpu}, ${n.memory}</option>
                        </c:if>
                        <c:if test="${v.id != SelVal}">
                            <option value="${n.id}">${n.vendor}, ${n.model},
                                    ${n.manDate}, ${n.cpu}, ${n.memory}</option>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <option value="${n.id}">${n.vendor}, ${n.model},
                                ${n.manDate}, ${n.cpu}, ${n.memory}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <br>
    </div>

    <label for="quantity">QUANTITY:</label>
    <input  type="text" value="${quantityA}" placeholder="1"
            name="quantity" id="quantity"><br>

    <label for="price">PRICE:</label>
    <input  type="text" value="${priceA}" placeholder="1000"
            name="price" id="price"><br>

    <br><br>
    <br><br>
    <p style="text-align: center;">
        <input type="submit" name="back2Menu" value="&longleftarrow; to Menu">
        <input type="submit" name="add" value="Add">

        <input type="button" value="Clear All"
               onclick="setSelectIndex('notebookSel', 0);
               clearElemContent('quantity');
               clearElemContent('price');
               clearElemContent('message');">
    </p>
    <br>
    <br>
    <label id="message" style="width: 100%; margin-top:10%;
            color:${messageColor}; text-align: center; font-size:x-large">${messageText}
    </label>
</form>

</body>
</html>