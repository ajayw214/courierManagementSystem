package com.app.service;

import java.util.List;

import com.app.dto.FeedbackDTO;
import com.app.entities.Feedback;

public interface IFeedbackService {
	List<FeedbackDTO> getAllFeedbacks();
	//FeedbackEntity insertFeedbackDetails(String message, long id);
	Feedback insertFeedbackDetails(long customerId, String message);
}
