import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from 'src/app/models/customer';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) {
  }

  formData: Customer;

  readonly APIUrl = "http://localhost:8080";


  getCustomerList(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.APIUrl + '/getAllCustomers');
  }

  addBooking(cus: Customer) {
    return this.http.post(this.APIUrl + '/addCustomer', cus)
  }

}
