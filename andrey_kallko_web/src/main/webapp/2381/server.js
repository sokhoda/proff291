var http = require('http');
var url = require('url');
var fs = require('fs');
var R = require('ramda');


var server = new http.Server(function(req, res){

    //console.log(req.url);

    if (req.url=='/23801'){

        res.statusCode=200;
        readData(res);

    //
    } else {
        res.statusCode=404;
        res.end("Page not found");
    }

})

server.listen(8080, '127.0.0.1');

function readData(res) {
    var text = fs.readFileSync('company_23801.json', 'utf8');
    var firm=JSON.parse(text);
    var doc =createHTML(res, firm);
    res.end(doc);
}

function createHTML(res, firm){
    res.writeHead(200, {
        'Content-Type': 'text/html',

    });
    var header = '';
    var body = '';

    header +='<meta charset=utf-8>'

    body+= '<table border="1">' +
        '<caption>Firm details </caption>' +
        '<tr>' +
        '<th> Key </th>' +
        '<th> Value </th>'

        var i=0;
        var size=R.keys(firm[0]).length;
        while (i<size){
            body+="</tr><tr><td>"+(R.keys(firm[0])[i])+"</td><td>"+(R.values(firm[0])[i])+"</td></tr>";

            i++;
        }


       body+='</table>';

    return '<!DOCTYPE html>'
        + '<html><header>' + header + '</header><body>' + body + '</body></html>';

}

