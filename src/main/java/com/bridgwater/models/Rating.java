package com.bridgwater.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@ApiModel("Details of the Rating Object")
public class Rating implements Serializable {
    public Rating() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty("The id of the rating")
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty("The name of a movie")
    private String movie;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty("The rating of a movie")
    private Integer rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", movie='" + movie + '\'' +
                ", rating=" + rating +
                '}';
    }
}
