<%@ page import="hw8.taxi.service.ClientServiceImpl" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="hw6.notes.dao.NotebookDao" %>
<%@ page import="hw6.notes.dao.NotebookDaoImpl" %>
<%@ page import="hw6.notes.service.NotebookService" %>
<%@ page import="hw6.notes.service.NotebookServiceImpl" %>
<%@ page import="java.util.Locale" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder" %>
<%@ page import="org.hibernate.boot.registry.StandardServiceRegistry" %>
<%@ page import="hw6.notes.view.Menu" %><%--
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
            <%@include file='/hw6.notes/css/menu.css' %>
        </style>
    </head>
    <body>

    <form action="/MenuNote" method="post">
      <table width="100%">
          <thead>
              <tr><th align="center"><img id="MenuImg"
                                          src="/hw6.notes/img/laptop1.gif"></th>
              </tr>
              <tr>
                  <th colspan="100%"><h1>Главное меню</h1></th>
              </tr>
          </thead>
          <%!

          %>
          <%

          %>
          <tbody>
              <tr align="left" style="font-size: larger; font-weight: bold;
              color: firebrick">
                  <td colspan="3"> Выберите действие:</td>
              </tr>
              <tr>
                  <td>
                      <input type="submit" name="addNote" value="1. Add notebook">
                  </td>
              </tr>
              <tr>
                  <td>
                      <input type="submit" name="delNote"
                             value="2. Delete notebook by id">
                      <input type="text" name="id" value="" >
                  </td>
              </tr>
              <tr>
                  <td>
                      <input type="submit" name="updtPrice"
                             value="3. Update notebook price by id">
                      <input type="text" name="id" value="" >
                  </td>
              </tr>
              <tr>
                  <td>
                      <input type="submit" name="updtSnVendor"
                             value="4. Update notebook serial & vendor by id">
                      <input type="text" name="id" value="" >
                  </td>
              </tr>
              <tr>
                  <td>
                      <%--<input type="submit" name="exit" class="but"--%>
                             <%--value=">10. Exit">--%>
                      <button name="exit" onclick="self.close()" class="but">10.
                          Exit</button>
                  </td>
              </tr>
              <%--<tr>--%>
                  <%--<td>--%>
                      <%--<input type="radio" name="selAct" value="showOrdersSum">--%>
                      <%--Вывести список заказов на сумму в диапазоне от--%>
                      <%--<input type="text" name="minOrderSum" value="<%=--%>
                          <%--clientServiceImpl.getOrderService().getMinOrderSum()--%>
                          <%--%>" > грн. до--%>
                      <%--<input type="text" name="maxOrderSum" value="<%=--%>
                          <%--clientServiceImpl.getOrderService().getMaxOrderSum()--%>
                          <%--%>" > грн.--%>
                  <%--</td>--%>
              <%--</tr>--%>
              <%--<tr>--%>
                  <%--<td>--%>
                      <%--<input type="radio" name="selAct" value="showOrdersByPortion">--%>
                      <%--Вывести список всех заказов порциями по--%>
                      <%--<input type="text" name="orderQuantity"--%>
                             <%--placeholder="10" value="<%=--%>
                          <%--clientServiceImpl.getOrderService().getOrderQuantity()--%>
                          <%--%>" > заказов--%>
                  <%--</td>--%>
              <%--</tr>--%>
              <%--<tr>--%>
                  <%--<td>--%>
                      <%--<br>--%>
                      <%--<input type="submit" value="Перейти">--%>
                  <%--</td>--%>
              <%--</tr>--%>
          </tbody>
          <tfoot>
            <td align="center">&copy;<%=Menu.NameSurname%></td>
          </tfoot>
      </table>
    </form>
    </body>
</html>
