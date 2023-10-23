import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from './models/user.model';


@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
  
  public user: Observable<User>
  constructor(private http:HttpClient) {
   }
   getuser(email:String): Observable<User> {
    return this.http.get<any>("http://localhost:9000/api/v1/"+email+"/");
  }
   getusers(): Observable<any> {
    return this.http.get<any>("http://localhost:9000/api/v1/users");
  }
   register(user:User){
      return this.http.post("http://localhost:9000/api/v1/register",user);
   }

   authenticateUser(user:any){
   
    return this.http.post<any>("http://localhost:9000/api/v1/login",user);
  }

  isUserAuthenticated(token:any): Promise<any>{
    
    return this.http.post<any>("http://localhost:9000/api/v1/auth",{},{
      headers: new HttpHeaders().set("Authorization","Bearer "+token)
    }).toPromise();
  }

  setToken(token:any){
    localStorage.setItem("bearer",token);
  }
  clearToken(){
    localStorage.setItem("bearer","  ");
  }

  getToken(){
    return localStorage.getItem("bearer");
  }

  removeItem(){
    localStorage.removeItem("bearer");
  }


}
