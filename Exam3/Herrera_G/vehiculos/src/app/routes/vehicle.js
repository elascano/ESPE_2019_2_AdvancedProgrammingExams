const Vehicle = require('../models/vehicleModel');

module.exports = function (app){

     app.getVehicle('/getVehicle', (req, res) => {
         Vehicle.getUsers((err, data) => {
             res.status(200).json(data);
         }); 
     });

}