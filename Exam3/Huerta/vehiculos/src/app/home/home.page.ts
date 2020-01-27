import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoadingController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor(public http: HttpClient, public loadingController: LoadingController) {
    this.getVehicle()    
  }

  usersList:any[]=[]

  async getVehicle()
  {
    const Vehicle = require('../models/vehicleModel');

    module.exports = function (app){

     app.getVehicle('/getVehicle', (req, res) => {
         Vehicle.getUsers((err, data) => {
             res.status(200).json(data);
         }); 
     });

    }
  }

}
