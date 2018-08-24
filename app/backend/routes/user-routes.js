'use strict';

module.exports = function (app) {
  var userList = require('../controllers/user-controller');

  app.route('/users')
    .get(userList.list_all_users)
    .post(userList.create_a_user)
    .delete(userList.delete_a_user);
};
