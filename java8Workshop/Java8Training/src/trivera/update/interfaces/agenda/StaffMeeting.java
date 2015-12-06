package trivera.update.interfaces.agenda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class StaffMeeting extends Meeting {

	private List<String> participants = new ArrayList<>();

	public StaffMeeting(String subject, String location, Date dateTime) {
		super(subject, location, dateTime);

	}

	public List<String> getParticipants() {
		return participants;
	}

	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return super.toString() + " StaffMeeting [participants=" + participants
				+ "]";
	}

}
