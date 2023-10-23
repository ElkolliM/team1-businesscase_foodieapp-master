import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { first } from 'rxjs';
import { Restaurant } from 'src/app/restaurant.model';
import { RestaurantService } from 'src/app/restaurant.service';
import { RouterService } from 'src/app/router.service';

@Component({
  selector: 'app-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styleUrls: ['./add-restaurant.component.css']
})
export class AddRestaurantComponent implements OnInit {
  form1;
  restaurants:Restaurant[]=[];
  constructor(private formbuilder:FormBuilder,private Rservice:RestaurantService,private route:RouterService) {
    this.form1=this.formbuilder.group({
      restaurantId:['',[Validators.required,Validators.minLength(1)]],
      restaurantName:['',[Validators.required,Validators.minLength(1)]],
    restaurantLocation:['',[Validators.required,Validators.minLength(1)]],
      restaurantCategory:['',[Validators.required,Validators.minLength(1)]],
      restaurantImage:['',[Validators.required,Validators.minLength(1)]]

   })
  }

  ngOnInit(): void {
    this.Rservice.getRestaurants().subscribe((elem)=>{
      this.restaurants=elem;
      console.log(this.restaurants);
    })

  }
  addrestaurant(){
    let resto= new Restaurant();
    resto.restaurantId=this.form1.value.restaurantId;
    resto.restaurantName=this.form1.value.restaurantName;
    resto.restaurantLocation=this.form1.value.restaurantLocation;
    resto.restaurantCategory=this.form1.value.restaurantCategory;
    resto.restaurantImage=this.form1.value.restaurantImage;
  
    this.Rservice.registerRestaurant(resto).pipe(first()).subscribe(elem=>this.route.navigateToRestaurantHome());
  }
}
