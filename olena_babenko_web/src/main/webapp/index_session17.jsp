<%--
  Created by IntelliJ IDEA.
  User: lenchi
  Date: 05.02.16
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>olena_babenko</title>
    <%--for Bootstrap BEGIN--%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <%--for Bootstrap END--%>
</head>
<body>
<div class="container">
    <p><br/></p>
    <div class="row">
        <div class="col-md-3">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="page-header">
                        <h3>Login Page</h3>
                    </div>
                    <form action="/login_page" method="post">
                        <div class="form-group">
                            <input type="text" name="Login" placeholder="username" autofocus required autocomplete="off"/>
                        </div>
                        <div class="form-group">
                            <input type="text" name="Password" placeholder="password" required autocomplete="off"/>
                        </div>
                        <hr/>
                        <div class="form-group">
                            <input type="submit" value="Login" class="btn btn-default"/>
                            <input type="reset" value="Reset" class="btn btn-default"/>
                        </div>
                        <div class="form-group">
                            <p><a href="regform_w_db.jsp">Registration</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-8"></div>
    </div>
</div>
</body>
</html>