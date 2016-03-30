<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../../../js/angular.js"></script>
<script src="../../../js/jquery-1.12.2.min.js"></script>
<script src="../../../js/registerAjax.js"></script>
<script src="../../../js/list.js"></script>

<%--<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>--%>

<html ng-app="listEntitiesJSP">
<head>
    <title>Client List</title>
    <style>
        <%@include file='../css/list.css' %>
    </style>
    <center><h1>Client List</h1></center>
    <br>
</head>
<body>

<input type="hidden" name="idVal" id="idVal" value="">

<script type="text/javascript">
    function onUpdate(id, deleteButton ) {
//            alert('butUpdate');
        if (deleteButton) {
            location.href = '/deleteClient.html?id=' + id;
        }
        else {
            location.href =
                    '/editClient.html?cid=' + id+'&portionSize='+ ${sPortion} +
                    '&cnt='+ ${cnt} +'&totPages=' + ${totPages};
        }
    }
</script>
<div style="float: left;">
    <form action="/back2Menu.html">
        <input type="submit" class="but" value="&longleftarrow; to Dash">
    </form>
</div>
<%--<a href="/back2Menu.html"><button>&longleftarrow; to Dash</button></a>--%>

<div style="float: left;">
    <c:url var="urlPrevious" value="/showPreviousClientPortion.html?">
        <c:param name="cnt" value="${cnt}"/>
        <c:param name="totPages" value="${totPages}"/>
        <c:param name="portionSize" value="${sPortion}"/>
    </c:url>

    <form action="${urlPrevious}" method="POST">
        <input type="submit" style="margin-left: 8em" class="but"
               id="previousInput" value="&longleftarrow;">
        <label class="cntMark">${cnt} of ${totPages}</label>
    </form>
</div>

<div style="float: none;">
    <c:url var="urlNext" value="/showNextClientPortion.html?">
        <c:param name="cnt" value="${cnt}"/>
        <c:param name="totPages" value="${totPages}"/>
        <c:param name="portionSize" value="${sPortion}"/>
    </c:url>
    <form action="${urlNext}" method="POST">
        <input type="submit" class="but" id="nextInput"
               value="&longrightarrow;">
        <label id="message" class="cntMark" style="color:${messageColor};
                text-align: center; width: auto">${messageText}
        </label>
    </form>
</div>
<%--<a href="<c:url value="/showNextClientPortion.html">--%>
<%--<c:param name="cntMark" value="${cnt} of ${totPages}"/>--%>
<%--<c:param name="portionSize" value="${sPortion}"/>--%>
<%--</c:url>--%>
<%--"><button>&longrightarrow;</button></a>--%>

<table>
    <thead>
    <tr>
        <%--<th class="shrink"><h3>ID</h3></th>--%>
        <th><h3>ID</h3></th>
        <th><h3>Name</h3></th>
        <th><h3>Surname</h3></th>
        <th><h3>Phone</h3></th>
        <th><h3>Address</h3></th>
        <th><h3>Last Order Date</h3></th>
        <th><h3>Order Amount</h3></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cl" items="${clientList}" varStatus="count">
        <tr>
            <td class="shrink">${cl.id}</td>
            <td align="left">${cl.name}</td>
            <td align="left">${cl.surname}</td>
            <td align="left">${cl.phone}</td>
            <td align="left">${cl.address}</td>
            <td align="left">
                <fmt:formatDate value="${cl.lastOrderDate}"
                                pattern="dd.MM.yyyy"/>
            </td>
            <td align="left">${cl.orderAmount}</td>
            <td>
                <button id="butUpdate" onclick="onUpdate(${cl.id}, 0 )">Update
                </button>
            </td>
            <td>
                <button id="butDelete" onclick="onUpdate(${cl.id}, 1)">Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%--<c:if test="${cnt == totPages}">--%>
<%--<script type="text/javascript">--%>
<%--$("#nextInput").disabled = true;--%>
<%--</script>--%>
<%--</c:if>--%>
<script type="text/javascript">
    disableButtons(${cnt}, ${totPages});
</script>
</body>
</html>
