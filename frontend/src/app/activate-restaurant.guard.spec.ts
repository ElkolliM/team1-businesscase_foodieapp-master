import { TestBed } from '@angular/core/testing';

import { ActivateRestaurantGuard } from './activate-restaurant.guard';

describe('ActivateRestaurantGuard', () => {
  let guard: ActivateRestaurantGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ActivateRestaurantGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
