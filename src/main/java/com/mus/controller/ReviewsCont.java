package com.mus.controller;

import com.mus.controller.main.Attributes;
import com.mus.model.Reviews;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reviews")
public class ReviewsCont extends Attributes {
    @GetMapping
    public String reviews(Model model) {
        AddAttributesReviews(model);
        return "reviews";
    }

    @PostMapping("/add")
    public String reviewAdd(@RequestParam String text) {
        reviewsRepo.save(new Reviews(text, DateNow(), getUser()));
        return "redirect:/reviews";
    }
}
