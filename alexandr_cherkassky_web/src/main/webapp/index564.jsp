
<html>
<head>

</head>
<body>
<table>
    <tHead id="tableHead">
    <tr>
        <span style="color: red; font-size: 200%; text-align: center;">  Telephone book
        </span>
    </tr>
    <script src="js/Telephone.js" type="text/javascript"> </script>
    <script>
        function drawTable(){
            var entries= makeTelephones();
            var parentCell=document.getElementById("drawTableBut").parentNode;
            var buttonDelArr=new Array(entries.length);
            document.getElementById("tableHead").removeChild(parentCell.parentNode);


            var doc=document.getElementById("tableBody");
            for (var i=0; i<entries.length; i++){

                var cell1=document.createElement('td');
                cell1.innerHTML=entries[i].number;

                var cell2=document.createElement('td');
                cell2.innerHTML=entries[i].balanceLeft;

                var cell4=document.createElement('td');
                cell4.setAttribute("id",'cellOfDelBut'+i);

                var cell3=document.createElement('td');
                cell3.setAttribute("id",'cellOfEditBut'+i);



                var row=document.createElement('tr');
                row.setAttribute("id",'rowId '+i);
                doc.appendChild(row);
                row.appendChild(cell1);
                row.appendChild(cell2);
                row.appendChild(cell4);
                row.appendChild(cell3);

                buttonDelArr[i]=new ClassDelButton("DelBut"+i,cell4);
                new ClassEditButton("EditButton "+i,cell3);


            }

            for( var i=0; i<buttonArr.length; i++){
                console.log("Button"+i+" "+buttonDellArr[i].getButton().getAttribute("id")+" cellId "+buttonArr[i].getButton().parentNode.getAttribute("id"))
            }


        }

        function ClassDelButton(idName,parentCell){
            var button=document.createElement('button');
            button.innerHTML='Del';
            button.setAttribute("id",idName);
            var parCell=parentCell;
            parCell.appendChild(button);


            this.getButton=function(){
                return button;
            }

            var onClickAction=function(){
                var parentRow=parCell.parentNode;
                var DelFrom=parentRow.parentNode;
                DelFrom.removeChild(parentRow);
            }
            button.onclick=onClickAction;
            //doc.dleteRow();



//         this.button.onclick=function(){
//                   var parentRow=parentCell.parentNode;
//                   //alert('Parent= '+parentCell.getAttribute("id")+' '+'GrandParent '+parentRow.parentNode.getAttribute("id"));
//                   var DelFrom=parentRow.parentNode;
//                   DelFrom.removeChild(parentRow);
//            }

        }

        function ClassEditButton(idName, parentCell) {
            var button = document.createElement('button');
            button.innerHTML = 'Edit';
            button.setAttribute("id", 'idName');
            parentCell.appendChild(button);
            function onClickEditAction() {

                var inputNumber = document.createElement('input');
                inputNumber.type = 'text';
                inputNumber.value = parentCell.parentNode.childNodes[0].innerHTML;
                parentCell.parentNode.childNodes[0].innerHTML = '';
                parentCell.parentNode.childNodes[0].appendChild(inputNumber);
                inputNumber.onkeydown = function (event) {
                  if (event.keyCode == 13) {
                        onEnterPressedAction(this);                   }
                };

                var inputBalance = document.createElement('input');
                inputBalance.type = 'text';
                inputBalance.value = parentCell.parentNode.childNodes[1].innerHTML;
                parentCell.parentNode.childNodes[1].innerHTML = '';
                parentCell.parentNode.childNodes[1].appendChild(inputBalance);
                inputBalance.onmouseout = function (event) {
                    //if (event.keyCode == 13) {
                        onEnterPressedAction(this);
                   // }
                }


                function onEnterPressedAction(inputField) {
                    var parent = inputField.parentNode;
                    parent.removeChild(inputField);
                    parent.innerHTML = inputField.value;
                }
            }
            button.onclick = onClickEditAction;
        }










    </script>


    <tr>
        <td>
            <button id="drawTableBut" style="vertical-align: middle" onclick="drawTable()"> Show list
            </button>
        </td>
    </tr>

    </tHead>
    <tBody id="tableBody">







    <tr>
        <th> Abonent number</th>
        <th> balance </th>
    </tr>

    </tBody>
</table>
</body>
</html>

 