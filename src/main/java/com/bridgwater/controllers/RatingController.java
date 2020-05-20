package com.bridgwater.controllers;

import com.bridgwater.models.Rating;
import com.bridgwater.models.RatingList;
import com.bridgwater.respository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("/ratings")
    public @ResponseBody
    RatingList getRatings() {
        Iterable<Rating> ratingIterator = ratingRepository.findAll();
        List<Rating> ratingsList = new ArrayList<>();
        ratingIterator.forEach(ratingsList::add);

        RatingList ratings = new RatingList();
        ratings.setRatings(ratingsList);
        System.out.println("RatingsList: " + ratings.getRatings());
        return ratings;
    }

    @GetMapping("/ratings/{movie}")
    public Rating getRating(@PathVariable("movie") String movie) {
        Optional<Rating> rating = ratingRepository.findByMovie(movie);
        return rating.orElse(null);
    }

    @PostMapping("/ratings/rating")
    public Integer saveRating(@RequestBody Rating rating) {
        System.out.println(rating);
        Rating newRating = ratingRepository.save(rating);
        return newRating.getId();
    }
}
