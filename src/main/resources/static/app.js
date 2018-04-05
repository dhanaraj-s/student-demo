

var http = require("http");
var express = require("express");
var mongojs = require("mongojs");

var db = mongojs('test',['Students']);
var routes = require('./routes/index');

var app = express();
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded());
app.use(bodyParser.json());

app.use(express.static(__dirname + "/"));

app.use('/client', express.static(__dirname + '/client/'));
app.use('/index',routes);

app.listen(8888);
console.log("Welcome to Node");
