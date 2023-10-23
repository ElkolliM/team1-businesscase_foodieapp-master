import { Component, OnInit } from '@angular/core';
import { Dish } from 'src/app/models/dish.model';
import { Orders } from 'src/app/orders.model';
import { OrdersService } from 'src/app/orders.service';
import { RouterService } from 'src/app/router.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  constructor(private route:RouterService,private service:OrdersService) { }
  orders:Orders[]=[]
  dishes:Dish[]=[]
  ngOnInit(): void {
    this.service.getDishes().subscribe((elem)=>{
      this.orders=elem;
      console.log(this.orders)
        });
        
        
  }
  completed(order:Orders) {
 
    order.isnotready=!order.isnotready;
    
  }

}
