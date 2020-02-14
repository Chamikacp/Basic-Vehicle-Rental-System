import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Car} from 'src/app/models/car';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) {
  }

  readonly APIUrl = "http://localhost:8080";

  getCarList(): Observable<Car[]> {
    return this.http.get<Car[]>(this.APIUrl + '/getAllCars');
  }
}
