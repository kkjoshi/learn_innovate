package trivera.update.interfaces;

import java.util.List;

import trivera.update.interfaces.agenda.AgendaItem;

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
public class AgendaClient {
	public static void main(String[] args) {
		AgendaClient agendaClient = new AgendaClient();
		agendaClient.agendaClient();

	}

	public void agendaClient() {

		List<AgendaItem> agendaItems = AgendaItemDAO.getAgendaItems();
		agendaItems.sort(AgendaItem.getDateTimeComparator());
		for (AgendaItem item : agendaItems) {
			System.out.println(item.getDescription());
		}
	}

}
