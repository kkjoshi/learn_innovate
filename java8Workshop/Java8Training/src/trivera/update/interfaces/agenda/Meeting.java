package trivera.update.interfaces.agenda;

import java.text.ParseException;
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
public class Meeting implements AgendaItem {

	private String subject;
	private String location;
	private Date dateTime;

	public Meeting(String subject, String location, String dateTime) {
		super();
		this.subject = subject;
		this.location = location;
		try {
			this.dateTime = FORMAT.parse(dateTime);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public Meeting(String subject, String location, Date dateTime) {
		super();
		this.subject = subject;
		this.location = location;
		this.dateTime = dateTime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public Date getDateTime() {
		return dateTime;
	}

	@Override
	public String toString() {
		return "Meeting [subject=" + subject + ", location=" + location
				+ ", dateTime=" + dateTime + "]";
	}
	@Override
	public String getDescription(){
		return "Meeting [Description:" + subject + "dateTime" + dateTime + "Location" + location + "]";
	}
}
