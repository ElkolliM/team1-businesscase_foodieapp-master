import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserserviceService } from './userservice.service';

@Injectable({
  providedIn: 'root'
})
export class ActivateCustomerGuard implements CanActivate {
  constructor(private service: UserserviceService){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Promise<boolean> {
      let token = this.service.getToken();
      return this.service.isUserAuthenticated(token).then((response)=>{
        if(response['isAuthenticated'] && response['role']==="customer"){
          return true;
        }
        return false;
      })
  }
  
}
