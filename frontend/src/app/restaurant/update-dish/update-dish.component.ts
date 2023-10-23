import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { DishService } from 'src/app/dish.service';
import { Dish } from 'src/app/models/dish.model';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { RouterService } from 'src/app/router.service';
@Component({
  selector: 'app-update-dish',
  templateUrl: './update-dish.component.html',
  styleUrls: ['./update-dish.component.css']
})
export class UpdateDishComponent implements OnInit {
  dish:Dish
  id:any
  form
  constructor(private location:Location,private dishservice:DishService,private route: ActivatedRoute,private formbuilder:FormBuilder,private router:RouterService) {
    this.form=this.formbuilder.group({
      name:['',[Validators.required,Validators.minLength(1)]],
      details:['',[Validators.required,Validators.minLength(1)]],
      type:['',[Validators.required,Validators.minLength(1)]],
      price:['',[Validators.required,Validators.minLength(1)]],
      image:['',[Validators.required,Validators.minLength(1)]]

  })  
   }
 

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {

       this.id = params.get('id');
    });
    this.dishservice.getDish(this.id).subscribe((elem)=>{
      this.dish=elem;
      console.log(this.dish);
      this.form.value.name=this.dish.dishName;
    })
    

  }
  save(){
    
    this.dish.dishType=this.form.value.type;
    this.dish.dishName=this.form.value.name;
    this.dish.dishDetails=this.form.value.details;
    this.dish.dishPrice=this.form.value.price;
    // this.dish.dishImage=this.form.value.image;
    this.dishservice.updateDish(this.dish).subscribe((elem)=>{
      this.dish=elem;
      console.log(this.dish);
      this.router.navigateToRestaurantHome()
    });
  }
 
}
