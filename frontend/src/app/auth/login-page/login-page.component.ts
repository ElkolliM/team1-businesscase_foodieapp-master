import { Component, OnInit } from '@angular/core';
import {  FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RouterService } from 'src/app/router.service';
import { User } from 'src/app/models/user.model';
import { UserserviceService } from 'src/app/userservice.service';
//import {AlertService, AuthentificationService} from '@/_services';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  // loginForm!:FormGroup;
  // loading =false;
  // submitted = false;
  // returnUrl!:string;
  email: FormControl = new FormControl("");
  password: FormControl = new FormControl("");
  users:User[]=[];
 
 errorMessage:string;
  constructor(
     private service:UserserviceService,private routeservice:RouterService
    // private route: ActivatedRoute,
    // private router: Router,
    //private authentificationService: AuthentificationService,
    //private alertService: AlertService
    // private formBuilder: FormBuilder,
  ) { 
      // this.form= new FormGroup({
      //   email:new FormControl('',[Validators.required,Validators.minLength(1)]),
      //   password:new FormControl('',[Validators.required,Validators.minLength(1)])
        
      // })
    //if (this.authentificationService)
  }

  ngOnInit(): void {
    this.service.getusers().subscribe((elem)=>{
      this.users=elem;  
    })
    
   
    
    
  }

  // onSubmit(f:NgForm):void {
  // }
  login(){
    // let user = {username:this.form.value.email.value,password:this.form.value.email.value};
    
    let user = {email:this.email.value,password:this.password.value};

    this.service.authenticateUser(user).subscribe((response)=>{
      let token = response['token'];
      this.service.setToken(token);
      this.users.forEach(x=>{
        if (x.email===user.email){
          if (x.role==="customer"){
            this.routeservice.navigateToCustomerHome();
          }
          else if (x.role==="admin"){
            this.routeservice.navigateToAdminHome();
          }
          else if (x.role==="owner"){
             console.log(x.role);
          this.routeservice.navigateToRestaurantHome();
          }
        }
        
      })
      
     
    },(error)=>{
      console.log(error);
      if(error.status == 403){
        this.errorMessage = error.error.message;
      }
    })

  }
  goTohome(){
    this.routeservice.navigateToDhashboard();
  }

}
