package com.cgi.feedbacks.service;

import com.cgi.feedbacks.model.Feedback;

import java.util.List;

public interface FeedbackService {
    public Feedback addFeedback(Feedback Feedback);
    public List<Feedback> getAllFeedback();
    public List<Feedback> getFeedbacksByRestaurantId (String restaurantId);
}
