import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {MotorbikeService} from 'src/app/services/motorbike.service';


@Component({
  selector: 'app-view-motorbike',
  templateUrl: './view-motorbike.component.html',
  styleUrls: ['./view-motorbike.component.css']
})
export class ViewMotorbikeComponent implements OnInit {

  constructor(private service: MotorbikeService) {
  }

  listMotorbike: MatTableDataSource<any>;
  displayedColumnsBike: string[] = ['PlateNumber', 'RentalFeePerDay', 'Make', 'Model', 'Type', 'EngineCapacity', 'TransmissionType', 'NumberOfSeats', 'Colour', 'HelmetType', 'HelmetSize']

  ngOnInit() {
    this.refreshMotorbikeList();
  }

  refreshMotorbikeList() {
    this.service.getMotorbikeList().subscribe(data => {
      this.listMotorbike = new MatTableDataSource(data);
    })
  }

  applyBikeFilter(filterbikevalue: string) {
    this.listMotorbike.filter = filterbikevalue.trim().toLocaleLowerCase();
  }

}
