<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="static hw6.notes.view.Menu.*" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.notes.domain.Vendor" %>
<%@ page import="sun.plugin2.gluegen.runtime.CPU" %>
<%@ page import="hw7.notes.domain.Memory" %>
<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>
<script src="/hw7.notes/JS/select.js" type="text/javascript">    </script>

<html>
<head>
    <title>User management</title>
    <style>
        <%@include file='/hw7.notes/css/addNotebook.css' %>
    </style>
</head>
<body>
<%!
    List<Vendor> vendors;
    List<CPU> cpus;
    List<Memory> memories;
%>
<%
    String serial = getAttribValue(request, "serialA");
    String vendor = getAttribValue(request, "vendorA");
    String model = getAttribValue(request, "modelA");
    String manDate = getAttribValue(request, "manDateA");
    String price = getAttribValue(request, "priceA");


    String[] message = getAttribArray(request);
    vendors = (List<Vendor>) request.getAttribute("vendors");
    cpus = (List<CPU>) request.getAttribute("cpus");
    memories = (List<Memory>) request.getAttribute("memories");

%>

<form>
    <img src="/hw7.notes/img/addLaptop1.jpg" align="left"
         style="margin-right: 20px">
    <label for="vendors">VENDOR:</label>
    <select size="<%vendors.size();%>" name="vendors" id="vendors">
        <option disabled>select item</option>
        <%
            for (Vendor v : vendors) {
        %>
        <option value="<%v.getName()%>"><%v.getName()%></option>
        <%
            }
        %>
    </select>
    <script> setSelectIndex("vendors",0); </script>
    <br>

    <label for="3">MODEL:</label>
    <input  type="text" value="<%= model %>" placeholder="Satellite S-2535LX"
            name="model" id="3"><br>

    <label for="4">DATE OF MANUFACTURE:</label>
    <input  type="text" value="<%= manDate %>" placeholder="<%=checkDate(new
    GregorianCalendar())%>" name="manDate" id="4"><br>


    <br><br>
    <br><br>
    <p style="text-align: center;">
        <input type="submit" name="back" value="&longleftarrow; back"  action="/MenuNote" method="get">
        <input type="submit" name="addNoteB" value="Add Notebook"  action="/MenuNote" method="get">
        <button name="clearAddNoteB" onclick="clearAllAddNotebook();">Clear
            All</button>
    </p>
    <br>
    <br>
    <label id="message" style="width: 100%; margin-top:10%; color:<%=message[0]%>;
            text-align: center; font-size:x-large"><%=message[1]%>
    </label>
</form>

</body>
</html>