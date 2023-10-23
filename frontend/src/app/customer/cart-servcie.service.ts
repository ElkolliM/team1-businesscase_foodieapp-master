import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Dish } from '../models/dish.model';

@Injectable({
  providedIn: 'root'
})
export class CartServcieService {

  

  public cartItemList : any =[]
  public dishList = new BehaviorSubject<any>([]);
  public search = new BehaviorSubject<string>("");
  
    constructor() { }
    getProducts(){
      return this.dishList.asObservable();
    }
  
    setProduct(dish : any){
      this.cartItemList.push(...dish);
      this.dishList.next(dish);
    }
    addtoCart(dish : Dish){
      this.cartItemList.push(dish);
      this.dishList.next(this.cartItemList);
      this.getTotalPrice();
      console.log(this.cartItemList)
    }
    getTotalPrice() : number{
      let grandTotal = 0;
      this.cartItemList.map((dish:Dish)=>{
        grandTotal += dish.dishPrice;
      })
      return grandTotal;
    }
    removeCartItem(dish: any){
      this.cartItemList.map((a:any, index:any)=>{
        if(dish.id=== a.id){
          this.cartItemList.splice(index,1);
        }
      })
      this.dishList.next(this.cartItemList);
    }
    removeAllCart(){
      this.cartItemList = []
      this.dishList.next(this.cartItemList);
    }
  }