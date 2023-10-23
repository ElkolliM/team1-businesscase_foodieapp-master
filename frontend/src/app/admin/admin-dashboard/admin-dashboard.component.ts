import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Restaurant } from 'src/app/models/Restaurant';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  selectedRestaurant?: Restaurant;
  approvedRestaurantList: Restaurant [];
  //form: any = {};
  constructor(private adminService: AdminService, private router:Router ) { 
    
  }

  ngOnInit() {
   this.adminService.getApprovedRestaurantList().subscribe(
     data=>{
       this.approvedRestaurantList = data;
     }
   )
  }
  disableRestaurant(restaurantId:string){
    this.adminService.changeRestaurantStatus(restaurantId).subscribe(
      data=>{
        this.approvedRestaurantList = this.approvedRestaurantList.filter(restaurant => restaurant.restaurantId!=data.restaurantId);
      }
    )

  }

  goToFeedback(restaurantId:any){
    this.router.navigate(['feedbacks',restaurantId]);
  }

}
