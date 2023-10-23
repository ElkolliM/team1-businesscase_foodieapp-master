import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeDashboardComponent } from './home-dashboard/home-dashboard.component';
import { MainHeaderComponent } from './main-header/main-header.component';
import { MainFooterComponent } from './main-footer/main-footer.component';
import { CustomerRegistrationComponent } from './customer-registration/customer-registration.component';
import { OwnerRegistrationComponent } from './owner-registration/owner-registration.component';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatToolbarModule} from '@angular/material/toolbar';

import { RestaurantComponent } from './restaurant/restaurant.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatListModule } from '@angular/material/list';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatMenuModule } from '@angular/material/menu';
import { MatIcon, MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';



import { UpdateDishComponent } from './restaurant/update-dish/update-dish.component';
import { OrdersComponent } from './restaurant/orders/orders.component';
import { HeaderComponent } from './restaurant/header/header.component';
import { FooterComponent } from './restaurant/footer/footer.component';
import { RestaurantHomePageComponent } from './restaurant/restaurant-home-page/restaurant-home-page.component';
import { HttpClientModule} from '@angular/common/http';

import { RouterService } from './router.service';
import { RouterModule, ROUTES, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { CustomerDashboardComponent } from './customer/customer-dashboard/customer-dashboard.component';
import { AdminRequestsComponent } from './admin/admin-requests/admin-requests.component';
import { FeedbacksComponent } from './admin/feedbacks/feedbacks.component';
import { CustomerSearchComponent } from './customer/customer-search/customer-search.component';
import { CustomerRestaurantComponent } from './customer/customer-restaurant/customer-restaurant.component';
import { CustomerCartComponent } from './customer/customer-cart/customer-cart.component';
import { AuthModule } from './auth/auth.module';
import { LoginPageComponent } from './auth/login-page/login-page.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { RestaurantFeedbacksComponent } from './restaurant/restaurant-feedbacks/restaurant-feedbacks.component';
import { AddRestaurantComponent } from './restaurant/add-restaurant/add-restaurant.component';
import { AdminModule } from './admin/admin.module';

import { CustomerModule } from './customer/customer.module';
import { ActivateAdminGuard } from './activate-admin.guard';
import { ActivateCustomerGuard } from './activate-customer.guard';
import { ActivateRestaurantGuard } from './activate-restaurant.guard';
import { AdminOrdersComponent } from './admin/orders/admin-orders.component';



const routes: Routes = [
  {path:'dashboard',component:HomeDashboardComponent},
    {path:'login',component:LoginPageComponent},
     
      {path: 'admin/home', component:AdminDashboardComponent},
  {path: 'admin/requests',component:AdminRequestsComponent},
  {path: 'admin/ordersStatus', component:AdminOrdersComponent},
  {path: 'feedbacks/:restaurantId', component:FeedbacksComponent},
      {path:'customer/home',component:CustomerDashboardComponent},
        {path:'search', component:CustomerSearchComponent},
        {path:'restaurant',component:CustomerRestaurantComponent},
        {path:'cart',component:CustomerCartComponent},
      {path:'restaurant/home',component:RestaurantHomePageComponent},
        {path:'update/:id',component:UpdateDishComponent},
        {path:'orders',component:OrdersComponent},
    {path:'customer/registration',component:CustomerRegistrationComponent},
    {path:'owner/registration',component:OwnerRegistrationComponent},
    {path:'addrestaurant',component:AddRestaurantComponent},
   
  {path:'',redirectTo:'dashboard',pathMatch:"full"}
  
]



@NgModule({
  declarations: [
    AppComponent,
    HomeDashboardComponent,
    MainHeaderComponent,
    MainFooterComponent,
    CustomerRegistrationComponent,
    OwnerRegistrationComponent,
    RestaurantComponent,
    UpdateDishComponent,
    OrdersComponent,
    HeaderComponent,
    FooterComponent,
    RestaurantHomePageComponent,
    RestaurantFeedbacksComponent,
    AddRestaurantComponent
    
  ],
  imports: [
    BrowserModule,
   BrowserAnimationsModule,
    AuthModule,
    AppRoutingModule,
    MatSidenavModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
    MatCardModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule,
    AdminModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    AdminModule,
    BrowserAnimationsModule,
    CustomerModule

  ],
  providers: [RouterService,
    ActivateAdminGuard,
    ActivateCustomerGuard,
    ActivateRestaurantGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
