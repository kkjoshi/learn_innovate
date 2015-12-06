package trivera.update.interfaces.agenda;

import java.util.Calendar;
import java.util.Date;

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
public class Birthday implements AgendaItem {

	private String name;
	private int day;
	private int month;

	public Birthday(String name, int day, int month) {
		super();
		this.name = name;
		this.day = day;
		this.month = month;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public Date getDateTime() {
		return getNextBirthDay();
	}

	public Date getNextBirthDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), month - 1, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		if (calendar.before(Calendar.getInstance())) {
			calendar.add(Calendar.YEAR, 1);
		}

		return calendar.getTime();
	}

	@Override
	public String toString() {
		return "Birthday [name=" + name + ", day=" + day + ", month=" + month
				+ "]";
	}

}
