import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { AdminRequestsComponent } from './admin/admin-requests/admin-requests.component';
import { FeedbacksComponent } from './admin/feedbacks/feedbacks.component';


// const routes: Routes = [
  // {path:'',redirectTo:'adminHome', pathMatch:'full'},
//   {path: 'adminHome', component:AdminDashboardComponent},
//   {path: 'requests',component:AdminRequestsComponent},
//   {path: 'orderStatus', component:OrdersComponent},
//   {path: 'feedbacks/:restaurantId', component:FeedbacksComponent},
// ];

@NgModule({
   imports: [],
  //  RouterModule.forRoot(routes)
  exports: [RouterModule]
})
export class AppRoutingModule { }
