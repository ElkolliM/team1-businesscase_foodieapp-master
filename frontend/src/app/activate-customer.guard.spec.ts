import { TestBed } from '@angular/core/testing';

import { ActivateCustomerGuard } from './activate-customer.guard';

describe('ActivateCustomerGuard', () => {
  let guard: ActivateCustomerGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ActivateCustomerGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
