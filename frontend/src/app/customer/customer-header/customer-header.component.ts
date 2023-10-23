import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { RouterService } from 'src/app/router.service';

@Component({
  selector: 'app-customer-header',
  templateUrl: './customer-header.component.html',
  styleUrls: ['./customer-header.component.css']
})
export class CustomerHeaderComponent implements OnInit {

  constructor(private routerservice:RouterService) { }

  ngOnInit() {

  }

  onClick(){
    this.routerservice.navigateToCart();
    console.log("onClick");
  }

  goToHome(){
    this.routerservice.navigateToCustomerHome();
  }


  logout(){
    this.routerservice.navigateToDhashboard();
  }


}
