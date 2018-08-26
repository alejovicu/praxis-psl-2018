var users = require('../controllers/user-controller');

module.exports = function (app) {
    app.route('/user')
        .post(users.create)
        .get(users.list);

    app.route('/user/:userId')
        .get(users.read);
    app.param('userId', users.userByID);
};
