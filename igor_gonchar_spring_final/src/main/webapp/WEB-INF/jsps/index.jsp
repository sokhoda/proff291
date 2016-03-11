<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="Taxi Service">
    <meta name="author" content="Igor Gonchar">
    <link rel="icon" href="images/favicon.png">

    <title>Taxi Login</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

<style>
    div p {
        color: dodgerblue;
        font-size: 14pt;
    }

    .container {
        width: 350px;
    }
</style>

</head>

<body>

<div class="container">

    <form id="loginForm" class="form-signin" action="/loginConfirm" method="post" novalidate>
        <h2 class="form-signin-heading" id="loginHeader" align="center">Please sign in</h2>
        <label for="inputLogin" class="sr-only">Email address</label>
        <input type="text" id="inputLogin" class="form-control" name="login" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
       <%-- <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>--%>
        <button id="signInButton" onclick="loginFormValidation()" class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      <%--  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <button onclick="validateUserEmail()">Validate email</button>--%>
    </form>
    <br/>
    <div class="register">
        <a href="/registerPage">
            <button class="btn btn-lg btn-primary btn-block" type="button">Register Now</button>
        </a>
    </div>
</div> <!-- /container -->
<br>
<div>
    <p align="center">
        ${reg_result}
        ${login_result}
    </p>
</div>


<script src="js/indexController.js"></script>

</body>
</html>