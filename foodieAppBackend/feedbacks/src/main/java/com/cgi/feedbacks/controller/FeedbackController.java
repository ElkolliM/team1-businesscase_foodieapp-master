package com.cgi.feedbacks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cgi.feedbacks.model.Feedback;
import com.cgi.feedbacks.service.FeedbackService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")

public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@RequestMapping(value = "/feedbacks",method = RequestMethod.GET)
	public ResponseEntity<?> getAllFeedbackHandler() {
		List<Feedback> feedback = feedbackService.getAllFeedback();
		return new ResponseEntity<List<Feedback>>(feedback,HttpStatus.OK); 
	}
	@PostMapping(value = "/feedbacks")
	public ResponseEntity<?> addFeedbackHandler( @RequestBody Feedback feedback){
		
		ResponseEntity<?> responseEntity;		
			Feedback postedFeedback = feedbackService.addFeedback(feedback);
			responseEntity = new ResponseEntity<Feedback>(postedFeedback,HttpStatus.CREATED);
		
		return responseEntity;
	}

	@GetMapping("/feedbacks/{restaurantId}")
	public ResponseEntity<?>getFeedbacksByRestaurantIdHandler(@PathVariable("restaurantId") String restaurantId) {
		try {
			return new ResponseEntity<>(feedbackService.getFeedbacksByRestaurantId(restaurantId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
