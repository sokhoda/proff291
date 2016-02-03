<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<html>
<head>
  <title>Taxi</title>
</head>
<body>
<form action="/ClientServlet" method="post">
  <input type="text" name="name"/>
  <input type="submit" value="POST"/>
  <br/>
  <input type="text" name="surname"/>
  <br/>
  <input type="text" name="phone"/>
  <br/>
  <input type="text" name="address"/>

</form>

<%!
  public void globalMethod(){

  }
  static int i = 0;

%>

<%
  i++;
  Date date = new Date();
  out.println(date);
  out.println(i);
%>

<%=
"DATA" + date
%>
<h1>Hello proff29!!!</h1>
<p>Para</p>
<a href="http://www.google.com.ua">Link</a>
<br/>
<script src="js/Phone.js" type="text/javascript">

</script>
<br/>
<q>qoatation</q>

<ol start="5" type="A">
  <li>item</li>
  <li>item</li>
  <li>item</li>
</ol>

<ul>
  <li>item 1</li>
  <li>item 2</li>
  <li>item 3</li>
</ul>

<table border="1">
  <thead>
  <tr>
    <th>First</th>
    <th colspan="2">Last</th>
    <%--<th>Age</th>--%>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>Alex</td>
    <td>Bonasevich</td>
    <td>35</td>
  </tr>

  </tbody>

  <tfoot></tfoot>
</table>
</body>
</html>
