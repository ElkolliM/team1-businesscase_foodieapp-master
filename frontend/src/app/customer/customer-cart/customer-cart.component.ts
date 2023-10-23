import { Component, OnInit } from '@angular/core';
import { Dish } from 'src/app/models/dish.model';
import { RouterService } from 'src/app/router.service';
import { CartServcieService } from '../cart-servcie.service';

@Component({
  selector: 'app-customer-cart',
  templateUrl: './customer-cart.component.html',
  styleUrls: ['./customer-cart.component.css']
})
export class CustomerCartComponent implements OnInit {
  dishes:Dish[];
  
  public products : any = [];
  public grandTotal !: number;
  constructor(private cartService : CartServcieService,private route: RouterService) { }

  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.products = res;
      this.grandTotal = this.cartService.getTotalPrice();
    })
  }
  removeItem(item: any){
    this.cartService.removeCartItem(item);
  }
  emptycart(){
    this.cartService.removeAllCart();
  }
gotosearch(){
  this.route.navigateToRestaurant();
}
}

  

