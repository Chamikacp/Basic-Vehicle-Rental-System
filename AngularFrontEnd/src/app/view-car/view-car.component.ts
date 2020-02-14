import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {CarService} from '../services/car.service';


@Component({
  selector: 'app-view-car',
  templateUrl: './view-car.component.html',
  styleUrls: ['./view-car.component.css']
})
export class ViewCarComponent implements OnInit {


  constructor(private service: CarService) {
  }

  listCar: MatTableDataSource<any>;
  displayedColumns: string[] = ['PlateNumber', 'RentalFeePerDay', 'Make', 'Model', 'Type', 'EngineCapacity', 'TransmissionType', 'NumberOfSeats', 'Colour', 'NumberOfDoors', 'AirConditioning', 'FuelType']

  ngOnInit() {
    this.refreshCarList();
  }

  refreshCarList() {
    this.service.getCarList().subscribe(data => {
      this.listCar = new MatTableDataSource(data);
    });
  }

  applyCarFilter(filtercarvalue: string) {
    this.listCar.filter = filtercarvalue.trim().toLocaleLowerCase();
  }

}
