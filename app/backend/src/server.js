const express = require('express');
const app = express();
const port = process.env.PORT || 3000;
const mongoose = require('mongoose');
const User = require('./models/user-model');
const bodyParser = require('body-parser');

mongoose.Promise = global.Promise;

mongoose.connect('mongodb://praxis-db:27017/Userdb');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var routes = require('./routes/user-routes');
routes(app);

app.listen(port);
