<%--
  Created by IntelliJ IDEA.
  User: Павло
  Date: 22.01.2016
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Этот JSP комментарий не появится в сгенерированном html --%>

<%-- Это JSP директива: --%>

<%@ page import="java.util.Date" %>

<%-- Эта декларации: --%>

<%!
    long loadTime = System.currentTimeMillis();
    Date loadDate = new Date();
    int hitCount = 0;
%>

<html>
<body>

<%--
Следующие несколько строк являются результатом
JSP выражений, вставленных в сгенерированный html;
знак '=' указывает на JSP выражение
--%>

<H1>Эта страница была загружена <%= loadDate %>
</H1>
<H1>Hello, world! It's <%= new Date() %>
</H1>
<H2>Here's an object: <%= new Object() %>
</H2>
<H2>This page has been up <%= (System.currentTimeMillis() - loadTime) / 1000 %> seconds</H2>
<H3>Page has been accessed <%= ++hitCount %> times since <%= loadDate %>
</H3>

<%--
"Скриплет", которые пишет на консоли сервера
и на странице клиента.
Обратите, что необходимо ставить ';':
out.println("Cheerio");
--%>

<%
    System.out.println("Goodbye");

%>
</body>
</html>
