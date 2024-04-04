/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.service.impl;
import com.grupo6.dao.ReviewDao;
import com.grupo6.domain.Review;
import com.grupo6.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author taraz
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    
    @Autowired
    private ReviewDao reviewDao;

    @Override
    public void saveReview(Review review) {
        reviewDao.save(review);
    }
}
