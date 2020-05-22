package com.bridgwater.controllers;

import com.bridgwater.models.Rating;
import com.bridgwater.models.RatingList;
import com.bridgwater.respository.RatingRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("/ratings")
    @ApiOperation(value = "Returns a list of ratings",
            response = RatingList.class)
    public @ResponseBody
    ResponseEntity<RatingList> getRatings() {
        Iterable<Rating> ratingIterator = ratingRepository.findAll();
        List<Rating> ratingsList = new ArrayList<>();
        ratingIterator.forEach(ratingsList::add);

        RatingList ratings = new RatingList();
        ratings.setRatings(ratingsList);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/ratings/{movie}")
    @ApiOperation(value = "Finds a rating for a given movie",
            notes = "Provide a movie name to look up a specific rating",
            response = Rating.class)
    public ResponseEntity<Rating> getRating(@PathVariable("movie") String movie) {
        Optional<Rating> rating = ratingRepository.findByMovie(movie);
        return ResponseEntity.ok(rating.orElse(null));
    }

    @PostMapping("/ratings/rating")
    @ApiOperation(value = "Saves a rating by providing a rating object",
            notes = "Provide a Rating object for a Movie to be saved",
            response = Integer.class)
    public ResponseEntity<Integer> saveRating(@RequestBody Rating rating) {
        Rating newRating = ratingRepository.save(rating);
        return ResponseEntity.ok(newRating.getId());
    }
}
