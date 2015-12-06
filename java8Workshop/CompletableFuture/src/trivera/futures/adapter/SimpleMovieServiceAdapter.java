package trivera.futures.adapter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import trivera.futures.MovieSearcher;
import trivera.movies.model.Movie;
import trivera.movies.service.SimpleMovieService;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to The Trivera Group, Inc., Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Group, Inc.
 *
 * Copyright c 2015 The Trivera Group, LLC. http://www.triveratech.com
 * </p>
 * 
 * @author The Trivera Tech Team.
 */
public class SimpleMovieServiceAdapter implements MovieSearcher {

	private SimpleMovieService service = new SimpleMovieService();

	private List<Movie> searchMovie(List<Movie> movies){
		return movies.stream().filter(movie -> contains(movie.getTitle(), title)).collect(Collectors.toList());
	}
	public CompletableFuture<List<Movie>> searchByTitle(final String title) {
		List<Movie> allMovies = service.getAllMovies();
		
		//List<Movie> moview = ;
		return CompletableFuture.supplyAsync( () -> searchMovie(allMovies) );
//		return CompletableFuture.supplyAsync( () -> movies.stream().filter(movie -> contains(movie.getTitle(), title)).collect(Collectors.toList()));
		//return ;
	}

	private boolean contains(String title, String contains) {

		if (title == null || contains == null)
			return false;
		String escapedFragment = Pattern.quote(contains);
		Pattern pat = Pattern.compile(escapedFragment, Pattern.CASE_INSENSITIVE);

		Matcher m = pat.matcher(title);
		return m.find();
	}
}
