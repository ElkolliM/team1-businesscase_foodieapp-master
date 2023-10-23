import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Restaurant } from 'src/app/models/Restaurant';
import { Order } from 'src/app/models/order';
import { Feedback } from 'src/app/models/Feedback'
import { UserserviceService } from 'src/app/userservice.service';
@Injectable({
  providedIn: 'root'
})

export class AdminService {
  url = "http://localhost:9000/api/v1/";

  constructor(private http:HttpClient,private service:UserserviceService) { }

  getApprovedRestaurantList():Observable<Array<Restaurant>>{
    let newUrl = this.url+"restaurant/approved";
    return this.http.get<Array<Restaurant>>(newUrl,{
      headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
    });
  }

  getRequestedRestaurantList():Observable<Array<Restaurant>>{
    let newUrl = this.url+"restaurant/requests";
    return this.http.get<Array<Restaurant>>(newUrl,{
      headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
    });
  }

  changeRestaurantStatus(restaurantId: string):Observable<Restaurant>{
    let newUrl = this.url+ "restaurant/"+restaurantId;
    return this.http.put<Restaurant>(newUrl,null,{
      headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
    });
  }

  removeRestaurant(restaurantId:string):Observable<Restaurant>{
    let newUrl = this.url+"restaurant/"+restaurantId;
    return this.http.delete<Restaurant>(newUrl,{
      headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
    });
  }

  getAllOrders():Observable<Array<Order>>{
    let newUrl = "http://localhost:9000/api/v1/orders";
    return this.http.get<Array<Order>>(newUrl,{
      headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
    });
  }

  getFeedbacks(restaurantId:String):Observable<Array<Feedback>>{
    let newUrl = "http://localhost:9000/api/v1/feedbacks/"+restaurantId; 
    return this.http.get<Array<Feedback>>(newUrl,{
      headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
    });
  }
  
  getRestaurant(restaurantId:String):Observable<Restaurant>{
    let newUrl = this.url+"restaurant/"+restaurantId;
    return this.http.get<Restaurant>(newUrl,{
      headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
    });
  }
}
