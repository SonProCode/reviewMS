package com.sonth.reviewms.review.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sonth.reviewms.review.Review;
import com.sonth.reviewms.review.ReviewRepository;
import com.sonth.reviewms.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }  

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Review review, Long companyId) {
        if (companyId != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }
    
    @Override
    public boolean updateReview(Review review, Long reviewId) {
        Review existingReview = reviewRepository.findById(reviewId).orElse(null);
        if (existingReview != null) {
            existingReview.setTitle(review.getTitle());
            existingReview.setRating(review.getRating());
            existingReview.setDescription(review.getDescription());
            existingReview.setCompanyId(review.getCompanyId());
            reviewRepository.save(existingReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long reviewId) {    
        Review existingReview = reviewRepository.findById(reviewId).orElse(null);
        if (existingReview != null) {
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
