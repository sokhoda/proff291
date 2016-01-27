<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%--<%@ include file="index_TAXI.jsp"%>--%>



<script src="JS/phone.js" type="text/javascript">    </script>
<%--<script src="JS/alexEx.js" type="text/javascript">    </script>--%>



    <%request.getRequestDispatcher("pages/debug_phoneTable.jsp").forward(request,response); %>
<html>
<head>
    <%--<button name="but1" onclick=" getTree();">press</button>--%>
    <%--<style>--%>
        <%--<%@ include file="css/table.css"%>--%>
    <%--</style>--%>
</head>
<body>
    <%--<p onclick="functionFun()">text1</p>--%>
    <button id="createTableButton" onclick="generatePhoneTable()">Create Table
    </button>
</body>
</html>

<%--<html>--%>
    <%--<head>--%>
        <%--<title>Welcome to JS</title>--%>
        <%--<script>--%>
            <%--console.log('Hello JS1');--%>
        <%--</script>--%>
    <%--</head>--%>
    <%--<body>--%>
    <%--&lt;%&ndash;<script src="JS/phone.js" type="text/javascript">    </script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<script src="JS/getDOMTree.js" type="text/javascript">    </script>&ndash;%&gt;--%>

        <%--&lt;%&ndash;<%request.getRequestDispatcher("index_TAXI.jsp").forward(request, response);%>&ndash;%&gt;--%>

    <%--<p id="outText1" onclick=" global = 2; functionFun()" >text1</p>--%>
    <%--<p id="outText2"></p>--%>

    <%--&lt;%&ndash;<script>&ndash;%&gt;--%>
        <%--&lt;%&ndash;var vector = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);&ndash;%&gt;--%>
        <%--&lt;%&ndash;document.getElementById("outText1").innerHTML = vector.toString();&ndash;%&gt;--%>

        <%--&lt;%&ndash;document.getElementById("outText2").innerHTML = mirrorArray(vector, 4).toString();&ndash;%&gt;--%>
    <%--&lt;%&ndash;</script>&ndash;%&gt;--%>

    <%--</body>--%>

<%--</html>--%>