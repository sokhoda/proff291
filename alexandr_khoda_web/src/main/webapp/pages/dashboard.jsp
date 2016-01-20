<%--
  Created by IntelliJ IDEA.
  User: s_okhoda
  Date: 19.01.2016
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Main Menu</title>
        <style>
            <%@include file='/css/dashboard.css' %>
        </style>
    </head>
    <body>
        <form action="/ClientServlet" method="get">
          <table width="100%">
              <thead>
                  <tr align="center" style="font-size: x-large; font-weight:
                  bold; color: firebrick" >
                      <td colspan="100%">Главное меню</td>
                  </tr>
              </thead>
              <tbody>
                  <tr align="left" style="font-size: larger; font-weight: bold;
                  color: firebrick">
                      <td colspan="3"> Выберите действие:</td>
                  </tr>

                  <tr>
                      <td>
                          <input type="radio" name="selAct"
                                 value="createClient">Зарегистрировать клиента
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <input type="radio" name="selAct"
                                 value="showClientsByPortion">Вывести всех клиентов порциями по
                          <input type="text" name="clientQuantity"
                                 placeholder="10" value="10" >
                          человек
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <input type="radio" name="selAct"
                                 value="showClientsGtSum"> Вывести всех
                          клиентов наездивших на сумму больше
                          <input type="text" name="clientOrderSum" placeholder="100"
                                 value="100"> грн.
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <input type="radio" name="selAct"
                                 value="showClientsLastMonth" checked>
                          Вывести всех клиентов, делавших заказы за последний месяц
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <br> <input type="submit" value="Перейти">
                      </td>
                  </tr>
              </tbody>
              <tfoot>
                <td align="center">&copy; All rights reserved, Kyiv 2016</td>
              </tfoot>
          </table>
        </form>
    </body>
</html>
