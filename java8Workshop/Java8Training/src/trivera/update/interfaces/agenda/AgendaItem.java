package trivera.update.interfaces.agenda;
import trivera.update.interfaces.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
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
public interface AgendaItem {
	public final static SimpleDateFormat FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm");

	abstract Date getDateTime();
	
	default String getDescription(){
		return "Description @" + getDateTime().toString();
	}
	static Comparator<AgendaItem> getDateTimeComparator(){
	//	return (AgendaItem t1, AgendaItem t2) -> { 
		//	return t1.getDateTime().compareTo(t2.getDateTime());
	//	};
		return (t1, t2) -> t1.getDateTime().compareTo(t2.getDateTime());
		};
	}

}	
