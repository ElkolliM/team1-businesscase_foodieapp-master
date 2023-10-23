import { Component, OnInit } from '@angular/core';
import { Restaurant } from 'src/app/models/Restaurant';
import { RouterService } from 'src/app/router.service';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-admin-requests',
  templateUrl: './admin-requests.component.html',
  styleUrls: ['./admin-requests.component.css']
})
export class AdminRequestsComponent implements OnInit {
restaurantReq: Restaurant[];
  constructor(private adminService: AdminService,private route:RouterService) { 
  }

  ngOnInit(): void {
    this.adminService.getRequestedRestaurantList().subscribe(
      data=>{
        this.restaurantReq = data;
      }
    )
  }

  approveRestaurant(restaurantId:string){
    this.adminService.changeRestaurantStatus(restaurantId).subscribe(
      data=>{
        this.restaurantReq = this.restaurantReq.filter(restaurant => restaurant.restaurantId!=data.restaurantId);
      }
    )

  }

  removeRestaurant(restaurantId:string){
    this.adminService.removeRestaurant(restaurantId).subscribe(
      data => {
        this.restaurantReq = this.restaurantReq.filter(restaurant => restaurant.restaurantId!=data.restaurantId);
      }
    )
  }



}
