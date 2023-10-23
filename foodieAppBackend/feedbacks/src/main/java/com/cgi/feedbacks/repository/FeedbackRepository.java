package com.cgi.feedbacks.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.feedbacks.model.Feedback;

@Repository 
@Transactional
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
