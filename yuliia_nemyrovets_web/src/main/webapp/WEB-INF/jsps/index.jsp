<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 28.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<style>
    .center{
        top:60%;
        left:40%;
        width:50%;
        height: 50%;
        position:absolute;
        margin-top: -225px;
        margin-left: -225px;
    }
    .block {
        width: 300px;
        height: 200px;
        background: white;
        border: 3px solid;
        box-shadow: 0 2px 0 rgba(255,255,255,0.8);
       /* box-shadow: aliceblue;*/
        border-radius: 10px;
        margin: auto;
    }

    .main {
        width: 200px;
        height: 10px;
        background: white;
        border: 1px darkgray solid;
        border-radius: 5px;
        padding: 15px;
        margin: auto;
    }

    .rov {
        width: 80px;
        height: 30px;
        background: darkblue;
        border: 1px solid;
        border-radius: 5px;
        margin: auto;
        color: white;
    }
    body {
        margin: 0; /* Убираем отступы */
        height: 100%; /* Высота страницы */
        background: url("img/cvety-butony-listya.jpg"); /* Параметры фона */
        background-size: cover; /* Фон занимает всю доступную площадь */
    }

</style>
<head>
    <meta charset="utf-8"/>
    <title>Round</title>

</head>
<body >
<div class="center">
<div class="block" align="center">
    <table>
        <tr align="left">
            <th3>Authorization</th3>
        </tr>
        <tr>
            <th></th>
        </tr>
        <tr>
            <td><input type="text" name="login" class="main" value="Login" style="color:#777" onfocus="if (this.value=='Login')
        {this.value=''; this.style.color=='#000';}"
                       onblur="if(this.value==''){ this.value='Login'; this.style.color='#777';}"/></td>
        </tr>
        <tr>
            <td><input type="text" name="password" class="main"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Sign in" class="rov" align="center"/>
            </td>
        </tr>
    </table>

</div></div>
</body>
</html>

