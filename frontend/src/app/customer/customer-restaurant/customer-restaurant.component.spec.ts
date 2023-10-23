import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerRestaurantComponent } from './customer-restaurant.component';

describe('CustomerRestaurantComponent', () => {
  let component: CustomerRestaurantComponent;
  let fixture: ComponentFixture<CustomerRestaurantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerRestaurantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerRestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
