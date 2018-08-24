var express = require('express');
var mongoose = require('mongoose');

var db = mongoose();
var app = express();
var port = process.env.PORT || 3000;
var User = require('./models/user-model');
var bodyParser = require('body-parser');

db.Promise = global.Promise;
db.connect('mongodb://localhost/Userdb');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var routes = require('./routes/user-routes');
routes(app);

app.listen(port);
module.exports = app;

console.log('praxis app backend running at http://localhost:'+port+'/');
