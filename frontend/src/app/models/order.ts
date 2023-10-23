import { Time } from "@angular/common";
import {Dish} from './dish.model'

export class Order{
orderId:string;
restaurantName: string;
food: Array <Dish>;
isReady: Boolean;
orderPlacedAT : Time;
}
