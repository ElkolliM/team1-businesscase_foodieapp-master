import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs';
import { RouterService } from '../router.service';
import { User } from '../models/user.model';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-customer-registration',
  templateUrl: './customer-registration.component.html',
  styleUrls: ['./customer-registration.component.css']
})
export class CustomerRegistrationComponent implements OnInit {
  
  form;
  users:User[]=[];
  constructor(private service:UserserviceService,private formbuilder:FormBuilder,private routeservice:RouterService) { 
    this.form=this.formbuilder.group({
      fname:['',[Validators.required,Validators.minLength(1)]],
      lname:['',[Validators.required,Validators.minLength(1)]],
      email:['',[Validators.required,Validators.minLength(1)]],
      password:['',[Validators.required,Validators.minLength(1)]],
      address:['',[Validators.required,Validators.minLength(1)]],
      mobile:['',[Validators.required,Validators.minLength(1)]]

  })  
  }

  ngOnInit(): void {this.service.getusers().subscribe((elem)=>{
    this.users=elem;
  
  })
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
    user.role="customer";
        this.service.register(user).pipe(first())
                    .subscribe(elem=>{this.routeservice.navigateToLogin()});
    this.users.push(user);
  }
  goTohome(){
    this.routeservice.navigateToDhashboard();
  }
  
}
