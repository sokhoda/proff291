<%--
  Created by IntelliJ IDEA.
  User: Пк2
  Date: 12.03.2016
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Creation Form</title>
</head>
<body>
<form>
    <table>
    <tr>
        <td>
            <span>
                Order Id
            </span>
        </td>
        <td>
            <input name="OrderId" type="text"/>
        </td>
    </tr>
    <tr>
        <td>
            <span>
                Client Id
            </span>
        </td>
        <td>
        <input name="ClientId" type="text"/>
        </td>
    </tr>
    <tr>
        <td>
            <span>
                Trip Cost
            </span>
        </td>
        <td>
        <input name="orderCost" type="text"/>
        </td>
    </tr>
    <tr>
        <td>
            <span>
                From
            </span>
        </td>
        <td>
        <input name="AdressFrom" type="text"/>
        </td>
    </tr>
    <tr>
        <td>
            <span>
                Destination
            </span>
        </td>
        <td>
        <input name="AdressTo" type="text"/>
        </td>
    </tr>
    <tr>
        <td>
            <span>
                Press to Create:
            </span>
        </td>
        <td>
            <button name="Button" value="CreateOrder"  type="submit" formaction="/order" formmethod="post">
                Send</button>
        </td>
    </tr>
    </table>
</form>

</body>
</html>
