<%--
  Created by IntelliJ IDEA.
  User: Пк2
  Date: 26.02.2016
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dashboard</title>
</head>
<body>
    <table>
        <tr>
            <td>
                <fieldSet>
                    <legend> Clients </legend>

                    <!--Create Client-->
                    <form action="/client" method="post">
                        <table>
                            <tr>
                                <td>
                    <span>
                        Register client
                    </span>
                                </td>
                                <td>
                                    <button name="Button" value="showRegistrForm"type="submit" formaction="/client" formmethod="post">Show</button>
                                </td>
                            </tr>
                        </table>

                    </form>

                    <!--Show clients by ten-->
                    <form>
                        <table>
                            <tr>
                                <td>
                    <span>
                        Show clients by 10
                    </span>
                                </td>
                                <td>
                                    <button name="Button" value="showClientsByTen"type="submit" formaction="/client" formmethod="post">Show</button>
                                </td>
                            </tr>
                        </table>
                    </form>

                    <%--<form action="/client" method="post">--%>
                    <%--<input name="Button" type="submit" value="show by 10"/>--%>
                    <%--</form>--%>

                    <!--Show clients where orderCost>aValue-->
                    <form>
                        <table>
                            <tr>
                                <td>
                    <span>
                        Show clients where order cost greater then:
                    </span>
                                    <input name="wantedCost" type="text"/>
                                </td>
                                <td>
                                    <button name="Button" value="showClientsByOrderCost"type="submit" formaction="/client" formmethod="post">Show</button>
                                </td>
                            </tr>
                        </table>
                    </form>

                    <!--Show clients who made orders in this month-->
                    <form>
                        <table>
                            <tr>
                                <td>
                    <span>
                        Show clients who made orders in this month:
                    </span>
                                </td>
                                <td>
                                    <button name="Button" value="showThisMonthClients"type="submit" formaction="/client" formmethod="post">Show</button>
                                </td>
                            </tr>
                        </table>
                    </form>
                </fieldSet>
            </td>

            <td>
                <fieldSet>
                    <legend> Orders </legend>


                </fieldSet>
            </td>
        </tr>
    </table>



</body>
</html>
