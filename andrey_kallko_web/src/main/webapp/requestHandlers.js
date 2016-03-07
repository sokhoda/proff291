var mysql      = require('mysql');
var matrix=new Array();

var startBaseSize=0;

var querystring = require("querystring");
var _ = require('lodash');




function createNode(ind, tan, tac){
    var body  = '<html>'+
        '<head>'+
        '</head>'+
        '<body>'+
        '<form action="/edit" method="post">'+
        '<input name="id" readonly id="id"'+ind+' rows="1" cols="5" value='+(ind)+' > </input>'+
        '<input name="name" id="tan"'+ind+' rows="1" cols="20" value='+tan+' > </input>'+
        '<input name="carry" id="tac"'+ind+' rows="1" cols="10" value='+tac+'> </input>'+
        '<input type="submit" value="Edit"  id='+(ind)+'  />'+
        '</form>'+

        '<form action="/del" method="post">'+
        '<input name="id" visibility: hidden readonly id="id"'+ind+' rows="1" cols="5" value='+(ind)+' > </input>'+
        '<input type="submit"  id="del"'+ind+' value="Delete Row"  id='+(ind)+'  />'+
        '</form>'+
        '</body>'+
        '</html>';
    return body;
}





function createNewButton(){
    var body  = '<html>'+
        '<head>'+
        '</head>'+
        '<body>'+
        '<form action="/upload" method="post">'+
        '<input type="submit" id = "create" value="New item" />'+
        '</form>'+
        '</body>'+
        '</html>';
    return body;
}

function start(response, postData) {
    console.log("Request handler 'start' was called.");

    var connection = mysql.createConnection({
        host     : 'localhost',
        user     : 'root',
        password : 'Faerton1976',
        database : 'notes'
    });

    startBaseSize=0;

    connection.connect();

    connection.query('SELECT * FROM cars WHERE id >= 1',  function(err, results) {

        console.log('The solution is: ', results.length);
        startBaseSize=results.length;
        var i=0;

        response.writeHead(200, {"Content-Type": "text/html"});

        while (i<startBaseSize){
            console.log("try to build");
            matrix[i]=results[i];
            console.log(_.findIndex(matrix, "2"));
            console.log(i + " " + matrix[i].name +" " + matrix[i].capacity);
            var adder=createNode(matrix[i].id, matrix[i].name , matrix[i].capacity);
           // cosole.log("create new adder" + i);
            response.write(adder);
            i++;
        }
        adder=createNewButton();
        response.write(adder);
        response.end();
    });
    connection.end();

}



function upload(response, postData) {
    console.log("Request handler 'upload' was called.");
    response.writeHead(302, {
        'Location': 'http://localhost:8888/start',
        "Content-Type": "text/plain"
    });
    response.write("You've sent the text: "+
        querystring.parse(postData).text + "matrix size=" + matrix.length);

    // создание нового елемента в базе данных
    var connection = mysql.createConnection({
        host     : 'localhost',
        user     : 'root',
        password : 'Faerton1976',
        database : 'notes'
    });
    connection.connect();


    connection.query('INSERT INTO cars (name, capacity) values("", 0)',  function(err, results) {

    });


    connection.end();
//окончание создания



    response.end();
}



function del(response, postData) {
    console.log("Request handler 'delete' was called.");
    response.writeHead(302, {
        'Location': 'http://localhost:8888/start',
        "Content-Type": "text/plain"
    });
    response.write("You've sent: " + postData.substring(3));


    var number=postData.substring(3);

    var connection = mysql.createConnection({
        host     : 'localhost',
        user     : 'root',
        password : 'Faerton1976',
        database : 'notes'
    });
    connection.connect();

    connection.query('DELETE FROM cars WHERE id='+number,  function(err, results) {

    });

    connection.end;

    response.end();



}


function edit(response, postData) {
    console.log("Request handler 'edit' was called.");
    response.writeHead(302, {
        'Location': 'http://localhost:8888/start',
        "Content-Type": "text/plain"
    });

    response.write("You've sent: " + postData.substring(3));


    var number=postData.indexOf("&name");
    var sId=postData.substring(3,number);
    var number2 = postData.indexOf("&carry=");
    var sName=postData.substring((number+6), number2);
    var sCarry=postData.substring((number2+7));
    console.log(" id="+sId + " name="+sName + " Carry=" + sCarry);


    var connection = mysql.createConnection({
        host     : 'localhost',
        user     : 'root',
        password : 'Faerton1976',
        database : 'notes'
    });
    connection.connect();


    connection.query('UPDATE cars SET name="'+sName+'", capacity='+sCarry+ ' WHERE id='+sId,  function(err, results) {


    });
    connection.end;

    response.end();



}

exports.start = start;
exports.upload = upload;
exports.del = del;
exports.edit=edit;