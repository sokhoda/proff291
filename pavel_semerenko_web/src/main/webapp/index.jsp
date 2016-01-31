<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.Phones" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 26.01.2016
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Accounts</title>
        <script src="js/accountFunc.js" type="text/javascript"></script>
        <script src="js/jquery.js"></script>
        <%
            Map<String, Double> phones = new HashMap<String, Double>();
            phones.put("0938574635", 13.27d);
            phones.put("0993746374", 11.34d);
            phones.put("0503246323", 12.1d);
            phones.put("0964375453", 80.8d);
            phones.put("0973764724", 23.3d);
            phones.put("0663247843", 4.6d);
        %>
        <script>
            function createTable() {
                var table = document.getElementById('table_acc');
                var count_acc = table.childNodes.length;
                for(var i = 0; i < count_acc ; i++){
                    table.removeChild(table.childNodes.item(0));
                }

                createTableTitle(table);
                <% for(Map.Entry<String, Double> ph: phones.entrySet()) {%>
                     var row = document.createElement('tr');
                     table.appendChild(row);
                     createRow(row, '<%=ph.getKey()%>', <%=ph.getValue()%>);
                <% } %>
            }
        </script>
    </head>
    <body>
        <form id="form1">
            <input id="load" type="button" value="create table" onclick="createTable()"/>
        </form>

        <table id="table_acc"></table>
    </body>
</html>
