import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterService {

  constructor(private router: Router) { }
  navigateToDhashboard(){
    this.router.navigate(['dashboard']);
  }
  navigateToLogin(){
    this.router.navigate(['login']);
  }
  navigateToCustomerRegistration(){
    this.router.navigate(['customer/registration']);
  }
  navigateToOwnerRegistration(){
    this.router.navigate(['owner/registration']);
  }
  navigateToAdminHome(){
    this.router.navigate(['admin','home']);
  }
  
  navigateToRequests(){
    this.router.navigate(['admin','requests']);
  }
  navigateToAdminFeedbacks(){
    this.router.navigate(['admin','feedbacks']);
  }
  navigateToAdminOrders(){
    this.router.navigate(['admin','ordersStatus']);
  }
  navigateToCustomerHome(){
    this.router.navigate(['customer/home']);
  }
  navigateTosearch(){
    this.router.navigate(['search']);
  }
  navigateToRestaurant(){
    this.router.navigate(['restaurant']);
  }
  navigateToCart(){
    this.router.navigate(['cart']);
  }
  navigateToRestaurantHome(){
    this.router.navigate(['restaurant','home']);
    
  }
  navigateToUpdateDish(id:any){
    this.router.navigate(['update',id]);
  }
  navigateToRestaurantOrders(){
    this.router.navigate(['orders']);
  }
  navigateToAddRestaurant(){
    this.router.navigate(['addrestaurant']);
  }
}
