var User = require('mongoose').model('User');

const create = function (res, next, name) {
  var user = new User({name: name});
  user.save(function (err) {
    if (err) {
      return next(err);
    } else {
      res.json(user);
    }
  });
};

const list = function (res, next) {
  User.find({}, function (err, users) {
    if (err) {
      return next(err);
    } else {
      res.json(users);
    }
  });
};

const remove = function (res, next, nameToDelete) {
  User.remove({ name: { $eq: nameToDelete } }, function (err, users) {
    if (err) {
      return next(err);
    } else {
      res.json(users);
    }
  });
};

exports.executeCommand = function (req, res, next) {
  switch(req.query.command) { // it should check in lowercase
  case 'crear':
    // it should check if name exists
    create(res, next, req.query.name);
    break;
  case 'mostrar':
    list(res, next);
    break;
  case 'borrar':
    remove(res, next, req.query.name);
    break;
  default:
    res.status(500).send('Error: Comando no válido: ' + req.query.command);
  }
};
