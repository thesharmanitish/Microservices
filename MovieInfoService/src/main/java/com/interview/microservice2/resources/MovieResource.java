package com.interview.microservice2.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.microservice2.models.Movie;

@RestController
@RequestMapping("/api")
public class MovieResource {
	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		return new Movie(movieId,"Movie name");
	}
	
}
