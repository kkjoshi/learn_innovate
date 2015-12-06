package trivera.update.optional.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
public class Shop {

	private int lastGivenCustomerId = 1000;
	private Map<Integer, Customer> customers = new HashMap<>();

	public Shop() {

	}

	public Customer addCustomer(String name) {
		int newCustomerID = ++lastGivenCustomerId;
		Customer customer = new Customer(newCustomerID, name);
		this.customers.put(newCustomerID, customer);
		return customer;
	}

	public Optional<Customer> getCustomer(int id) {
		Customer customer = customers.get(id);
		return Optional.ofNullable(customer);
	}

	public Collection<Customer> getCustomers() {
		return Collections.unmodifiableCollection(customers.values());
	}
}
