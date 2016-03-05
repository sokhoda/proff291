<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="hw7.notes.service.NotebookService" %>
<%@ page import="hw7.notes.dao.VendorDao" %>
<%@ page import="java.util.Arrays" %>
<%--<%@ include file="loginTaxi.jsp"%>--%>



<script src="../../../JS/phone.js" type="text/javascript">    </script>
<%--<script src="JS/alexEx.js" type="text/javascript">    </script>--%>

<html>
<html>
<head>
    <title>Main Menu</title>
    <style>
        <%@include file='../css/menu.css' %>
    </style>
</head>
<body>
<c:set var="defPortion" value="5"/>
<c:set var="defQuant" value="15"/>

<form action="/estimation.html" method="get">

    <center><img id="MenuImg"
                 src="/hw7.notes/img/laptop1.gif">
    </center>
    <h1 align="center">Welcome to String Processor App</h1>
    <div>
        <label align="left" style="font-size: larger; font-weight: bold;
              color: firebrick">Please, enter your Data:
        </label>

    </div>

    <label for="data">Input Data:</label>
    <input  type="text" value="" placeholder="<data>" id="data"><br>

    <label>sum: ${sum}</label>

    <label>reverse: ${reverse}</label>

    <label>random: ${random}</label>

    <label id="message" style="width: 100%; color:${messageColor == null ? 'brown' : messageColor};
            text-align: center; font-size:x-large">${messageText}
    </label>

</form>
</body>
</html>
