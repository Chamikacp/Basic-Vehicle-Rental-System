import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Motorbike} from 'src/app/models/motorbike';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MotorbikeService {

  constructor(private http: HttpClient) {
  }

  readonly APIUrl = "http://localhost:8080";

  getMotorbikeList(): Observable<Motorbike[]> {
    return this.http.get<Motorbike[]>(this.APIUrl + "/getAllMotorbikes");
  }
}
