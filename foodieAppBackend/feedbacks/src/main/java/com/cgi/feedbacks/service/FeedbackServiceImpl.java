package com.cgi.feedbacks.service;

import com.cgi.feedbacks.model.Feedback;
import com.cgi.feedbacks.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {
        @Autowired
        private FeedbackRepository feedbackRepository;

        public Feedback addFeedback(Feedback Feedback) {
            feedbackRepository.save(Feedback);

            return Feedback;
        }

        public List<Feedback> getAllFeedback() {

            return feedbackRepository.findAll();
        }

    @Override
    public List<Feedback> getFeedbacksByRestaurantId(String restaurantId) {
        List<Feedback> feedbackList = feedbackRepository.findAll();
        List<Feedback> restaurantFeedbackList = new ArrayList<>();
        if(feedbackList!=null){
            for(Feedback feedback:feedbackList){
                if(feedback.getRestaurantId().equals(restaurantId))
                    restaurantFeedbackList.add(feedback);
            }
        }
        return restaurantFeedbackList;
    }

}
