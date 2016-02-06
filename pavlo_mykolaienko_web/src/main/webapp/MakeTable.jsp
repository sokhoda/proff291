<%--
  Created by IntelliJ IDEA.
  User: Павло
  Date: 25.01.2016
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Створення таблиці</title>

</head>
<body>
<script>
    var at = [['8549217', '678.24'], ['0671296', '44.38'], ['0297464', '98.4'], ['4068235', '67.8'], ['4397901', '58,90']];
    var e1f = true;
    var e2f = true;


    var table = document.createElement('table');
    table.setAttribute("width", "540");

    edit1 = document.createElement('input');
    edit1.id = "edit1";
    edit2 = document.createElement('input');
    edit2.id = "edit2";


    table.setAttribute("border", "1");
    for (i = 0; i < at.length; i++) {

        var row = table.insertRow(-1);
        row.setAttribute("align", "center");


        var cell1 = row.insertCell(-1);
        cell1.style.width = "190px";
        cell1.innerHTML = at[i][0];


        var cell2 = row.insertCell(-1);
        cell2.style.width = "190px";
        cell2.innerHTML = at[i][1];


        var button1 = document.createElement('button');

        button1.innerHTML = "Видалити";

        button1.onclick = function () {
            //  (this).closest('tr').remove(); видалємоя
            //row.parentNode.deleteRow(row.rowIndex); видалємоя
            if ((e1f == true) && (e2f == true)) {
                row = this.parentNode.parentNode;
                table.deleteRow(row.rowIndex);
            }
        }

        var button2 = document.createElement('button');

        button2.innerHTML = "Редагувати";

        button2.onclick = function () {
            if ((e1f == true) && (e2f == true)) {
                e1f = false;
                e2f = false;

                row = this.parentNode.parentNode;

                edit1.value = row.children[0].innerHTML;
                row.children[0].innerHTML = "";
                row.children[0].appendChild(edit1);
                edit1.onchange = function () {
                    e1f = true;
                    row.children[0].innerHTML = edit1.value;
                    row.children[0].removeChild(row.children[0].children[0]);
                }

                edit2.value = row.children[1].innerHTML;
                row.children[1].innerHTML = "";
                row.children[1].appendChild(edit2);
                edit2.onchange = function () {
                    e2f = true;
                    row.children[1].innerHTML = edit2.value;
                    row.children[1].removeChild(row.children[1].children[0]);
                }
            }
        }

        var cell3 = row.insertCell(-1);
        cell3.style.borer = "0";
        cell3.appendChild(button1);

        var cell4 = row.insertCell(-1);
        cell4.style.borer = "0";
        cell4.appendChild(button2);


    }


    document.body.appendChild(table);


</script>
</body>
</html>
