<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<script src="js/registerForm.js" type="text/javascript"></script>

<table border="1">

    <tbody>
    <tr>
        <td colspan="2" align="center"><b>Register Form:</b></td>
        <td rowspan="8"><img src="http://blog.englishexamswithnikki.org/wp-content/uploads/2013/01/I-can-do.jpg"
                             width="350"/></td>
    </tr>
    <form action="/registerForm" method="post">
        <tr>
            <td> Enter Login</td>
            <td><input type="text" name="login"/></td>
            <%--<td rowspan="7"><img src="http://blog.englishexamswithnikki.org/wp-content/uploads/2013/01/I-can-do.jpg"
                                 width="350"/></td>--%>
        </tr>
        <tr>

            <td>Enter Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>Re-enter Password</td>
            <td><input type="password" name="rePassword"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Register" style="width:100%"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="reset" value="Clear" style="width:100%"/></td>
        </tr>
    </form>
    <tr>
        <td colspan="2"><a href="index1.jsp">
            <button style="width:100%">Back Home</button>
        </a></td>
    </tr>
    </form>
    </tbody>
</table>

<p>
    ${reg_result}
</p>
<ol>
    <b>Password requirements:</b>
    <li> Start from upercase;</li>
    <li> All other letters - lower case;</li>
    <li> End with number.</li>
</ol>
</body>
</html>