var server = require("./server");
var router = require("./router");
var requestHandlers = require("./requestHandlers");
var R = require('ramda');

var handle = {}
handle["/"] = requestHandlers.start;
handle["/start"] = requestHandlers.start;
handle["/upload"] = requestHandlers.upload;
handle["/del"] = requestHandlers.del;
handle["/edit"] = requestHandlers.edit;

server.start(router.route, handle);