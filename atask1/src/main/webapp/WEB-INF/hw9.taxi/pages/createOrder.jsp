<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: s_okhoda
  Date: 20.01.2016
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/node_modules/angular/angular.js"></script>
<script src="../../../js/registerOrderAjax.js"></script>

<link rel="stylesheet"
      href="/node_modules/bootstrap/dist/css/bootstrap.min.css">
<script src="/node_modules/jquery/dist/jquery.min.js"></script>
<script src="/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>

<html ng-app="regOrderJSP">
<html>
<head>
    <title>Order Registration Form</title>
    <style>
        <%@include file='../css/addNotebook.css' %>
        <%@include file='../css/createOrder.css' %>
    </style>
</head>

<body>
<form>
    <img <%--height="100px" width="100px" --%>
            src="../../img/newUser.jpg" align="left"
            style="margin-right: 20px">
    <table border="2">
        <col align="left">
        <col align="left">
        <col align="right">
        <tr>
            <th style=" text-align: center" colspan="2">
                Order Info
            </th >
        </tr>
        <tr>
            <td style="text-align: left">
                <label for="date">DATE: </label>
                <input type="text" name="date" ng-model="date"><br>
            </td>
        </tr>
        <tr>
            <td>
                <label for="surname">CLIENT:</label>
                <select size="1" id="client" name="client"
                        onchange="onClientChange(event,'onClientChange')">
                    <option disabled>select item</option>
                    <c:forEach var="cntr" items="${countries}" varStatus="cnt">
                        <option value="${cntr.cntrId}"
                                <c:if test="${cntr.cntrId == cntrId}">selected</c:if>
                        >${cntr.cntrName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <%--Client info--%>
        <tr>
            <td></td>
            <td>
                <label for="name">NAME:</label>
                <input type="text" name="name" readonly ng-model="name"><br>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <label for="surname">SURNAME:</label>
                <input type="text" name="surname" readonly
                       ng-model="surname"><br>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <label for="phone">PHONE:</label>
                <input type="text" name="phone" readonly ng-model="phone"><br>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <label for="address">ADDRESS:</label>
                <input type="text" name="address" readonly
                       ng-model="address"><br>
            </td>
        </tr>
        <tr>
            <td>
                <label for="sum">SUM:</label>
                <input type="text" name="sum" ng-model="sum"><br>
            </td>
        </tr>
        <tr>
            <td>
                <label for="startaddress">START ADDRESS:</label>
                <input type="text" name="startaddress" ng-model="startaddress"><br>
            </td>
        </tr>
        <tr>
            <td>
                <label for="endaddress">END ADDRESS:</label>
                <input type="text" name="endaddress" ng-model="endaddress"><br>
            </td>
        </tr>
        <br>
    </table>
    <div ng-controller="regOrderCtrl">
        <input type="submit" value="&longleftarrow; to Dash"
               ng-click="back2dashboard();">

        <input type="submit" value="Create"
               ng-click="doRegisterOrder()">

        <br><br>
        <label id="message"
               ng-style="{'width': '100%', 'margin-top': '10%',
            'color': message.mcolor, 'text-align' : 'center', 'font-size' : 'x-large'}">
            {{message.mtext}}
        </label>

    </div>
    <footer style="text-align: center">&copy;<spring:eval
            expression="@propertyConfigurer.getProperty('AllRights')"/></footer>
</form>
</body>
</html>
