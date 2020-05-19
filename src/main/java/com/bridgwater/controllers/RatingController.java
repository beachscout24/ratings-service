package com.bridgwater.controllers;

import com.bridgwater.models.Rating;
import com.bridgwater.respository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("/{movie}")
    public Rating getRating(@PathVariable("movie") String movie) {
        Optional<Rating> rating = ratingRepository.findByMovie(movie);
        return rating.orElse(null);
    }

    @PostMapping("/rating")
    public Integer saveRating(@RequestBody Rating rating) {
        System.out.println(rating);
        Rating newRating = ratingRepository.save(rating);
        return newRating.getId();
    }
}
