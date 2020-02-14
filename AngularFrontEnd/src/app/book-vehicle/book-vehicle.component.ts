import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../services/customer.service';
import {NgForm} from '@angular/forms';


@Component({
  selector: 'app-book-vehicle',
  templateUrl: './book-vehicle.component.html',
  styleUrls: ['./book-vehicle.component.css']
})
export class BookVehicleComponent implements OnInit {

  constructor(private service: CustomerService) {
  }

  ngOnInit() {
    this.resetForm();
  }

  resetForm(form?: NgForm) {
    if (form != null)
      form.resetForm();

    this.service.formData = {
      plateNumber: '',
      pickUpDate: '',
      dropOffDate: '',
      customerName: '',
      licenseNumber: '',
      address: '',
      phoneNumber: ''
    }
  }

  onSubmit(form: NgForm) {
    this.service.addBooking(form.value).subscribe(res => {
        this.resetForm(form);
        alert("Booking Successed !!!")
      }
    )
  }
}
