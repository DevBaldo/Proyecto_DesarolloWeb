/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.controller;
import com.grupo6.domain.Implemento;
import com.grupo6.domain.Review;
import com.grupo6.service.ImplementoService;
import com.grupo6.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author taraz
 */
@Controller
public class ReviewController {

    @Autowired
    private ImplementoService implementoService;

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/implementos/{id}/reviews")
    public String addReview(@PathVariable Long id, @ModelAttribute Review review) {
        Implemento implemento = implementoService.getImplementoById(id);
        
        review.setImplemento(implemento);
        
        reviewService.saveReview(review);
        
        return "redirect:/implementos/" + id;
    }
}
