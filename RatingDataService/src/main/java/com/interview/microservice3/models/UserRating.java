package com.interview.microservice3.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor
public @Data class UserRating {

	private List<Rating> userRatings;
	
	
}
