package com.bridgwater.respository;

import com.bridgwater.models.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer> {
    Optional<Rating> findByMovie(String movie);
}
