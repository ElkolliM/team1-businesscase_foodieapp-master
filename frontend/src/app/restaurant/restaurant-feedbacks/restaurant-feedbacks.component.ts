import { Component, OnInit } from '@angular/core';

import { RouterService } from 'src/app/router.service';

@Component({
  selector: 'app-restaurant-feedbacks',
  templateUrl: './restaurant-feedbacks.component.html',
  styleUrls: ['./restaurant-feedbacks.component.css']
})
export class RestaurantFeedbacksComponent implements OnInit {
 
  constructor( private route:RouterService) { }

  ngOnInit(): void {
    
  }

}
