package com.cgi.dish.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Dish {


        @Id
        private String dishId;
        private String dishName;
        private int dishPrice;
        private String dishType;
        private String dishDetails;
        private String dishImage;
		public String getDishId() {
			return dishId;
		}
		
		public Dish() {
		
		}

		public Dish(String dishId, String dishName, int dishPrice, String dishDetails, String dishImage, String dishType) {
			
			this.dishId = dishId;
			this.dishName = dishName;
			this.dishPrice = dishPrice;
			this.dishDetails = dishDetails;
			this.dishImage = dishImage;
			this.dishType=dishType;
		}

		public void setDishId(String dishId) {
			this.dishId = dishId;
		}
		public String getDishName() {
			return dishName;
		}
		public void setDishName(String dishName) {
			this.dishName = dishName;
		}
		public int getDishPrice() {
			return dishPrice;
		}
		public void setDishPrice(int dishPrice) {
			this.dishPrice = dishPrice;
		}
		public String getDishDetails() {
			return dishDetails;
		}
		public void setDishDetails(String dishDetails) {
			this.dishDetails = dishDetails;
		}
		public String getDishImage() {
			return dishImage;
		}
		public void setDishImage(String dishImage) {
			this.dishImage = dishImage;
		}

		public String getDishType() {
			return dishType;
		}

		public void setDishType(String dishType) {
			this.dishType = dishType;
		}

		@Override
		public String toString() {
			return "Dish [dishId=" + dishId + ", dishName=" + dishName + ", dishPrice=" + dishPrice + ", dishType="
					+ dishType + ", dishDetails=" + dishDetails + ", dishImage=" + dishImage + "]";
		}

		
        
}
