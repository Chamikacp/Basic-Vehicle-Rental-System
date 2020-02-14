import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ViewListComponent} from './view-list/view-list.component';
import {BookVehicleComponent} from './book-vehicle/book-vehicle.component';
import {ViewCarComponent} from './view-car/view-car.component';
import {ViewMotorbikeComponent} from './view-motorbike/view-motorbike.component';
import {HttpClientModule} from '@angular/common/http';

import {CarService} from 'src/app/services/car.service';
import {MotorbikeService} from 'src/app/services/motorbike.service';
import {MatTableModule} from '@angular/material/table';



@NgModule({
  declarations: [
    AppComponent,
    ViewListComponent,
    BookVehicleComponent,
    ViewCarComponent,
    ViewMotorbikeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatTableModule,
    FormsModule
  ],
  providers: [CarService, MotorbikeService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
