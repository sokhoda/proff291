<%--
  Created by IntelliJ IDEA.
  User: Павло
  Date: 22.01.2016
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Просмотр атрибутов pageContext--%>

<%-- Обратите внимание, что вы можете включить любое количество кода

внутри тэгов скриплета --%>

<%@ page import="java.util.Enumeration" %>

<html>
<body>

Servlet Name: <%= config.getServletName() %><br>

Servlet container supports servlet version:

<%
    out.print(application.getMajorVersion() + "."
            + application.getMinorVersion()); %>
<br>
<%
    session.setAttribute("My dog", "Ralph");
    for (int scope = 1; scope <= 4; scope++) {
%>
<H3>Scope: <%= scope %>
</H3>

<% Enumeration e = pageContext.getAttributeNamesInScope(scope);
    while (e.hasMoreElements()) {
        out.println("\t<li>" + e.nextElement() + "</li>");
    }
}
%>

</body>
</html>