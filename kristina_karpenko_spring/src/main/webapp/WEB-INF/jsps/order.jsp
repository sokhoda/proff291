<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 14.03.2016
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Заказ:
${order}
<form  method="post">
    Номер телефона:<input name="phone" value="${phone}"><br/>
    Адрес подачи:<input  name="addressFrom" value="${addressFrom}"><br/>
    Адрес назначения:<input  name="addressTo" value=${addressTo}><br/>
    Сумма:<input  name="sum" value="${sum}"><br/>
    ID:<input  name="id" value="${id}"><br/>
    <%--<c:if  test=" id != null">--%>
        <%--<button>Редактировать заказ</button>--%>
        <%--</c:if>--%>
    <a href="orderEdit"><button>Редактировать заказ</button></a>
    <%--<a href="orderCreate"><button>Cоздать заказ</button></a>--%>

</form>
</body>
</html>
