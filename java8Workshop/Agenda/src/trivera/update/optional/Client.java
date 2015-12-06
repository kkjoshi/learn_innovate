package trivera.update.optional;

import java.util.Collection;

import trivera.update.optional.domain.Customer;

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
public class Client {

	public static void main(String[] args) {
		Client client = new Client();
		client.test();

	}

	public void test() {

		ShopService shopService = new ShopService();
		Collection<Customer> customers = shopService.getCustomers();
		for (Customer customer : customers) {
			testCustomer(shopService, customer);
		}

		System.out.println("------------------------------");

		double subTotal = shopService.getSubTotalOfCustomer(999);
		System.out.println("Subtotal of nonexistent customer " + subTotal);

		System.out.println("------------------------------");
		Customer customer = shopService.getCustomer(998);
		System.out.println("New Customer: " + customer);
	}

	private void testCustomer(ShopService shopService, Customer customer) {
		System.out.println("------------------------------");
		System.out.println("Customer: " + customer.getName());

		int customerID = customer.getId();
		double subTotalOfCustomer = shopService
				.getSubTotalOfCustomer(customerID);

		System.out.println(String
				.format("SubTotal : %6.2f", subTotalOfCustomer));

		System.out.println("Going to Checkout");
		shopService.checkOutCustomer(customer);
	}
}
