package com.sonth.reviewms.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Review review, Long companyId);
    Review getReviewById(Long reviewId);
    boolean updateReview(Review review, Long reviewId);
    boolean deleteReviewById(Long reviewId);
}
