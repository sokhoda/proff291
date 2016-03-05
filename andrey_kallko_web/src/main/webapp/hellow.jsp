
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logistic Management</title>
<script>



    var i, a, b, c, max;

    max = 1000000000;

    var d = Date.now();

    for (i = 0; i < max; i++) {
        a = 1234 + 5678 + i;
        b = 1234 * 5678 + i;
        c = 1234 / 2 + i;
    }

    console.log('Hello World!');

    <%--const http = require('http');--%>

    <%--const hostname = '127.0.0.1';--%>
    <%--const port = 1337;--%>

    <%--http.createServer((req, res) => {--%>
        <%--res.writeHead(200, { 'Content-Type': 'text/plain' });--%>
    <%--res.end('Hello World\n');--%>
    <%--}).listen(port, hostname, () => {--%>
        <%--console.log(`Server running at http://${hostname}:${port}/`);--%>
    <%--});--%>

//    //Locale.setDefault(Locale.ENGLISH);
//    alert("Application started...");
//
//
//    var  conn = null;
//    var url = "jdbc:mysql://localhost:3306/notes";
//    try {
//        conn = DriverManager.getConnection(url, "root", "Faerton1976");
//        alert("Connection complete.");
//        var st = conn.createStatement();//Готовим запрос
//        var rs = st.executeQuery("SELECT * from `items` where id >= 1;");//Выполняем запрос к БД, результат в переменной rs
//        while(rs.next()) {
//            alert(rs.getString("id") + " " + rs.getString(2) + " " + rs.getString(3));
//        }
//
//    } catch (exept) {
//        alert("Connection failed");
//    } finally {
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (Exception ) {
//                System.out.println("Что то здесь не так!!!");
//            }
//        }
//    }



</script>

</head>
<body>

</body>
</html>
