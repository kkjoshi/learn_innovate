package trivera.futures;

import java.util.ArrayList;
import java.util.List;

import trivera.futures.adapter.CallbackMovieServiceAdapter;
import trivera.futures.adapter.MovieSearchServiceAdapter;
import trivera.futures.adapter.SimpleMovieServiceAdapter;
import trivera.movies.model.Movie;

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
public class ApplicationClient {

	public List<Movie> search(String title) {

		List<Movie> moviesFound = new ArrayList<>();

		MovieSearcher searcher1 = new MovieSearchServiceAdapter();
		List<Movie> search1 = searcher1.searchByTitle(title);
		moviesFound.addAll(search1);

		MovieSearcher searcher2 = new SimpleMovieServiceAdapter();
		List<Movie> search2 = searcher2.searchByTitle(title);
		moviesFound.addAll(search2);

		MovieSearcher searcher3 = new CallbackMovieServiceAdapter();
		List<Movie> search3 = searcher3.searchByTitle(title);
		moviesFound.addAll(search3);

		return moviesFound;

	}

	public static void main(String[] args) {
		ApplicationClient client = new ApplicationClient();

		long start = System.currentTimeMillis();

		String title = "Mad Max";
		List<Movie> searchResults = client.search(title);

		long end = System.currentTimeMillis();

		System.out.printf("%d movies found for title %s\n", searchResults.size(), title);
		for (Movie movie : searchResults) {

			System.out.printf("ID: %s  Title:%s Price:.%2f\n", movie.getId(), movie.getTitle(), movie.getPrice());
		}
		System.out.printf("Execution time %d ms\n", (end - start));
	}

}
