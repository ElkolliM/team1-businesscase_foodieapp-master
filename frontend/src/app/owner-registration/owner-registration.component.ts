import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs';
import { Restaurant } from '../restaurant.model';
import { RestaurantService } from '../restaurant.service';
import { RouterService } from '../router.service';
import { User } from '../models/user.model';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-owner-registration',
  templateUrl: './owner-registration.component.html',
  styleUrls: ['./owner-registration.component.css']
})
export class OwnerRegistrationComponent implements OnInit {
  form;
 
  users:User[]=[];
  

  constructor(private service:UserserviceService,private formbuilder:FormBuilder,
    private route:RouterService,private Rservice:RestaurantService) {
    this.form=this.formbuilder.group({
      fname:['',[Validators.required,Validators.minLength(1)]],
      lname:['',[Validators.required,Validators.minLength(1)]],
      email:['',[Validators.required,Validators.minLength(1)]],
      password:['',[Validators.required,Validators.minLength(1)]],
      address:['',[Validators.required,Validators.minLength(1)]],
      mobile:['',[Validators.required,Validators.minLength(1)]]
    })
    
 
   }

  ngOnInit(): void {
    this.service.getusers().subscribe((elem)=>{
      this.users=elem;
      ;})
      // this.Rservice.getRestaurants().subscribe(elem=>{
      //   this.restaurants=elem;
      // })
  }
  
  
    adduser(){
      let user= new User();
     let ids=this.users.map(a=>a.userId);
     let x= Math.max(...ids);
     user.userId=x+1;
    user.fname=this.form.value.fname;
    user.lname=this.form.value.lname;
    user.email=this.form.value.email;
    user.password=this.form.value.password;
    user.address=this.form.value.address;
    user.mobile=this.form.value.mobile;
    user.role="owner";
    console.log(user)
    
    this.service.register(user).pipe(first()).subscribe(elem=>{this.route.navigateToLogin()});
    this.users.push(user);
  }
  
  goTohome(){
    this.route.navigateToDhashboard();
  }
}
