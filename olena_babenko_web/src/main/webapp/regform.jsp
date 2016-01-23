<%--
  Created by IntelliJ IDEA.
  User: lenchi
  Date: 22.01.16
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
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
                        <h3>Registration form</h3>
                    </div>
                    <form action="/registration" method="post">
                        <div class="form-group">
                            <input type="text" name="UserLogin" placeholder="username" required
                                   autofocus autocomplete="off"/>
                        </div>
                        <div class="form-group">
                            <input type="text" name="UserPass" placeholder="password" required autocomplete="off"/>
                        </div>
                        <hr/>
                        <input type="submit" name="Register" value="Finish" class="btn btn-default"/>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-8"></div>
    </div>
</div>

<%--for Bootstrap BEGIN--%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<%--for Bootstrap END--%>
</body>
</html>
