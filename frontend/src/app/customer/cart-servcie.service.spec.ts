import { TestBed } from '@angular/core/testing';

import { CartServcieService } from './cart-servcie.service';

describe('CartServcieService', () => {
  let service: CartServcieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CartServcieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
