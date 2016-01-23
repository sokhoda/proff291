<%--
  Created by IntelliJ IDEA.
  User: danilov
  Date: 1/21/16
  Time: 01:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
    <table border="0" align="center" width="100%">
        <tr valign="MIDDLE">
            <th width="33.33%" align="CENTER">
                <h2>IN GOD</h2>
            </th>
            <th width="33.33%" align="CENTER">
                <h2>WE</h2>
            </th>
            <th width="33.33%" align="CENTER">
                <h2>TRUST</h2>
            </th>
        </tr>
        <tr>
            <td colspan="3" align="CENTER">
                <a href="http://citrus.ua"><img src="http://cdn1.citrus.ua/upload/iblock/188/harman-kardon-esquire-mini-728x250.jpg" width="50%"></a>
            </td>
        </tr>
    </table>
    <table border="0" align="CENTER" width="100%">
        <tr>
            <td width="16.66%" align="CENTER"><a href="login.jsp"><h4>Login</h4></a></td>
            <td WIDTH="16.66%" ALIGN="CENTER"><a href="registration.jsp"><h4>Registration</h4></a></td>
            <td width="16.66%" align="CENTER"><h4>News</h4></td>
            <td width="16.66%" align="CENTER"><h4>Contacts</h4></td>
            <td WIDTH="16.66%" align="center"><h4>Support</h4></td>
        </tr>
    </table>
    <table border="1" cellpadding="7" width="100%" align="center">
        <tfoot align="center">
        <tr>
            <td> &copy;2016</td>
        </tr>
        </tfoot>
        <tbody>
        <tr>
            <td align="center" valign="top">
                <h3>Registration</h3>
                <br>
                <form action="/registration" method="post">
                    <table border="0" width="30%" align="center">
                        <tr>
                            <td width="50%">Login:</td>
                            <td width="50%"><input type="text" name="login" /></td>
                        </tr>
                        <tr>
                            <td width="50%">Name:</td>
                            <td width="50%"><input type="text" name="name" /></td>
                        </tr>
                        <tr>
                            <td width="50%">Surname:</td>
                            <td width="50%"><input type="text" name="surname" /></td>
                        </tr>
                        <tr>
                            <td width="50%">Phone:</td>
                            <td width="50%"><input type="tel" name="phone" /></td>
                        </tr>
                        <tr>
                            <td width="50%">Password:</td>
                            <td width="50%"><input type="password" name="password" /></td>
                        </tr>
                        <tr>
                            <td width="50%">Confirme password:</td>
                            <td width="50%"><input type="password" name="confirmPassword" /></td>
                        </tr>
                        <tr>
                            <td width="50%"><input type="submit" value="Registration"/></td>
                            <td width="50%"><a href="login.jsp">Login</a></td>
                        </tr>
                    </table>

                    <%--Name:             <input type="text" name="name" /><br>--%>
                    <%--Surname:          <input type="text" name="surname"/><br>--%>
                    <%--Phone:            <input type="tel" name="number"/><br>--%>
                    <%--Password:         <input type="password" name="password"><br>--%>
                    <%--Confirm Password: <input type="password" name="confirmPassword"><br>--%>
                    <%--<input type="submit" value="Registration"/>--%>
                    <%--<a href="login.jsp">Login</a>--%>
                </form>


                <%--<div style="clear: both"></div>--%>
                <p>
                    ${message}
                </p>

            </td>

        </tr>
        </tbody>
    </table>
    </body>
    </body>
</html>
