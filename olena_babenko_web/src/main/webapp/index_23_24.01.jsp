<%--
  Created by IntelliJ IDEA.
  User: lenchi
  Date: 23.01.16
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JavaScript</title>
</head>
<body>
<h1>Test1</h1>

<div>
    <input type="button" value="Test"/>
    <div>
        <h3>Test2</h3>
    </div>
</div>

<script>
    var doc = document.documentElement;
    document.write(doc.childElementCount);
    function CreateTree() {
        for (var i = 0; i < doc.childNodes.length; i++) {
            console.log(doc.childNodes.item(i) + "\n");
            document.write(doc.childNodes.item(i));
            console.log(doc.tagName + "\n");
            console.log(doc.innerHTML + "\n");

            //console.log(doc.tagName+"\n");
            //console.log(doc.innerHTML+"\n");
        }
    }
</script>

</body>
</html>


<%--при нажатии кнопки будет попап открываться, так как используем обработчик событий--%>
<%--<input type="button" value="Click me" onclick="fun()"/>
<%--чтобы подключить скрипт, обычный файл со скриптом, лучше подкладывать в отдельную папку
<script src="js/script_23,01.js" type="text/javascript"></script>--%>


<%--<script src="js/script_phone.js" type="text/javascript"></script>
<input type = "button" value="Send Call" onclick="Phone1()"/>--%>


<%--document.write(doc.tagName+"\n");
//document.write(doc.innerHTML+"\n");--%>
