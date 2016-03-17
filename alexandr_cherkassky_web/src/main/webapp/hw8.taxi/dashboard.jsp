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
                                    <button name="Button" value="showRegistrForm" type="submit" formaction="/client" formmethod="post">Show</button>
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
                    <!--Create new Order-->
                    <form>
                        <table>
                            <tr>
                                <td>
                                    <span>
                                            Register order
                                    </span>
                                </td>
                                <td>
                                    <button name="Button" value="showOrderCreationForm" type="submit"
                                            formaction="/order" formmethod="post">Show</button>
                                </td>
                            </tr>
                        </table>
                    </form>

                    <!--Edit order-->
                    <form>
                        <table>
                            <tr>
                                <td>
                                     <table>
                                         <tr>
                                             <td>
                                                 <span>
                                                     Edit order whit id
                                                 </span>
                                             </td>
                                             <td>
                                                 <input name="orderId" type="text/">
                                             </td>
                                         </tr>
                                     </table>
                                </td>
                                <td>
                                    <button name="Button" value="EditOrder" type="submit"
                                            formaction="/order" formmethod="post" > Edit </button>
                                </td>
                            </tr>
                        </table>
                    </form>

                    <!--Show orders by order cost-->
                    <form>
                        <table>
                            <tr>
                                <td>
                                    <table>
                                        <tr>
                                            <td>
                                            <span>
                                                Show orders by cost
                                                from to
                                            </span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input name="OrdersByCostFrom" type="text"/>
                                            </td>
                                            <td>
                                                <input name="OrdersByCostTo" type="text"/>
                                            </td>
                                        </tr>
                                    </table>

                                </td>
                                <td>
                                    <button name="Button" value="showOrdersByCost" type="SUBMIT"
                                            formaction="/order" formmethod="post">Show</button>
                                </td>
                            </tr>
                        </table>
                    </form>

                    <!--Show orders by portion-->
                    <form>
                        <table>
                            <tr>
                                <td>
                                    <span>
                                        Show orders by portion 10
                                    </span>
                                </td>
                                <td>
                                    <button name="Button" value="showOrderByPortion" type="submit"
                                            formaction="/order" formmethod="post">Show</button>
                                </td>
                            </tr>
                        </table>
                    </form>


                </fieldSet>
            </td>
        </tr>
    </table>



</body>
</html>
