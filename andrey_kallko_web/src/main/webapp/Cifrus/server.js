/**
 * Created by elenabugercuk on 22.02.16.
 */




var http = require('http');
var url = require('url');
var fs = require('fs');
var R = require('ramda');
var mysql = require('mysql');
var querystring = require("querystring");
var bodyParser = require('body-parser');
var header ='<!DOCTYPE html><html><header><meta charset=utf-8> </header><body>';

var server = new http.Server(function(req, res){




    console.log(req.method);

    if (req.url=='/statistic'){

        res.statusCode=200;
        //createStat(res);

        res.end(" It will be statistic page soon");
        //createStat(res);

        //
    } else {

        if (req.url=='/order'){
            res.statusCode=200;
            //createOrder(res);
            res.end("Are you ready to make order?");

        } else {
            if (req.url=='/') {
                res.statusCode=200;
                auth(res);
                res.end();
            }
        }
        res.statusCode=404;
        res.end("Page not found");
    }

})

server.listen(8080, '127.0.0.1');



 function auth(res) {

         res.writeHead(200, {
             'Content-Type': 'text/html',

         });

         var body = '';



         body= '<form action="/" method="post">'+

             '<thead>Connection details </thead>' +
             '<br>'+
             '<textarea id ="text" name="text" rows="1" cols="50"></textarea><br>'+
             '<input value="localhost" id="host">Host</input><br>' +
             '<input value="root" id="user">User  </input><br>' +
             '<input value="********" id="pass">Pasword   </input><br>' +
             '<input type="submit" value="Connect" id="scheme"></input><br>'




         var toWrite =  header  + body + '</body></html>';


     res.write(toWrite);






        //var host = document.getElementById("host").value

        var connection = mysql.createConnection({
            host: 'localhost',
            user: 'root',
            password: 'Faerton1976',
            database: 'notes'
        });


        connection.connect();

        connection.query('SELECT * FROM waitors WHERE idwaitors >= 1', function (err, results) {
            console.log(results.length);
        });


}