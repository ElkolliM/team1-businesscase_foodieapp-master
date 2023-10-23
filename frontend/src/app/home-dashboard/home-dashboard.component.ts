import { Component, OnInit } from '@angular/core';
import { RouterService } from '../router.service';

@Component({
  selector: 'app-home-dashboard',
  templateUrl: './home-dashboard.component.html',
  styleUrls: ['./home-dashboard.component.css']
})
export class HomeDashboardComponent implements OnInit {

  constructor(private service:RouterService) { }

  ngOnInit(): void {
  }


  login(){
    //subscribe (to api user)
  }
  gotologin(){
      this.service.navigateToLogin();
  }  
  goToCustomerRegistration(){
    this.service.navigateToCustomerRegistration();
  }


}
