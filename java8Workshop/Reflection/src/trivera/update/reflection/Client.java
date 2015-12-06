package trivera.update.reflection;

import java.time.LocalDate;

import trivera.update.reflection.domain.TravelService;

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
public class Client {
	public static void main(String[] args) {
		Client client = new Client();
		client.test();

	}

	public void test() {

		TravelService travelService = TravelServiceFactory.getInstance();

		travelService.addBooking("AMS", LocalDate.now());
		travelService.removeBooking(1l);
	}
}