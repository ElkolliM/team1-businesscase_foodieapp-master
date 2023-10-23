import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  
  private headers = new HttpHeaders().set('Content-Type', 'application/json');


  constructor() { }

//  addDish():Observable <any>{
 //   return this.http.post<any> ("http://localhost:9000" , dish ,{headers:this.headers})


  //}







}
