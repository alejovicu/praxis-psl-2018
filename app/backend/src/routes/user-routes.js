var users = require('../controllers/user-controller');

module.exports = function (app) {
  app.route('/user')
    .get(users.executeCommand);
};
