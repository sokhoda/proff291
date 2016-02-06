<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Proff29</title>
        <script>
            console.log('Hello JS');
        </script>
        <script>
            var vector = [1,2,3,4,5,6,7,8,9];

            var i,tmp;
            for(i = 0; i < 3; i++){
                tmp = vector[i];
               vector[i] =  vector[vector.length - (i + 1)];
                vector[vector.length -(i + 1)] = tmp;

            }
            console.log(vector);


        </script>
        <script src="js/script.js" type="text/javascript">

    </script>
        <script src="js/Phone.js" type="text/javascript">

        </script>
    </head>
    <body>
        <h3>Hello proff29!!!</h3>
    </body>
</html>