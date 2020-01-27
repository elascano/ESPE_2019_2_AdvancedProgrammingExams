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

  vehicleList:any[]=[]

  async getVehicle()
  {
    const loading = await this.loadingController.create({
      message: 'Cargando',
      duration: 2000   
    });
    await loading.present();

    this.http.get('http://ec2-3-19-64-3.us-east-2.compute.amazonaws.com:8080/api/get/vehicle/1').subscribe(data=>{
      console.log(data);
      this.vehicleList=data["results"]
      loading.dismiss()
    })
  }

}
