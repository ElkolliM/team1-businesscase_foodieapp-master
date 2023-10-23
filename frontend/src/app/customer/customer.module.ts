import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { CustomerHeaderComponent } from './customer-header/customer-header.component';
import { CustomerFooterComponent } from './customer-footer/customer-footer.component';
import { CustomerSearchComponent } from './customer-search/customer-search.component';
import { CustomerCartComponent } from './customer-cart/customer-cart.component';
import { CustomerRestaurantComponent } from './customer-restaurant/customer-restaurant.component';
import { SearchPipe } from '../search.pipe';
import { FormsModule } from '@angular/forms';
import { CartServcieService } from './cart-servcie.service';




@NgModule({
  declarations: [
    CustomerDashboardComponent,
    CustomerHeaderComponent,
    CustomerFooterComponent,
    CustomerSearchComponent,
    CustomerCartComponent,
    CustomerRestaurantComponent,
    SearchPipe
    
  
    
  ],

  imports: [
    CommonModule,
    FormsModule
  ],
  exports:[
    CustomerDashboardComponent,
    CustomerHeaderComponent,
    CustomerFooterComponent,
    CustomerSearchComponent,
    CustomerCartComponent,
    CustomerRestaurantComponent,
    
    

  ]

  
})
export class CustomerModule { }
