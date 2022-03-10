package com.interview.microservice3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor
public @Data class Rating {

	private String movieId;
	private int rating;
	
	
}
