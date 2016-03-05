<%@ page import="hw7.notes.service.NotebookService" %>
<%@ page import="hw7.notes.service.NotebookServiceImpl" %>
<%@ page import="hw7.notes.util.HibernateUtil" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="hw7.notes.dao.NotebookDao" %>
<%@ page import="hw7.notes.dao.NotebookDaoImpl" %>

<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.02.2016
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! int n = 1;
    %>
<%!  SessionFactory factory = HibernateUtil.getSessionFactory();
    NotebookDao notebookDao = new NotebookDaoImpl(factory);
    NotebookService notebookService = new NotebookServiceImpl(notebookDao);%>

<input type="submit" name="prev" value="Prev" >
<input type="submit" name="next" value="Next" >
${size}

</body>
</html>
