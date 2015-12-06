package trivera.futures.adapter;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import trivera.futures.MovieSearcher;
import trivera.movies.model.Movie;
import trivera.movies.service.MovieSearchService;

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
public class MovieSearchServiceAdapter implements MovieSearcher {

	private MovieSearchService service = new MovieSearchService();

	public CompletableFuture<List<Movie>> searchByTitle(final String title) {
		return CompletableFuture.supplyAsync(() -> service.searchByTitle(title));
	}
}
