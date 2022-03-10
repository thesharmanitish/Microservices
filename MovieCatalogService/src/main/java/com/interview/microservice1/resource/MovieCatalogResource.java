package com.interview.microservice1.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.interview.microservice1.models.CatalogItem;
import com.interview.microservice1.models.Movie;
import com.interview.microservice1.models.Rating;
import com.interview.microservice1.models.UserRating;

@RestController
@RequestMapping("api")
public class MovieCatalogResource {
	
	//get all rated movie ids
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	//merge them together
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		UserRating ratingList = restTemplate.getForObject("http://RatingData/api/users/"+userId, UserRating.class);
	
		
		
		return ratingList.getUserRatings().stream().map(rating -> {
			Movie movie =restTemplate.getForObject("http://MovieInfo/api/"+rating.getMovieId(), Movie.class);
//			Movie movie = webClientBuilder.build()
//			.get().uri("http://localhost:8091/api/"+rating.getMovieId())
//			.retrieve()
//			.bodyToMono(Movie.class)
//			.block();
			return new CatalogItem(movie.getMovieName(),"Super hero movie",rating.getRating());}).collect(Collectors.toList());
				
				
				
		// for each movie id call movie info and get details
//		return Collections.singletonList(new CatalogItem("Star Wars", "htis is eta",9));
	}

}
