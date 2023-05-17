package com.aplication.controller;

import com.aplication.controller.dto.FeedbackRequestDTO;
import com.aplication.controller.dto.FeedbackResponseDTO;
import com.aplication.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/feedbacks")
    public Long createFeedback(@RequestBody FeedbackRequestDTO feedbackRequestDTO) {
        return feedbackService.save(
                feedbackRequestDTO.getMark(),
                feedbackRequestDTO.getMessage(),
                feedbackRequestDTO.getAccountId(),
                feedbackRequestDTO.getRepairId()
        );
    }

    @GetMapping("/feedbacks/{feedbackId}")
    public FeedbackResponseDTO getById(@PathVariable Long feedbackId) {
        return new FeedbackResponseDTO(feedbackService.getById(feedbackId));
    }

    @DeleteMapping("/feedbacks/{feedbackId}")
    public void deleteFeedback(@PathVariable Long feedbackId) {
        feedbackService.deleteById(feedbackId);
    }
}
