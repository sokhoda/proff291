<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Proff29</title>
        <%--<script>
            console.log('Hello JS');
            var array=new Array();
            var arrString='';
            for(var i=0; i<12; i++){
                array[i]=i;
                arrString=arrString+' '+array[i];
            }

                console.log('before: '+arrString);
            var arrStringAfter='';
            for(var i=0; i<3; i++){
                var temp=array[array.length-i-1];
                array[array.length-i-1]=array[i];
                array[i]=temp;
            }
            for( var i=0; i<array.length;i++){
                arrStringAfter=arrStringAfter+' '+array[i];
            }
            console.log('after: '+arrStringAfter);
        </script>--%>
        <%--<script src="js/Telephone.js" type="text/javascript"></script>
        <script>
         var telephone1=new ClassTelephone('45-58',10,16);
         var telephone2=new ClassTelephone('13-13',100,5);
         telephone1.call(20);
         telephone2.call(15);
        </script>--%>

        <%--<script src="js/DOMmodelTreeOfindex.js.js" type="text/javascript"></script>
        <script>
            makeTree;
        </script>
--%>

    </head>
    <body>
    <%! int count =0;
       /* public void countUsers(){
            count=count++;
        };*/

    %>



        <form action="/form" method="post">
            <input type="text" name="login" value="Sveta"/>
            <input type="submit" value="POST"/>
        </form>

        <h1>Hello proff29!!!</h1>
        <p>Para</p>
        <a href="http://www.google.com.ua">Link</a>
        <br/>
        <img src="img/murano.jpg"/>
        <br/>
        <q>qoatation</q>

        <ol start="5" type="A">
            <li>item</li>
            <li>item</li>
            <li>item</li>
        </ol>

        <ul>
            <li>item 1</li>
            <li>item 2</li>
            <li>item 3</li>
        </ul>

        <table border="1">
            <thead>
                <tr>
                    <th>First</th>
                    <th colspan="2">Last</th>
                    <%--<th>Age</th>--%>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Alex</td>
                    <td>Bonasevich</td>
                    <td>35</td>
                </tr>

            </tbody>

            <tfoot></tfoot>
        </table>
    </body>
</html>