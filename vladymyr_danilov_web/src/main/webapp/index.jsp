
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <%--<script src="js/script1.js" type="text/javascript"></script>--%>
        <script>
            console.log('Hello!');
            var array = new Array(1,2,3,4,5,6,7,8,9);

            for ( var i = 0, j = array.length - 1; i < 3; i++, j-- ) {
                var temp = array[i];

                array[i] = array[j];
                array[j] = temp;
            }

            console.log(array);

        </script>
        <table border="0" align="center" width="100%">
            <tr valign="MIDDLE">
                <th width="33.33%" align="CENTER">
                    <h2>IN GOD</h2>
                </th>
                <th width="33.33%" align="CENTER">
                    <h2>WE</h2>
                </th>
                <th width="33.33%" align="CENTER">
                    <h2>TRUST</h2>
                </th>
            </tr>
            <tr>
                <td colspan="3" align="CENTER">
                    <a href="http://citrus.ua"><img src="http://cdn1.citrus.ua/upload/iblock/188/harman-kardon-esquire-mini-728x250.jpg" width="50%"></a>
                </td>
            </tr>
        </table>
        <table border="0" align="CENTER" width="100%">
            <tr>
                <td width="16.66%" align="CENTER"><a href="login.jsp"><h4>Login</h4></a></td>
                <td WIDTH="16.66%" ALIGN="CENTER"><a href="login.jsp"><h4>Registration</h4></a></td>
                <td width="16.66%" align="CENTER"><h4>News</h4></td>
                <td width="16.66%" align="CENTER"><h4>Contacts</h4></td>
                <td WIDTH="16.66%" align="center"><h4>Support</h4></td>
            </tr>
        </table>
        <table border="1" cellpadding="7" width="100%" align="center">
            <tfoot align="center">
                <tr>
                    <td colspan="2"> &copy;2016</td>
                </tr>
            </tfoot>
            <tbody>
                <tr>
                    <td width="20%" align="center" valign="top">
                        <br>
                        <h3>News</h3>
                        <ul>
                            <li>Main</li>
                            <li>Policy</li>
                            <li>Abroad</li>
                            <li>Sport</li>
                            <li>Culture</li>
                            <li>Photo</li>
                            <li>Video</li>
                        </ul>
                    </td>
                    <td align="center" valign="middle">
                        <h3>On Macbook has been installed Android</h3>
                        <p><img src="http://ilenta.com/netcat_files/444/314/remix_os_mac_1.jpg" align="left">Remix OS
                            представляет собой специализированную редакцию Android для компьютеров на базе процессора
                            x86, предназначенную для работы в качестве «настольной» системы.
                            Одними из первых решила испытать данную систему команда издания 9to5Google, правда запустили
                            ребята ее на MacBook Air, а доказательства опубликовали в YouTube.
                            <a href="http://ilenta.com/news/ios-android-wp/news_10019.html">Link</a>
                        </p>
                    </td>
                </tr>
            </tbody>
        </table>

    </body>
</html>