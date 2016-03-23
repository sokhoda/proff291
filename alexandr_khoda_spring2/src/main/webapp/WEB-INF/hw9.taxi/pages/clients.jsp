<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../../../js/registerAjax.js"></script>
<%--<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>--%>

<html ng-app="listEntitiesJSP">
<head>
    <title>Client List</title>
    <style>
        <%@include file='../css/list.css' %>
    </style>
    <center><h1>Client List</h1></center><br>
</head>
<body>

<%--String vendorInputText = getAttribValue(request, "nameA");--%>

<script type="text/javascript">
    function onUpdate(id){
        var hid = document.getElementById('idVal');
        hid.value = (id == null ? 0 : id);
        this.form.submit();
    }
</script>

    <div style="display: inline-block">
<form action="/back2Menu.html" method="get">
        <input type="submit" name="back2Menu" value="&longleftarrow; to Menu">
</form>
<form action="/back2Menu.html" method="get">
        <input type="submit" name="back" id="back" style="margin-left: 8em"
               value="&longleftarrow;">
</form>
<form action="/back2Menu.html" method="get">
        <label class="cntMark">{{cnt}} of {{totPages}}</label>
        <input type="submit" name="forward" id="forward" class="but"
               value="&longrightarrow;">
</form>

        <label id="message" class="cntMark"
               style="color:${messageColor};
                       text-align: center; width: auto" >${messageText}
        </label>

        <input type="hidden" name="cntMark" value="${cnt} of ${totPages}">
        <input type="hidden" name="sPortion" value="${sPortion}">
        <input type="hidden" name="idVal" id="idVal" value="">
    </div>


    <table>
        <thead>
        <tr>
            <%--<th class="shrink"><h3>ID</h3></th>--%>
            <th><h3>ID</h3></th>
            <th><h3>Vendor</h3></th>
            <th><h3>Model</h3></th>
            <th><h3>Date of Manuf.</h3></th>
            <th><h3>CPU</h3></th>
            <th><h3>Memory</h3></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="n" items="${notebookPortion}" varStatus="count">

            <tr>
                <td class="shrink">${n.id}</td>
                <td align="left">${n.vendor}</td>
                <td align="left">${n.model}</td>
                <td align="left">
                    <fmt:formatDate value="${n.manDate}" pattern="dd.MM.yyyy" />
                </td>
                <td align="left">${n.cpu}</td>
                <td align="left">${n.memory}</td>
                <td><button id="butUpdate" name="updNotebook2"
                            onclick="onUpdate(${n.id})">Update</button>
                </td>
                <td><button id="butDelete" name="delNotebook"
                            onclick="onUpdate(${n.id})">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${cnt == totPages}">
        <script type="text/javascript">
            document.getElementById("forward").disabled = true;
        </script>
    </c:if>
    <c:if test="${cnt == 1}">
        <script type="text/javascript">
            document.getElementById("back").disabled = true;
        </script>
    </c:if>
</form>

</body>
</html>
