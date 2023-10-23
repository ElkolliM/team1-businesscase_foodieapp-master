import { Dish } from "./models/dish.model";

export class Orders {
    orderId:string;
    restaurantName:string;
    dish:Dish[];
    isnotready:boolean;
    orderPlacedAt: Date
    constructor(){
        this.orderId='';
        this.restaurantName='';
        this.dish=[];
        this.isnotready=false;
        this.orderPlacedAt= new Date();

    }
}
