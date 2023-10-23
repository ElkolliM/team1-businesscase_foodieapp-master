import { Component, OnInit } from '@angular/core';
import { RouterService } from 'src/app/router.service';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {

  constructor(private route:RouterService) { }

  ngOnInit(): void {
  }
  gotologin(){
    this.route.navigateToAdminHome();
}  
gotorequests(){
  this.route.navigateToRequests();
}  
gotoorders(){
  this.route.navigateToAdminOrders();
}  
gotologout(){
  this.route.navigateToDhashboard();
}  

}
