import { Component, OnInit } from '@angular/core';
import { RouterService } from 'src/app/router.service';
import { UserserviceService } from 'src/app/userservice.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private routeservice:RouterService,private userservice:UserserviceService) { }

  ngOnInit(): void {
  }
  goTohome(){
    this.routeservice.navigateToRestaurantHome();
  }
  goToorders(){
    this.routeservice.navigateToRestaurantOrders();
  }
  goTologin(){
    this.userservice.clearToken();
    this.routeservice.navigateToDhashboard();
  }
  goToAddRestaurant(){
    this.routeservice.navigateToAddRestaurant();
  }
}
