package trivera.update.optional.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
public class ShoppingCart {

	private String id = UUID.randomUUID().toString();
	private List<Item> items = new ArrayList<>();

	public ShoppingCart() {
		super();

	}

	public List<Item> getItems() {
		return this.items;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public double getTotalItemPrice() {
		BigDecimal total = new BigDecimal(0.0);
		for (Item item : items) {
			total = total.add(new BigDecimal(item.getPrice()));
		}
		return total.doubleValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ShoppingCart)) {
			return false;
		}
		return ((ShoppingCart) obj).id.equals(id);
	}

	public String toString() {
		return String.format("Shoppingcart (id: %s) contains %d items",
				this.id, this.items.size());

	}
}
