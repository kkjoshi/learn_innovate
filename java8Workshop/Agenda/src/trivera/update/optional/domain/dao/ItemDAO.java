package trivera.update.optional.domain.dao;

import java.util.HashMap;
import java.util.Map;

import trivera.update.optional.domain.Item;

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
public class ItemDAO {

	private static Map<Integer, Item> items = new HashMap<>();

	static {
		items.put(100, new Item(100, "Man on Fire DVD", 5.25, true));
		items.put(101, new Item(101, "Bob the Builder On Site VIDEO", 9.99,
				true));
		items.put(102, new Item(102, "Magnesium Fire Starter", 5.54, true));
		items.put(103, new Item(103, "Knife Sharpener", 12.95, false));
		items.put(104, new Item(104, "Furry Friends Plush Stuffed Animal Toy",
				28.41, true));
		items.put(105, new Item(105, "Rotating Ipad2 Case", 8.99, false));
		items.put(106, new Item(106, "Zippo Lighter Fluid", 8.82, true));
		items.put(107, new Item(107,
				"Mary Poppins: 50th Anniversary Edition DVD", 18.99, false));
		items.put(108, new Item(108, "Ice Ball Mold", 13.99, true));
		items.put(109, new Item(109, "Wooden Pet Gate", 58.59, true));
		items.put(110, new Item(110, "Portable Outdoor Solar Charger", 38.99,
				true));
		items.put(111, new Item(111, "Family-Sized Desktop USB Charger", 25.99,
				true));
		items.put(112, new Item(112, "Osbert, the Garden Gnome", 23.05, false));
		items.put(113, new Item(113,
				"Pondering Sylvester, the Cynical Gnome Troll Statue", 62.90,
				true));
		items.put(114, new Item(114, "Rapidfire Chimney Starter", 14.99, true));
	}

	public static Item getItem(int id) {
		return items.get(id);
	}
}
