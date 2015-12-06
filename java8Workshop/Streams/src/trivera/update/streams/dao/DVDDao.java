package trivera.update.streams.dao;

import java.util.stream.Stream;

import trivera.dvd.data.DVDDataSource;
import trivera.update.streams.DVD;

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
public class DVDDao {

	public static Stream<DVD> getAllDVDs() {
		return DVDDataSource.getInstance().getDVDs(DVD.class).stream();
	}
}
