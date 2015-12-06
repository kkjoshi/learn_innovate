package trivera.update.optional.domain;

import java.util.Optional;

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
public class Customer {

	private int id;
	private String name;
	private Optional<ShoppingCart> cart = Optional.empty();

	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Optional<ShoppingCart> getShoppingCart() {
		return cart;
	}

	public void setShoppingCart(ShoppingCart cart) {
		this.cart = Optional.of(cart);
	}

	public void removeShoppingCart(ShoppingCart cart) {
		if (this.cart.get().equals(cart)) {
			this.cart = Optional.empty();
		}
	}

	public String toString() {
		return String.format("Customer '%s' (id: %s)", name, id);
	}
}
