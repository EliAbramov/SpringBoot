package com.catalogy.moviectalogservice.resources;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.catalogy.moviectalogservice.models.CatalogItem;
import com.catalogy.moviectalogservice.models.Movie;
import com.catalogy.moviectalogservice.models.Rating;
import com.catalogy.moviectalogservice.models.UserRating;

@RestController
public class MovieCatalogController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/catalog/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		
		// Get all ratings by userID
		UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);

 		
		// Get all movies and combine it with user ratings
		return userRating.getUserRatings().stream().map(rating -> {
			// For each move ID, call movie info service and get details 
		 	Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
		 	
		 	// Put the all together 
			return new CatalogItem(movie.getName(), "TTTT", rating.getRating());
				
		})
		.collect(Collectors.toList());
	}

}



