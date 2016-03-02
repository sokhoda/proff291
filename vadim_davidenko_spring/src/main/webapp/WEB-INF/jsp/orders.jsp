<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 28.02.2016
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp"%>

<table align="center" cellpadding="3">
    <tr><td align="center"><b>ORDERS LIST</b></td></tr>
    <tr><td>
        <table border="1" cellpadding="3">
            <tr style="background-color: #d4ecff">
                <th align="center" width="40px">Id</th>
                <th align="center" width="200px">Client</th>
                <th align="center" width="100px">Order date</th>
                <th align="center" width="120px">Amount</th>
                <th align="center" width="200px">From</th>
                <th align="center" width="200px">To</th>
            </tr>
            <c:forEach var="o" items="${orderList}">
                <tr>
                    <td align="center">${o.id}</td>
                    <td align="center">${o.Client.name} + " " + ${o.Client.surname}</td>
                    <td align="center">${o.orderDate}</td>
                    <td align="center">${o.amount}</td>
                    <td align="center">${o.addressFrom}</td>
                    <td align="center">${o.addressTo}</td>
                </tr>
            </c:forEach>
        </table>
    </td></tr>

    <tr style="background-color: #d4ecff">
        <td>
            <input type="button" value="Prev" onclick="document.location='/reportByPortion/-1'" style="width: 80px"/>
            &nbsp;&nbsp;&nbsp;
            <input type="button" value="Next" onclick="document.location='/reportByPortion/1'" style="width: 80px"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/dashboard"><input type="button" value="Back" style="width: 80px"/></a>
        </td>
    </tr>
</table>

<%@include file="footer.jsp"%>
