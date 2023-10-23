import { Component, OnInit } from '@angular/core';
import { Restaurant } from 'src/app/restaurant.model';
import { RestaurantService } from 'src/app/restaurant.service';
import { RouterService } from 'src/app/router.service';

@Component({
  selector: 'app-customer-search',
  templateUrl: './customer-search.component.html',
  styleUrls: ['./customer-search.component.css']
})
export class CustomerSearchComponent implements OnInit {

  restaurants: Restaurant[] = [];
  searchText: any;


  constructor(private restaurantservice:RestaurantService , private routerservice:RouterService) { }

  ngOnInit() {

    this.restaurantservice.getRestaurants().subscribe(data=> {this.restaurants = data;})

    console.log(this.restaurants);
  }
  gotosearch(){
    this.routerservice.navigateToRestaurant();
  }

  

  

}
