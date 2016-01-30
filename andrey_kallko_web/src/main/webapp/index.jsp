<%--
  Created by IntelliJ IDEA.
  User: elenabugercuk
  Date: 28.01.16
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Phone Application</title>
</head>
<body>


        <%--VARIANT 2--%>
    <div id="inputi">
        <div>
            <input name="telephone">
            <input name="balance">
            <input type="button" value="Добавить телефон" onclick="add_input(this.parentNode)">
            <input type="button" value="Удалить телефон" onclick="del_input(this.parentNode)">
            <input type="button" value="Редактировать телефон" onclick="edit_input(this.parentNode)">
            <input type="button" value="Проверка" onclick="check_input(this.parentNode)">

        </div>
    </div>



</form>

<script type="text/javascript">


//    document.writeln("NUMBER "+"________" +"              BALANCE");
//    document.writeln("<br>");
//
//    var matrix = [ [223344,150], [556677,250] ];
//    matrix.push([176589,350]);
//    matrix.push([044235,450]);
//    matrix.push([568874,550]);
//
//
//    var size=matrix.length;
//    var i=0;
//
//
//
//    while (i<5) {
//
//        var tfnumbername="tfNName"+i;
//        var tfbalancename="tfBName"+i;
//
//        var tf=document.createElement('input');
//        tf.id=tfnumbername;
//        tf.type='textfield';
//        tf.value=matrix[i][0];
//        document.body.appendChild(tf);
//
//        var tf2=document.createElement('input');
//        tf2.id=tfbalancename;
//        tf2.type='textfield';
//        tf2.value=matrix[i][1];
//        document.body.appendChild(tf2);
//
//        var btn1=document.createElement('input');
//        btn1.id='btn1'+i;
//        btn1.type='button';
//        btn1.value='edit';
//        document.body.appendChild(btn1);
//
//        var btn2=document.createElement('input');
//        btn2.id='btn2'+i;
//        btn2.type='button';
//        btn2.value='delete';
//        document.body.appendChild(btn2);
//        document.getElementById('btn2'+i).onclick = deleteNode;
//
//
//        document.writeln("<br>");
//
//    i++;
//
//    };
//
//    function deleteNode () {
//        obj = this.id;
//
//
//        var numero = obj.substring(4);
//        matrix[numero][0]=0;
//        matrix[numero][1]=0;
////        document.getElementById('tf2'+numero).value='deleted';
////        document.getElementById('tf'+numero).value='deleted';
//
//
//        alert('Клик'  + obj + " " + matrix[numero][0] );
//    }
//
//    function createNewPhone() {
//
//        var newNumber = tfc.value;
//        if (newNumber==undefined) {
//            newNumber='0';
//        }
//
//        var newBalance = tf2c.value;
//        if (newBalance==null) {
//            newBalance="balance";
//        }
//
//        var sizer = matrix.length;
//
//        document.body.removeChild(tfc);
//        document.body.removeChild(tf2c);
//        document.body.removeChild(btnc);
//        matrix.push([newNumber,newBalance]);
//
//
//
//
//         tfnumbername="tfNName"+sizer;
//         tfbalancename="tfBName"+sizer;
//
//        tf=document.createElement('input');
//        tf.id=tfnumbername;
//        tf.type='textfield';
//        tf.value=matrix[sizer][0];
//        document.body.appendChild(tf);
//
//        tf2=document.createElement('input');
//        tf2.id=tfbalancename;
//        tf2.type='textfield';
//        tf2.value=matrix[sizer][1];
//        document.body.appendChild(tf2);
//
//        btn1=document.createElement('input');
//        btn1.id='btn1'+sizer;
//        btn1.type='button';
//        btn1.value='edit';
//        document.body.appendChild(btn1);
//
//        btn2=document.createElement('input');
//        btn2.id='btn12'+sizer;
//        btn2.type='button';
//        btn2.value='delete';
//        document.body.appendChild(btn2);
////
////  Сделать перечод строчки
////
////       document.writeln("<br>");
//
////        var newInput;
////        newInput.innerHTML=newInput.innerHTML+'<br>';
//
//        tfc.value='';
//        tf2c.value='';
//        document.body.appendChild(tfc);
//        document.body.appendChild(tf2c);
//        document.body.appendChild(btnc);
//
//
//
//        sizer = matrix.length;
//        alert('Спасибо\r' + " " +newNumber+ " " + newBalance + '' + "New Size matrix =  " + sizer);
//    }
//
//
//    var tfc=document.createElement('input');
//    tfc.id="tfc";
//    tfc.type='textfield';
//    document.body.appendChild(tfc);
//
//    var tf2c=document.createElement('input');
//    tf2c.id='tf2c';
//    tf2c.type='textfield';
//    document.body.appendChild(tf2c);
//
//    var btnc=document.createElement('input');
//    btnc.id='btnc';
//    btnc.type='button';
//    btnc.value='create';
//    document.body.appendChild(btnc);
//    document.getElementById('btnc').onclick = createNewPhone;


//    VARIANT 2


function add_input(obj)
{


    var new_input=document.createElement('div');
    new_input.innerHTML='<input name="telephone">'+'<input name="balance">';
    new_input.innerHTML=new_input.innerHTML+'<input type="button" value="Добавить телефон" onclick="add_input(this.parentNode)">';
    new_input.innerHTML=new_input.innerHTML+'<input type="button" value="Удалить телефон" onclick="del_input(this.parentNode)">';
    new_input.innerHTML=new_input.innerHTML+'<input type="button" value="Редактировать телефон" onclick="edit_input(this.parentNode)">';
    new_input.innerHTML=new_input.innerHTML+'<input type="button" id = "one" value="Проверка" onclick="check_input(this.parentNode)">';

    if (obj.nextSibling){

        document.getElementById('inputi').insertBefore(new_input,obj.nextSibling)}

    else {document.getElementById('inputi').appendChild(new_input);}

    alert("what");
}


function del_input(obj)
{
    document.getElementById('inputi').removeChild(obj)
}

//function edit_input(obj){
//
//    var proba = ddocument.getElementById('inputi').getElementsByTagName('div').length;
//    alert("Matrix" + proba);
//
//}
//
//
//function check_input(obj){
//    var number = document.getElementById('inputi');
//    alert("Matrix " + number);
//
//}

</script>

</body>
</html>



