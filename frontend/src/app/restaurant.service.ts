import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from './restaurant.model';
import { UserserviceService } from './userservice.service';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  public resto: Observable<Restaurant>
  constructor(private http:HttpClient, private service:UserserviceService) { }
  getRestaurants(): Observable<any> {
    return this.http.get<any>("http://localhost:9000/api/v1/restaurant/approved",
    {
     headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
   }
    );
  }
   registerRestaurant(resto:Restaurant){
      return this.http.post("http://localhost:9000/api/v1/restaurant",resto,{
        headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
      });
   }
}
