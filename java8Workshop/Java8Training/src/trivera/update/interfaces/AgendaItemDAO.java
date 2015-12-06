package trivera.update.interfaces;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import trivera.update.interfaces.agenda.AgendaItem;
import trivera.update.interfaces.agenda.Birthday;
import trivera.update.interfaces.agenda.Meeting;
import trivera.update.interfaces.agenda.PhoneCall;
import trivera.update.interfaces.agenda.StaffMeeting;

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
public class AgendaItemDAO {
	private static Random randomizer = new Random();

	public static List<AgendaItem> getAgendaItems() {
		List<AgendaItem> items = new ArrayList<>();

		items.add(new Birthday("Judith", 9, 7));
		items.add(new Birthday("John", 1, 6));

		items.add(new Meeting("Java Discussion", "Room 4.12",
				generateRandomDate()));
		items.add(new Meeting("Holiday Planning", "Room 1.22",
				generateRandomDate()));

		items.add(new StaffMeeting("Board meeting", "Room 1.22",
				generateRandomDate()));

		items.add(new PhoneCall("Dentist", "555-1234", generateRandomDate()));
		items.add(new PhoneCall("Jennifer", "555-5678", generateRandomDate()));

		return items;
	}

	private static Date generateRandomDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, randomizer.nextInt(365));
		cal.add(Calendar.HOUR_OF_DAY, randomizer.nextInt(24));
		cal.add(Calendar.MINUTE, randomizer.nextInt(60));
		return cal.getTime();
	}
}
