import { Dish } from './models/dish.model';

describe('Dish', () => {
  it('should create an instance', () => {
    expect(new Dish()).toBeTruthy();
  });
});
