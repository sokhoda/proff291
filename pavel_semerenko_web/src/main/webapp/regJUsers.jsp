<%@ page import="java.util.ArrayList" %>
<%@ page import="hw_jdbc.Users_DAO" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 31.01.2016
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Users</title>
    </head>
    <script>
        function addRowToUserTable(fname, lname, pass){
            var table = document.getElementById('table_users');
            var row = document.createElement('tr');
            table.appendChild(row);

            var coll_fname = document.createElement('td');
            coll_fname.innerHTML = fname;
            row.appendChild(coll_fname);

            var coll_lname = document.createElement('td');
            coll_lname.innerHTML = lname;
            row.appendChild(coll_lname);

            var coll_pass = document.createElement('td');
            coll_pass.innerHTML = pass;
            row.appendChild(coll_pass);
        }
    </script>
    <body>
        <form action="/regJForm" method="post">
            FIRST NAME: <input type="text" name="first_name"> <br />
            LAST NAME:  <input type="text" name="last_name"> <br />
            PASSWORD:   <input type="password" name="password"> <br />

            <input type="submit" value="create user" name="submit"> <br />
            <br />
        </form>
        <table id="table_users"></table>
        <script>
            <%
                ArrayList<Users_DAO> users_dao = (ArrayList<Users_DAO>) request.getAttribute("users");
                if(users_dao != null) {
                    for (Users_DAO user : users_dao){
            %>
                        addRowToUserTable('<%=user.getFirst_name() %>', '<%=user.getLast_name() %>', '<%=user.getPass() %>');

            <%
                    }
                }
            %>
        </script>

    </body>
</html>
