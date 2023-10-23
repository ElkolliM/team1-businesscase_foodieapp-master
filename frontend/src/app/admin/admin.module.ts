import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminHeaderComponent } from './admin-header/admin-header.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminFooterComponent } from './admin-footer/admin-footer.component';
import { AdminRequestsComponent } from './admin-requests/admin-requests.component';
import { FeedbacksComponent } from './feedbacks/feedbacks.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import {MatListModule} from '@angular/material/list';
import { MatSidenavModule } from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import { AppRoutingModule } from '../app-routing.module';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './admin/admin.component';
import { AdminOrdersComponent } from './orders/admin-orders.component';




@NgModule({
  declarations: [
    AdminHeaderComponent,
    AdminDashboardComponent,
    AdminFooterComponent,
    AdminRequestsComponent,
    FeedbacksComponent,
    SidenavComponent,
    AdminComponent,
    AdminOrdersComponent
    
  ],
  imports: [
    CommonModule,
    MatListModule,
    MatSidenavModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule,
    AppRoutingModule,
    HttpClientModule
  ],
  exports: [
    AdminDashboardComponent,
    AdminHeaderComponent,
    AdminFooterComponent,
    AdminRequestsComponent,
    FeedbacksComponent,
    SidenavComponent,
    AdminComponent
  ]
})
export class AdminModule { }
