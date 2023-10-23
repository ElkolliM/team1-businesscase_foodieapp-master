import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Feedback } from 'src/app/models/Feedback';
import { Restaurant } from 'src/app/restaurant.model';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-feedbacks',
  templateUrl: './feedbacks.component.html',
  styleUrls: ['./feedbacks.component.css']
})
export class FeedbacksComponent implements OnInit {

  feedbackList:Feedback[];
  restaurantName?:string;
  constructor(private activatedRoute :ActivatedRoute, private adminService: AdminService) { }

  ngOnInit(): void {
this.activatedRoute.params.subscribe(p=>{
  this.adminService.getRestaurant(p['restaurantId']).subscribe(data =>
    {
      this.restaurantName = data.restaurantName;
    })

this.adminService.getFeedbacks(p['restaurantId']).subscribe(data =>{
  this.feedbackList = data;
  
})
});
  }
}
