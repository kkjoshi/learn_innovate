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
public class PhoneCall implements AgendaItem, DescriptionItem {
	private String name;
	private String phoneNumber;
	private Date dateTime;

	public PhoneCall(String name, String phoneNumber, String dateTime) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		try {
			this.dateTime = FORMAT.parse(dateTime);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public PhoneCall(String name, String phoneNumber, Date dateTime) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;

		this.dateTime = dateTime;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "PhoneCall [name=" + name + ", phoneNumber=" + phoneNumber
				+ ", dateTime=" + dateTime + "]";
	}
	
	@Override
	public String getDescription(){
		return DescriptionItem.super.getDescription();
	}

}
