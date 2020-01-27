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

    this.http.get('https://randomuser.me/api/?results=10').subscribe(data=>{
      console.log(data);
      this.vehicleList=data["results"]
      loading.dismiss()
    })
  }

}
