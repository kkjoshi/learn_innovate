package trivera.update.streams;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TooManyListenersException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import trivera.update.streams.dao.DVDDao;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Group, Inc.
 *
 * Copyright c 2015 Trivera Technologies, LLC. http://www.triveratech.com
 * 
 * </p>
 * 
 * @author Trivera Technologies Tech Team.
 */
public class DVDService {

	/**
	 * Return the amount of DVDs in the entire stream
	 * 
	 * @return
	 */
	public long getDVDCount() {
		Stream<DVD> dvds = DVDDao.getAllDVDs();

		return dvds.count();
	}

	/**
	 * Filter out just the DVDs that were produced by the given studio
	 * 
	 * @param studio
	 *            The studio
	 * @return A list of 0 or more DVDs
	 */
	public List<DVD> getDVDsByStudio(String studio) {
		Stream<DVD> dvds = DVDDao.getAllDVDs();

		return dvds.filter(dvd -> dvd.getStudio().equals(studio)).collect(Collectors.toList());
	}

	/**
	 * Get a SORTED list of all available genres (no duplicates!)
	 * 
	 * @return A list of 0 or more genres
	 * 
	 */
	public List<String> getGenres() {
		Stream<DVD> dvds = DVDDao.getAllDVDs();

	//	return dvds.distinct().sorted( (t1,t2)->t1.getGenre().compareTo(t2.getGenre()).collect(Collectors.toList());
		return dvds.distinct().map(dvd->dvd.getGenre()).sorted().collect(Collectors.toList());
	}

	/**
	 * Get the minimum DVD price
	 * 
	 * @return a price
	 */
	public double getMinimumPrice() {
		Stream<DVD> dvds = DVDDao.getAllDVDs();

		return dvds.filter(dv -> Minimun(dv.getPrice())).collect(Collectors.toList());
	}

	/**
	 * Find a DVD that contains the given searchValue in the title
	 * 
	 * @param searchValue
	 *            the value to search for
	 * @return Optionally a DVD
	 */
	public Optional<DVD> findDVDByTitle(String searchValue) {
		Stream<DVD> dvds = DVDDao.getAllDVDs();

		return Optional.empty();
	}
}
