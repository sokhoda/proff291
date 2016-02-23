<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static hw7.notes.view.Servlet.*" %>
<%@ page import="hw7.notes.domain.CPU" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.notes.dao.CPUDao" %>
<%@ page import="hw7.notes.view.Menu" %>
<%@ page import="hw7.notes.service.NotebookServiceImpl" %>
<%@ page import="hw7.notes.domain.Vendor" %>
<%@ page import="hw7.notes.dao.VendorDao" %>
<%--<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>--%>
<script src="/hw7.notes/JS/select.js" type="text/javascript">    </script>
<script src="/hw7.notes/JS/notebooks.js" type="text/javascript">    </script>

<html>
<head>
    <title>Update CPU Type</title>
    <style>
        <%@include file='/hw7.notes/css/addNotebook.css' %>
    </style>
    <center><h1>Update CPU Type</h1></center><br>
</head>
<body>
<%!
    CPUDao cpuDao;
    List<CPU> cpu;
%>
<%
    cpuDao = ((NotebookServiceImpl) Menu.service).getCpuDao();
%>

    <%
       cpu = (List<CPU>)cpuDao.findAll();
       request.setAttribute("cpu", cpu);
    %>

    <%--String vendorInputText = getAttribValue(request, "nameA");--%>

<script type="text/javascript">
    function onUpdate(id){
       var hid = document.getElementById('idVal');
        hid.innerText = (id == null ? 0 : id);
    }
</script>


<form action="/AddCpu" method="get">
    <div>
        <input type="submit" name="back" value="&longleftarrow; back">
        <label id="message" style="width: 100%; margin-top:10%;
                color:${messageColor == null ? 'brown' : messageColor};
                text-align: center; font-size:x-large">${messageText}
        </label>

        <input type="hidden" name="idVal" id="idVal" value="">
    </div>

    <table>
        <thead>
        <tr>
            <th colspan="100%"><h1>CPU list</h1></th>
        </tr>
        <tr>
            <%--<th class="shrink"><h3>ID</h3></th>--%>
            <th><h3>ID</h3></th>
            <th><h3>Vendor</h3></th>
            <th><h3>Frequency</h3></th>
            <th><h3>Model</h3></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="c" items="${cpu}" varStatus="cnt">
            <tr>
                <td class="shrink">c.id</td>
                <td align="left">c.vendor</td>
                <td align="left">c.freq</td>
                <td align="left">c.model</td>
                <td><button id="butUpdate" name="${c.id}"
                            onclick="onUpdate(${c.id})">Update</button>
                </td>
                <td><button id="butDelete" name="${c.id}"
                            onclick="onUpdate(${c.id})">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%--<label for="vendors">VENDOR:</label>--%>
    <%--<input  type="text" value="${nameA == null ? '': nameA}"--%>
            <%--placeholder="TOSHIBA"--%>
            <%--name="name" id="vendors"><br>--%>
    <%--<label for="freq">FREQUENCY:</label>--%>
    <%--<input  type="text" value="<%=vendor%>" placeholder="TOSHIBA"--%>
            <%--name="name" id="freq"><br>--%>
    <%--<label for="model">MODEL:</label>--%>
    <%--<input  type="text" value="<%=vendor%>" placeholder="TOSHIBA"--%>
            <%--name="name" id="model"><br>--%>
    <%--<br><br>--%>
</form>

</body>
</html>