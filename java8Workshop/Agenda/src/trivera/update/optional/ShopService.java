package trivera.update.optional;

import java.util.Collection;
import java.util.Optional;

import trivera.update.optional.domain.Customer;
import trivera.update.optional.domain.Shop;
import trivera.update.optional.domain.ShoppingCart;
import trivera.update.optional.domain.dao.ShopFactory;

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
public class ShopService {

	private Shop shop = ShopFactory.initShop();

	/**
	 * Calculate the subtotal of all the items in the shoppingcart of the given
	 * customer
	 * 
	 * @param customerID
	 *            The customer ID
	 * @return The subtotal
	 */
	public double getSubTotalOfCustomer(int customerID) {
		// Get the customer from the shop and the get the ShoppingCart from this
		// customer

		// Use the getTotalItemPrice method of the ShoppingCart the obtain the
		// total price
		// When the customer does not have a cart, return 0.0
		Optional<Customer> optCustomer = shop.getCustomer(customerID);
		Optional<ShoppingCart> optShpCart = optCustomer.flatMap(Customer::getShoppingCart);
		if(optShpCart.isPresent()){
			return optShpCart.get().getTotalItemPrice();
		}
		else
			return 0.0;
	}

	/**
	 * Get a Customer from the shop, when the customer does not exist, return a
	 * new one
	 * 
	 * @param customerID
	 *            The customer ID
	 * @return A Existing of new Customer instance
	 */
	public Customer getCustomer(int customerID) {
		// Get the ShoppingCart from the customer or create a new one
		Optional<Customer> optCustomer = shop.getCustomer(customerID);
		if(optCustomer.isPresent()){
			return optCustomer.get();
		}
		else
			return shop.addCustomer("new customer 1");
	}

	/**
	 * Checkout the customer. Process the content of the cart and remove the
	 * cart from the customer
	 * 
	 * @param customer
	 *            The customer instance
	 */
	public void checkOutCustomer(Customer customer) {
		// Get the shoppingcart of this customer

		// When a cart is present, use the static processCartPayment method to
		// 'checkout'
		// andThen remove the cart from the customer (using the
		// removeShoppingCart method on the Customer class
		Optional<ShoppingCart> optShpCart = customer.getShoppingCart()
											.map(ShopService::processCartPayment)

	}

	private static void processCartPayment(ShoppingCart cart) {
		String msg = String.format(
				"ShopService: Processing payment of cart (%6.2f)",
				cart.getTotalItemPrice());
		System.out.println(msg);
	}

	public Collection<Customer> getCustomers() {
		return shop.getCustomers();
	}
}
