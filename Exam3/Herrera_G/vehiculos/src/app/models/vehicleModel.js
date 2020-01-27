const mysql = require('mysql');

connection = mysql.createConnection({
    host: 'dbespe.cjvk5snqqjmr.us-east-2.rds.amazonaws.com',
    user: 'rootESPE',
    port: '3306',
    password: 'rootESPE',
    database: 'dbsuggestionsportal.Vehicle'
});

let vehicleModel = {};

vehicleModel.getUsers = (callback) => {
    if (connection) {
        connection.query('SELECT * FROM VEHICLE', (err, rows) => {
            if(err){
                throw err;
            } else {
                callback(null, rows);
            }
        })
    }
};
