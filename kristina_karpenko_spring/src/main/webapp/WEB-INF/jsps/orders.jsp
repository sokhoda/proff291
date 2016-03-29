<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="home"><button>На главную</button></a><br/>
<table  border="1" cellpadding="5"  style="border-collapse: collapse; border: 1px solid black;">
    <thead>
    <tr>
        <th>ID</th>
        <th>ИМЯ</th>
        <th>ФАМИЛИЯ</th>
        <th>НОМЕР ТЕЛЕФОНА</th>
        <th>АДРЕС ПОДАЧИ</th>
        <th>НАДРЕС НАЗНАЧЕНИЯ</th>
        <th>СУММА ЗАКАЗА</th>
        <th>ДАТА ЗАКАЗА</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.client.name}</td>
            <td>${order.client.surName}</td>
            <td>${order.client.phone}</td>
            <td>${order.addressFrom}</td>
            <td>${order.addressTo}</td>
            <td>${order.amount}</td>
            <td>${order.date}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<c:if test="${port!=null}">
    <a href="showPortionOrderPrev" ><button >Prev</button></a>
    <a href="showPortionOrderNext" ><button >Next</button></a>
</c:if>
</body>
</html>
