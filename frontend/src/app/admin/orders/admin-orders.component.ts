import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order';
import { AdminService } from '../service/admin.service';


@Component({
  selector: 'app-adminorders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.css']
})
export class AdminOrdersComponent implements OnInit {
orderList: Order[];

constructor(private adminService: AdminService) { 
  }

  ngOnInit(): void {
    this.adminService.getAllOrders().subscribe(
      data=>{
        this.orderList = data;
      }
    )
  }

}
