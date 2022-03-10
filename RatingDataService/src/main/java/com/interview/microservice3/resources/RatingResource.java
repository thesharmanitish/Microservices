package com.interview.microservice3.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.microservice3.models.Rating;
import com.interview.microservice3.models.UserRating;

@RestController
@RequestMapping("/api")
public class RatingResource {
	@RequestMapping("/{movieId}")
	public Rating getMovie(@PathVariable("movieId") String movieId) {
		return new Rating(movieId,8);
	}
	@RequestMapping("/users/{userId}")
	public UserRating getMovieList(@PathVariable("userId") String movieId) {
		List<Rating> ratings = Arrays.asList(new Rating("1243",8),new Rating("4321",7));
		return new UserRating(ratings);
	}
}
