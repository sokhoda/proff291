<%@ page import="hw_RegAuth_DB.UserProcessingMethods" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: lenchi
  Date: 06.02.16
  Time: 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <h3>You have logged on. See below all users in db.</h3><br/><hr/><br/>
        <%!
            public static StringBuilder getUsersTable() {
                UserProcessingMethods userProcessingMethods = new UserProcessingMethods();
                StringBuilder tableString = new StringBuilder();
                tableString.append("<table class=\"table table-hover\"><tr><td align=\"center\">ID</td><td align=\"center\">USER NAME</td><td align=\"center\">USER PASS</td><tr>");
                Connection conn = null;
                try {
                    conn = userProcessingMethods.getConnect();
                    Statement stat = conn.createStatement();
                    ResultSet rs = stat.executeQuery("SELECT * FROM users");

                    while (rs.next()) {
                        tableString.append("<tr><td align=\"center\">" + rs.getString("ID") + "</td><td align=\"center\">" + rs.getString("USER_NAME") + "</td><td align=\"center\">" + rs.getString("USER_PASS") + "</td></tr>");
                    }
                    tableString.append("</table>");
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    userProcessingMethods.closeConnection(conn);
                }
                return tableString;
            }
        %>

        <%=getUsersTable()%>
    </div>
</div>

</body>
</html>
