
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<if test=" ${message}=='Registration succesfull' ">--%>
    <%--<h1 style="color: chartreuse">Регистрация прошла успешно!</h1>--%>
<%--</if>--%>
<%--<elseif test=" ${message}=='Registration is not succesfull. Try Again' ">--%>
    <%--<h1 style="color: red ">Вы не зарегестрированы. Повторите попытку</h1>--%>
<%--</elseif>--%>
<h1 style="color: chartreuse ">${message}</h1>
<h1 style="color: red ">${error}</h1>
<h1 style="color: chartreuse ">${order}</h1>
<a href="registerClient">Регестрировать клиента</a><br/>
${ClientMessage}<br/><br/>
<a href="orderCreate">Создать заказ</a><br/>

<form action="portion0" method="GET">
    Порция:<input type="number" name="portSize"><br/>
    <button>Вывести всех клиетов</button>
    </form><br/>

Вывести всех клиетов, наездивших а сумму:<br/>

<form action="showClientSum" method="GET">
    Сумма:<input type="text" name="sum"><br/>
    <button>Вывести</button>
</form>
<a href="showClientMonth">Вывести всех клиетов, делавших заказы последний месяц</a><br/>

<form action="showOrdersSum" method="GET">
    Сумма MIN:<input type="text" name="min"><br/>
    Сумма MAX:<input type="text" name="max"><br/>
    <button>Вывести</button>
</form>

<br/><br/>

<form action="showPortionOrder0" method="GET">
    Порция:<input type="number" name="portSize"><br/>
    <button>Показать все заказы</button>
</form><br/>

</body>
</html>
