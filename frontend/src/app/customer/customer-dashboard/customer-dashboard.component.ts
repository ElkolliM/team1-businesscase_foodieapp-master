import { Component, OnInit } from '@angular/core';
import { RouterService } from 'src/app/router.service';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.css']
})
export class CustomerDashboardComponent implements OnInit {

  constructor(private service:RouterService) { }

  ngOnInit(): void {
  }
  gotosearch(){
    this.service.navigateTosearch();
}  
}
