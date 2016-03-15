<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="home"><button>На главную</button></a><br/>
<table border="1" cellpadding="5"  style="border-collapse: collapse; border: 1px solid black;">
    <thead>
    <tr>
        <th>ID</th>
        <th>ИМЯ</th>
        <th>ФАМИЛИЯ</th>
        <th>АДРЕС</th>
        <th>НОМЕР ТЕЛЕФОНА</th>
        <th>СУММА</th>
        <th>ДАТА ПОСЛЕДНЕГО ЗАКАЗА</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${client}" var="cl">
        <tr>
            <td>${cl.id}</td>
            <td>${cl.name}</td>
            <td>${cl.surName}</td>
            <td>${cl.phone}</td>
            <td>${cl.address}</td>
            <td>${cl.sum}</td>
            <td>${cl.lastOrder}</td>

        </tr>
    </c:forEach>
    </tbody>

</table>
<%--<form action="portionNext" method="get">--%>
    <%--<button>Next</button>--%>
<%--</form>--%>
<c:if test="${port!=null}">
<a href="portionPrev" ><button >Prev</button></a>
<a href="portionNext" ><button >Next</button></a>
</c:if>
</body>
</html>
