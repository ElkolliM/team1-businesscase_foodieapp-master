import { Component, OnInit } from '@angular/core';
import { Dish } from 'src/app/models/dish.model';
import { DishService } from 'src/app/dish.service';
import { Restaurant } from 'src/app/restaurant.model';
import { RestaurantService } from 'src/app/restaurant.service';
import { CartServcieService } from '../cart-servcie.service';

@Component({
  selector: 'app-customer-restaurant',
  templateUrl: './customer-restaurant.component.html',
  styleUrls: ['./customer-restaurant.component.css']
})
export class CustomerRestaurantComponent implements OnInit {
  
  dish:any
  restaurants:Restaurant[];
  dishes:Dish[];


  constructor(private cartservcie:CartServcieService,private dishservice:DishService , private restaurantservice:RestaurantService) { }

  ngOnInit() {
    this.restaurantservice.getRestaurants().subscribe(data=> {this.restaurants = data;})
    this.dishservice.getDishes().subscribe(data=> {this.dishes = data;})
  }

  addtocart(dish:any){
   this.cartservcie.addtoCart(dish)
  }








}
