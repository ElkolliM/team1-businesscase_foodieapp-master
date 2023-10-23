import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs';
import { Dish } from 'src/app/models/dish.model';
import { DishService } from 'src/app/dish.service';
import { RouterService } from 'src/app/router.service';

@Component({
  selector: 'app-restaurant-home-page',
  templateUrl: './restaurant-home-page.component.html',
  styleUrls: ['./restaurant-home-page.component.css']
})
export class RestaurantHomePageComponent implements OnInit {
  form1;
  dishes:Dish[]=[]
  constructor(private formbuilder:FormBuilder, private dishservice:DishService, private route:RouterService) { 
    this.form1=this.formbuilder.group({
      dishId:new FormControl(null,[Validators.required]),
      dishName: new FormControl(null,[Validators.required]),
      dishType:new FormControl(null,[Validators.required]),
      dishDetails: new FormControl(null,[Validators.required]),
      dishPrice: new FormControl(null,[Validators.required]),
      dishImage: new FormControl(null,[Validators.required]),
  })
   }
      

  ngOnInit(): void {
    this.dishservice.getDishes().subscribe((elem)=>{
      this.dishes=elem;
      console.log(this.dishes);
    })
  }
  
  addDish(){
    let dish = new Dish();
    dish.dishId=this.form1.value.dishId;
    dish.dishType=this.form1.value.dishType;
    dish.dishName=this.form1.value.dishName;
    dish.dishDetails=this.form1.value.dishDetails;
    dish.dishPrice=this.form1.value.dishPrice;
    dish.dishImage=this.form1.value.dishImage;
    this.dishservice.adddish(dish).pipe(first()).subscribe(elem=>this.route.navigateToRestaurantHome());
    this.dishes.push(dish);
  }
  deletedish(id:string) {
    this.dishservice.deleteDish(id).subscribe((elem)=>{
      for (let i=0;i<this.dishes.length;i++){
        if (this.dishes[i].dishId===id)
        this.dishes.splice(i,1);
       
      }

      console.log("Deleted");
    })
  }
  updatedish(id:any){
    this.route.navigateToUpdateDish(id);
  }
  
}
