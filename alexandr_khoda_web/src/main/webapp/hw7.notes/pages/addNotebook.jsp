<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.notes.domain.Vendor" %>
<%@ page import="sun.plugin2.gluegen.runtime.CPU" %>
<%@ page import="hw7.notes.domain.Memory" %>
<%@ page import="java.util.Date" %>
<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>
<script src="/hw7.notes/JS/select.js" type="text/javascript">    </script>

<html>
<head>
    <title>Add Notebook</title>
    <style>
        <%@include file='/hw7.notes/css/addNotebook.css' %>
    </style>
    <center><h1>Add New Notebook Type</h1></center>
</head>
<body>
<%!
    List<Vendor> vendors;
    List<CPU> cpus;
    List<Memory> memories;
%>
<%
    String serial = getAttribValue(request, "serialA");
    String vendor = getAttribValue(request, "vendorA");
    String model = getAttribValue(request, "modelA");
    String manDate = getAttribValue(request, "manDateA");
    String price = getAttribValue(request, "priceA");


    String[] message = getAttribArray(request);
    vendors = (List<Vendor>) request.getAttribute("vendors");
    cpus = (List<CPU>) request.getAttribute("cpus");
    memories = (List<Memory>) request.getAttribute("memories");

%>

<form>
    <img src="/hw7.notes/img/addLaptop1.jpg" align="left"
         style="margin-right: 20px">
    <div id="divVenSel">
        <label for="venSel">VENDOR:</label>
        <select size="1" name="venSel" id="venSel">
            <option disabled>select item</option>
            <c:forEach var="v" items="${vendor}" varStatus="cnt">
                <c:choose>
                    <c:when test="${SelInx != null}">
                        <c:if test="${cnt.index == SelInx}">
                            <option value="${v.id}" selected>${v.name}</option>
                        </c:if>
                        <c:if test="${cnt.index != SelInx}">
                            <option value="${v.id}">${v.name}</option>
                        </c:if>
                    </c:when>
                    <c:when test="${SelVal != null}">
                        <c:if test="${v.id == SelVal}">
                            <option value="${v.id}" selected>${v.name}</option>
                        </c:if>
                        <c:if test="${v.id != SelVal}">
                            <option value="${v.id}">${v.name}</option>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <option value="${v.id}">${v.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <br>
    </div>

    <label for="model">MODEL:</label>
    <input  type="text" value="${model}" placeholder="Satellite S-2535LX"
            name="model" id="model"><br>

    <c:set var="now" value="<%=new Date()%>"/>
    <fmt:formatDate var="today" pattern="dd.MM.yyyy" value="${now}"/>

    <label for="manDate">DATE OF MANUFACTURE:</label>
    <input  type="text" value="<%= manDate %>" placeholder="${today}"
            name="manDate" id="manDate"><br>

    <div id="divCpuSel">
        <label for="cpuSel">CPU:</label>
        <select size="1" name="cpuSel" id="cpuSel">
            <option disabled>select item</option>
            <c:forEach var="c" items="${cpu}" varStatus="cnt">
                <c:choose>
                    <c:when test="${SelInxC != null}">
                        <c:if test="${cnt.index == SelInxC}">
                            <option value="${c.id}"selected>${c.vendor}, ${c.freq},
                                    ${c.model}</option>
                        </c:if>
                        <c:if test="${cnt.index != SelInxC}">
                            <option value="${c.id}">${c.vendor}, ${c.freq}, ${c.model}
                            </option>
                        </c:if>
                    </c:when>
                    <c:when test="${SelValC != null}">
                        <c:if test="${c.id == SelValC}">
                            <option value="${c.id}"selected>${c.vendor}, ${c.freq},
                                    ${c.model}</option>
                        </c:if>
                        <c:if test="${c.id != SelValC}">
                            <option value="${c.id}">${c.vendor}, ${c.freq}, ${c.model}
                            </option>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.vendor}, ${c.freq}, ${c.model}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <br>
    </div>

    <div id="divMemorySel">
        <label for="memorySel">MEMORY:</label>
        <select size="1" name="memorySel" id="memorySel">
            <option disabled>select item</option>
            <c:forEach var="m" items="${memory}" varStatus="cnt">
                <c:choose>
                    <c:when test="${SelInxM != null}">
                        <c:if test="${cnt.index == SelInxM}">
                            <option value="${m.id}"selected>${m.vendor},
                            ${c.freq},
                                    ${c.model}</option>
                        </c:if>
                        <c:if test="${cnt.index != SelInxM}">
                            <option value="${c.id}">${c.vendor}, ${c.freq}, ${c.model}
                            </option>
                        </c:if>
                    </c:when>
                    <c:when test="${SelValC != null}">
                        <c:if test="${c.id == SelValC}">
                            <option value="${c.id}"selected>${c.vendor}, ${c.freq},
                                    ${c.model}</option>
                        </c:if>
                        <c:if test="${c.id != SelValC}">
                            <option value="${c.id}">${c.vendor}, ${c.freq}, ${c.model}
                            </option>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.vendor}, ${c.freq}, ${c.model}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <br>
    </div>

    <br><br>
    <br><br>
    <p style="text-align: center;">
        <input type="submit" name="back" value="&longleftarrow; back"  action="/MenuNote" method="get">
        <input type="submit" name="addNoteB" value="Add Notebook"  action="/MenuNote" method="get">
        <button name="clearAddNoteB" onclick="clearAllAddNotebook();">Clear
            All</button>
    </p>
    <br>
    <br>
    <label id="message" style="width: 100%; margin-top:10%; color:<%=message[0]%>;
            text-align: center; font-size:x-large"><%=message[1]%>
    </label>
</form>

</body>
</html>