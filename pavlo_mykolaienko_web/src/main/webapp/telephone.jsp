<%--
  Created by IntelliJ IDEA.
  User: Павло
  Date: 24.01.2016
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        var telephone =
        {
            number: '698789',
            balance: 39,
            call: function call(calltime) {


                this.balance = this.balance - calltime;
                document.write(telephone.balance);

            }
        }

        telephone.call(7);


    </script>
</head>
<body>

</body>
</html>
