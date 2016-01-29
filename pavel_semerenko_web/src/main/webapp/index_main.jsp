<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Приветствую</title>
    </head>
    <body>
        ${error_message}
        <form action="/login" method="post">
            <input type="text" name="login"/> <br/>
            <input type="password" name="password"/> <br/>
            <input type="submit" name="enter" value="Вход" /> <br/>
            <a href="registerClient.jsp">Регистрация</a> <br/>
        </form>
        <script>
            function PhoneClass(_number, _rest){
                var number = _number;
                var rest = _rest;
                var tarrif = 3;
                this.doCall = function (time){
                    if(rest < time * tarrif){
                        alert('не достаточно средств');
                    } else {
                        rest -= time * tarrif;
                    }
                }
            }

            phone1 = new PhoneClass('0279803928', 32);
            phone2 = new PhoneClass('0920213034', 23);

            var tab = '';
            function printTree(_element, tab) {
                tab += '  ';
                var element = _element;
                document.writeln(tab + element.tagName + '<br/>'/*+ element.innerHTML*/);
                for (var i = 0; i < element.childNodes.length; i++) {
                    printTree(element.childNodes.item(i), tab);
                }
            }
            var doc = document.documentElement;
            printTree(doc);


        </script>
        <button type="button" onclick="phone1.doCall(5)">call 1</button>
        <button type="button" onclick="phone2.doCall(10)">call 2</button>
    </body>
</html>