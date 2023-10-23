import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserserviceService } from './userservice.service';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  constructor(private http:HttpClient, private service:UserserviceService) { }
  getDishes(): Observable<any> {
    return this.http.get<any>("http://localhost:9000/api/v1/orders",{
      headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
    });
  }
}
