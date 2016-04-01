<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script src="../../../js/angular.js"></script>--%>
<script src="../../../js/jquery-1.12.2.min.js"></script>

<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
        src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-aria.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.min.js"></script>

<!-- Angular Material Library -->
<script src="http://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>
<script src="../../../js/list.js"></script>
<script src="../../../js/registerAjax.js"></script>

<%--<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>--%>

<html ng-app="listEntitiesJSP" ng-cloak style="margin-left: 1em">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css">
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
    function onUpdate(id, deleteButton) {
//            alert('butUpdate');
        if (deleteButton) {
            location.href = '/deleteClient.html?id=' + id;
        }
        else {
            location.href =
                    '/editClient.html?cid=' + id + '&portionSize=' + ${sPortion} +
                            '&cnt=' + ${cnt} +'&totPages=' + ${totPages};
        }
    }
</script>

<div style="float: left;">
    <form action="/back2Menu.html">
        <input type="submit" class="but" value="&longleftarrow; to Dash">
    </form>
</div>
<%--<a href="/back2Menu.html"><button>&longleftarrow; to Dash</button></a>--%>

<div ng-controller="listEntitiesCtrl"
     ng-init='init(${sPortion}, ${totPages}, ${cnt})'>
    <div style="display: inline-block;">
        <button style="margin-left:8em" class="but"
                ng-style="{'visibility': hidePrevious()};"
                ng-click="doPreviousPortion()">&longleftarrow;
        </button>

        <label class="cntMark">{{cnt}} of {{totPages}}</label>

        <button class="but" ng-style="{'visibility': hideNext()};"
                ng-click="doNextPortion()">&longrightarrow;
        </button>
        <label id="message" ng-style="{'width': '100%', 'margin-top': '10%',
            'color': message.mcolor, 'text-align' : 'center', 'font-size' : 'x-large'}">
            {{message.mtext}}
        </label>
    </div>

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

        <%--<c:forEach var="cl" items="${clientList}" varStatus="count">--%>
        <tr ng-repeat="cl in clientList">
            <td class="shrink">{{cl.id}}</td>
            <td align="left">{{cl.name}}</td>
            <td align="left">{{cl.surname}}</td>
            <td align="left">{{cl.phone}}</td>
            <td align="left">{{cl.address}}</td>
            <td align="left">{{cl.lastOrderDate == null ? 'N/A' : cl.lastOrderDate}}</td>
            <td align="left">{{cl.orderAmount}}</td>
            <td>
                <button ng-id="{{cl.id}}" ng-click="doUpdateClient($event)">Update</button>
            </td>
            <td>
                <button ng-id="{{cl.id}}" ng-click="doDeleteClient($event)">Delete</button>
            </td>
        </tr>
        <%--</c:forEach>--%>
</div>
</tbody>
</table>
<form>
    <footer style="text-align: center">&copy;<spring:eval
            expression="@propertyConfigurer.getProperty('AllRights')"/></footer>
</form>
</body>
</html>
