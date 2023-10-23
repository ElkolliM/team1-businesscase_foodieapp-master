package com.cgi.feedbacks.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Feedback {

	@Id
	private int feedbackId;
	private String restaurantId;
	private String title;
	private String  description;
	private int rating; //between 1-5 "stars" 
	
	public Feedback() {
	}

	public Feedback(int feedbackId, String restaurantId, String title, String description, int rating) {
		
		this.feedbackId = feedbackId;
		this.restaurantId = restaurantId;
		this.title = title;
		this.description = description;
		this.rating = rating;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "feedback [feedbackId=" + feedbackId + ", restaurantId=" + restaurantId + ", title=" + title
				+ ", description=" + description + ", rating=" + rating + "]";
	}
	



}
