
<html>
<head>
    <title>Logistic</title>
</head>
<body>
<script>

//var matrix = [["Renault", 200],["Man", 300],["Daf", 400]];
//
//    var nTitle = document.createElement("text");
//    nTitle.type="text";
//    nTitle.style.position="absolute";
//    nTitle.style.top=10;
//    nTitle.style.left=10;
//    nTitle.style.fontSize=20;
//    nTitle.style.font="Verdana"
//    nTitle.textContent="Car Name"
//    document.body.appendChild(nTitle);
//
//    var cvTitle = document.createElement("text");
//    cvTitle.type="text";
//    cvTitle.style.position="absolute";
//    cvTitle.style.top=10;
//    cvTitle.style.left=300;
//    cvTitle.style.fontSize=20;
//    cvTitle.style.font="Verdana"
//    cvTitle.textContent="Carrying"
//    document.body.appendChild(cvTitle);
//
//    var size = matrix.length;
//    var i=0;
//    while (i<size){
//        var tf=document.createElement("input");
//        tf.type="textfield";
//        tf.id="tfn"+i;
//        tf.style.position = 'absolute';
//        tf.style.top = 35+i*30+'px';
//        tf.style.width=250;
//        tf.style.fontSize=14;
//        tf.style.left=10;
//        tf.style.height=25;
//        tf.onkeydown=startEdit;
//        tf.value=matrix[i][0];
//        document.body.appendChild(tf);
//
//        var tf2=document.createElement("input");
//        tf2.type="textfield";
//        tf2.id="tfc"+i;
//        tf2.style.position = 'absolute';
//        tf2.style.top = 35+i*30+'px';
//        tf2.style.width=250;
//        tf2.style.fontSize=14;
//        tf2.style.left=300;
//        tf2.style.height=25;
//        tf2.onkeydown=startEdit;
//        tf2.value=matrix[i][1];
//        document.body.appendChild(tf2);
//
//        var But = document.createElement("button");
//        But.id = "edit" + i;
//        But.style.position = 'absolute';
//        But.style.top = 35+i*30+'px';
//        But.style.left = 570;
//        But.style.fontSize=14;
//        But.textContent="Edit";
//        But.onclick=editNode;
//        document.body.appendChild(But);
//
//        var But3 = document.createElement("button");
//        But3.id = "delete" + i;
//        But3.style.position = 'absolute';
//        But3.style.top = 35+i*30+'px';
//        But3.style.left = 650;
//        But3.style.fontSize=14;
//        But3.textContent="Delete";
//        But3.onclick=delNode;
//        document.body.appendChild(But3);
//
//        i++;
//    }
//
//
//    var But2 = document.createElement("button");
//    But2.id = "create";
//    But2.style.position = 'absolute';
//    But2.style.top = 35+size*30+'px';
//    But2.style.left = 10;
//    But2.style.fontSize=14;
//    But2.textContent="Create";
//    document.body.appendChild(But2);
//    But2.onclick=addNode;
//
//
//    function addNode(){
//        size=matrix.length;
//        But2.style.top = 35+size*30 +30;
//        alert("Create Object "+(size+1));
//
//        tf=document.createElement("input");
//        tf.type="textfield";
//        tf.id="tfn"+size;
//        tf.style.position = 'absolute';
//        tf.style.top = 35+size*30+'px';
//        tf.style.width=250;
//        tf.style.fontSize=14;
//        tf.style.left=10;
//        tf.style.height=25;
//        tf.onkeydown=startEdit;
//        document.body.appendChild(tf);
//
//        tf2=document.createElement("input");
//        tf2.type="textfield";
//        tf2.id="tfc"+size;
//        tf2.style.position = 'absolute';
//        tf2.style.top = 35+size*30+'px';
//        tf2.style.width=250;
//        tf2.style.fontSize=14;
//        tf2.style.left=300;
//        tf2.style.height=25;
//        tf2.onkeydown=startEdit;
//        document.body.appendChild(tf2);
//
//        But = document.createElement("button");
//        But.id = "edit" + size;
//        But.style.position = 'absolute';
//        But.style.top = 35+size*30+'px';
//        But.style.left = 570;
//        But.style.fontSize=14;
//        But.textContent="Confirm";
//        But.onclick=editNode;
//        document.body.appendChild(But);
//
//        But3 = document.createElement("button");
//        But3.id = "delete" + size;
//        But3.style.position = 'absolute';
//        But3.style.top = 35+size*30+'px';
//        But3.style.left = 650;
//        But3.style.fontSize=14;
//        But3.textContent="Delete";
//        But3.onclick=delNode;
//        document.body.appendChild(But3);
//
//        matrix.push(["",0])
//        tf2.value=matrix[size][1];
//
//    }
//
//function startEdit() {
//    var temp=this.id;
//    var k=temp.substr(3);
//    document.getElementById("edit"+k).textContent="Confirm";
//}
//
//function delNode() {
//
//    var temp=this.id;
//    var k=temp.substr(6);
//    matrix.splice(k,1);
//    size=matrix.length;
//    while(k<size){
//         document.getElementById("tfn"+k).value =matrix[k][0];
//         document.getElementById("tfc"+k).value = matrix[k][1];
//        k++;
//    }
//    document.body.removeChild(document.getElementById("tfn"+size));
//    document.body.removeChild(document.getElementById("tfc"+size));
//    document.body.removeChild(document.getElementById("delete"+size));
//    document.body.removeChild(document.getElementById("edit"+size));
//    But2.style.top = 35+size*30;
//}
//
//function editNode(){
//    this.textContent="Edit";
//    var temp=this.id;
//    temp=temp.substr(4);
//
//    if(isNaN(document.getElementById("tfc" + temp).value)) {
//        alert("Input integer, pls!!!!!");
//        document.getElementById("tfc" + temp).value=matrix[temp][1];
//        return;
//    }
//    matrix[temp][0]=document.getElementById("tfn" + temp).value;
//    matrix[temp][1]=document.getElementById("tfc" + temp).value;
//    alert("Node number=" + temp + " Car " + matrix[temp][0] + " Carry=" + matrix[temp][1]);
//}
//
var mysql      = require('mysql');
var connection = mysql.createConnection({
    host     : 'localhost',
    user     : 'root',
    password : 'Faerton1976',
    database : 'notes'
});

connection.connect();

connection.query('SELECT 1 + 1 AS solution', function(err, rows, fields) {
    if (err) throw err;

    console.log('The solution is: ', rows[0].solution);
});

connection.end();

</script>
</body>
</html>
