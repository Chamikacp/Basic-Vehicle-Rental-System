import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ViewListComponent} from './view-list/view-list.component' ;
import {BookVehicleComponent} from './book-vehicle/book-vehicle.component' ;
import {ViewCarComponent} from './view-car/view-car.component' ;
import {ViewMotorbikeComponent} from './view-motorbike/view-motorbike.component';


const routes: Routes = [
  {path: '', component: ViewListComponent},
  {path: 'book', component: BookVehicleComponent},
  {path: 'car', component: ViewCarComponent},
  {path: 'motorbike', component: ViewMotorbikeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
