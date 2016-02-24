<%@ page import="hw7.notes.view.Menu" %>
<%@ page import="hw7.notes.domain.Vendor" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.notes.dao.VendorDao" %>
<%@ page import="hw7.notes.service.NotebookService" %>
<%@ page import="hw7.notes.service.NotebookServiceImpl" %>
<%@ page import="static hw7.notes.view.Servlet.getAttribArray" %>
<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>
<script src="/hw7.notes/JS/select.js" type="text/javascript">    </script>
<script src="/hw7.notes/JS/notebooks.js" type="text/javascript">    </script>

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
            <%@include file='/hw7.notes/css/menu.css' %>
        </style>
    </head>
    <body>
    <%!
        NotebookService service;
        VendorDao vendorDao;
        List<Vendor> vendor = null;
    %>
    <%
        vendorDao = ((NotebookServiceImpl)Menu.service).getVendorDao();

        vendor = (List<Vendor>)vendorDao.findAll();
        String[] message = getAttribArray(request);

    %>
    <form action="/MainNote" method="post">

        <center><img id="MenuImg" src="/hw7.notes/img/laptop1.gif">
        </center>
        <h1 align="center">Welcome to the Computer Store</h1>
        <div>
            <label align="left" style="font-size: larger; font-weight: bold;
              color: firebrick">Please, make your choice:
            </label>
            <label id="message" style="width: 100%; margin-top:10%;
                color:<%=message[0]%>; text-align: center; font-size:x-large"><%=message[1]%>
            </label
        </div>

      <table width="100%">
          <thead>
          </thead>

          <tbody>
              <tr>
                  <td class="col0">
                      <input type="submit" name="crCPU"
                             value="1. Create CPU type">
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="crMemory"
                             value="2. Create Memory type">
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="crVen"
                             value="3. Create Vendor">
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="crNtbType"
                             value="4. Create Notebook type">
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="accBatch"
                             value="5. Accept batch of Notes">
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="sell"
                             value="6. Sell Notebooks from the store">
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="updCPU"
                             value="7. Update CPU">
                  </td>
                  <td class="colA">
                      <div class="cellIn">
                          <label class="smallSign">Portion:</label>
                          <input type="text" name="updCPUPortion"
                                 value="">
                      </div>
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="updMemory"
                             value="8. Update Memory">
                  </td>
                  <td class="colA">
                      <div class="cellIn">
                          <label class="smallSign">Portion:</label>
                          <input type="text" name="updMemoryPortion"
                                 value="">
                      </div>
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="updVen"
                             value="9. Update Vendor">
                  </td>
              </tr>

              <tr>
                  <td  class="col0">
                      <input type="submit" name="updNtb"
                             value="10. Update Notebook">
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="listNoteByPriceManDateVendor"
                             value="11. Write off Notebooks">
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="ByPortion"
                             value="12. List all Notebooks by Portion">
                  </td>
                  <td class="colA">
                      <div class="cellIn">
                          <label class="smallSign">Portion:</label>
                          <input type="text" name="ByPortionPortion"
                                 value="">
                      </div>
                  </td>
              </tr>

              <tr>
                  <td  class="col0">
                      <input type="submit" name="ByGreaterQuantity"
                             value="13. List all Notebooks, quant. >=">
                  </td>
                  <td class="colA">
                      <div class="cellIn">
                          <label class="smallSign">Quantity:</label>
                          <input type="text" name="ByGreaterQuantityQuantity"
                                 value="">
                      </div>
                  </td>

              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="ByCPUVendor"
                             value="14. List all Notebooks by CPU Vendor">
                  </td>
                  <td class="colA">
                      <div class="cellIn">
                          <label for="vendors">CPU Vendor:</label>
                          <% if(vendor != null){
                          %>
                          <select size="<%vendor.size();%>" name="ByCPUVendorCPUVendor" id="vendors">
                              <option disabled>select item</option>
                              <%
                                  for (Vendor v : vendor) {
                              %>
                              <option value="<%=v.getId()%>">
                                  <%=v.getName()%></option>
                              <%
                                  }
                              %>
                          </select>
                          <script type="text/javascript">
                              setSelectIndex('vendors', 1);
                          </script>
                          <%
                              }
                          %>

                      </div>
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="listNoteByPriceManDateVendor"
                             value="15. List all Notebooks in the Store">
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="listNoteByPriceManDateVendor"
                             value="16. List all Notebooks in the Store by Vendor">
                  </td>
              </tr>
              <tr>
                  <td  class="col0">
                      <input type="submit" name="listNoteByPriceManDateVendor"
                             value="17. Get AVE Daily Sell Rate">
                  </td>
              </tr>


              <tr>
                  <td  class="col0">
                      <%--<input type="submit" name="exit" class="but"--%>
                             <%--value=">10. Exit">--%>
                      <button name="exit" onclick="self.close()" class="but">18.
                          Exit</button>
                  </td>
              </tr>
          </tbody>

      </table>
        <footer style="text-align: center">&copy;<%=Menu.NameSurname%>
        </footer>
    </form>
    </body>
</html>
