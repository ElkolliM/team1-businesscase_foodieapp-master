import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dish } from './models/dish.model';
import { UserserviceService } from './userservice.service';

@Injectable({
  providedIn: 'root'
})
export class DishService {
  // public dish: Observable<Dish>
  constructor(private http:HttpClient, private service:UserserviceService) { }
  getDishes(): Observable<any> {
    return this.http.get<any>("http://localhost:9000/api/v1/dish"
    ,{
     headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
   }
    
    );
  }
  getDish(id:any): Observable<any> {
    return this.http.get<any>("http://localhost:9000/api/v1/dish/"
    
   +id,{
     headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
   }
    
    );
  }
   adddish(dish:Dish){
      return this.http.post("http://localhost:9000/api/v1/dish"
      
      ,dish,{
        headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
      }
      );
   }
   deleteDish(id: any): Observable<any> {
    return this.http.delete<any>("http://localhost:9000/api/v1/dish/"+id,{
      headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
    });
  }
  updateDish(dish: Dish ): Observable<any> {
    return this.http.put<any>("http://localhost:9000/api/v1/dish/"+dish.dishId,dish,{
      headers: new HttpHeaders().set("Authorization","Bearer "+this.service.getToken())
    });
  }
}
