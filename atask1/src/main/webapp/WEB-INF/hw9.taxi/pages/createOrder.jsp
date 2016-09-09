<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: s_okhoda
  Date: 20.01.2016
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../../../js/angular.js"></script>
<script src="../../../js/registerAjax.js"></script>

<link rel="stylesheet"
      href="../../../bo bower_components/bootstrap/dist/css/bootstrap.min.css">
<script
        src="js/bower_components/jquery/dist/jquery.min.js"></script>
<script
        src="js/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<html ng-app="regJSP">
<html>
    <head>
        <title>Order Registration Form</title>
        <style>
            <%@include file='../css/addNotebook.css' %>
        </style>
    </head>

    <body>
    <form>
        <img <%--height="100px" width="100px" --%>
                src="../../img/newUser.jpg" align="left"
                style="margin-right: 20px">
        <label for="name">DATE: </label>
        <input  type="text" name="name" id="name" ng-model="date"><br>

        <label for="surname">CLIENT:</label>
        <select size="1" class="form-control input-lg selectpicker sm" id="country" name="country"
                onchange="onCountryChange(event,'OnCountryChange')">
            <option disabled>select item</option>
            <c:forEach var="cntr" items="${countries}" varStatus="cnt">
                <option value="${cntr.cntrId}"
                        <c:if test="${cntr.cntrId == cntrId}">selected</c:if>
                >${cntr.cntrName}</option>
            </c:forEach>
        </select>

        <%--Client info--%>
        <label for="name">NAME: </label>
        <input  type="text" name="name" id="name" ng-model="name"><br>

        <label for="surname">SURNAME:</label>
        <input  type="text" name="surname" id="surname" ng-model="surname"><br>

        <label for="phone">PHONE:</label>
        <input  type="text" name="phone" id="phone" ng-model="phone"><br>

        <label for="address">ADDRESS:</label>
        <input  type="text" name="address" id="address" ng-model="address"><br>



        <label for="phone">SUM:</label>
        <input  type="text" name="phone" id="phone" ng-model="phone"><br>

        <label for="address">ADDRESS:</label>
        <input  type="text" name="address" id="address" ng-model="address"><br>
        <br>
        <div ng-controller="regOrderCtrl">
            <input type="submit" value="&longleftarrow; to Dash"
                   ng-click="back2dashboard();">

            <input type="submit"  value="Create"
                   ng-click="doRegisterOrder()">

            <br><br>
            <label id="message"
                   ng-style="{'width': '100%', 'margin-top': '10%',
            'color': message.mcolor, 'text-align' : 'center', 'font-size' : 'x-large'}">
                {{message.mtext}}
            </label>

        </div>
        <footer style="text-align: center">&copy;<spring:eval expression="@propertyConfigurer.getProperty('AllRights')"/></footer>
    </form>
    </body>
</html>
