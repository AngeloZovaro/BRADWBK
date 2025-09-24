package br.edu.ifsp.graphql.service;

import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    public Review createReview(ReviewInput reviewInput) {
        return new Review(reviewInput.getStars(), reviewInput.getCommentary());
    }
}