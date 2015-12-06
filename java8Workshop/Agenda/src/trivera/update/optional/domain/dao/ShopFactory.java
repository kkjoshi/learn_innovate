package trivera.update.optional.domain.dao;

import trivera.update.optional.domain.Customer;
import trivera.update.optional.domain.Shop;
import trivera.update.optional.domain.ShoppingCart;

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
public class ShopFactory {

	public static Shop initShop() {

		Shop shop = new Shop();

		Customer customer1 = shop.addCustomer("John");
		ShoppingCart cart1 = new ShoppingCart();
		customer1.setShoppingCart(cart1);
		cart1.addItem(ItemDAO.getItem(103));
		cart1.addItem(ItemDAO.getItem(105));

		Customer customer2 = shop.addCustomer("Jennifer");
		ShoppingCart cart2 = new ShoppingCart();
		customer2.setShoppingCart(cart2);
		cart2.addItem(ItemDAO.getItem(114));

		Customer customer3 = shop.addCustomer("Kim");
		ShoppingCart cart3 = new ShoppingCart();
		customer3.setShoppingCart(cart3);
		cart3.addItem(ItemDAO.getItem(100));
		cart3.addItem(ItemDAO.getItem(102));
		cart3.addItem(ItemDAO.getItem(110));
		cart3.addItem(ItemDAO.getItem(110));

		Customer customer4 = shop.addCustomer("Cindy");

		Customer customer5 = shop.addCustomer("Dan");
		ShoppingCart cart5 = new ShoppingCart();
		customer5.setShoppingCart(cart5);
		cart5.addItem(ItemDAO.getItem(112));
		cart5.addItem(ItemDAO.getItem(106));
		cart5.addItem(ItemDAO.getItem(103));

		Customer customer6 = shop.addCustomer("Tresa");
		ShoppingCart cart6 = new ShoppingCart();
		customer6.setShoppingCart(cart6);
		cart6.addItem(ItemDAO.getItem(101));
		cart6.addItem(ItemDAO.getItem(107));

		Customer customer7 = shop.addCustomer("Peter");
		ShoppingCart cart7 = new ShoppingCart();
		customer7.setShoppingCart(cart7);
		cart7.addItem(ItemDAO.getItem(113));
		cart7.addItem(ItemDAO.getItem(108));
		cart7.addItem(ItemDAO.getItem(104));
		cart7.addItem(ItemDAO.getItem(109));

		Customer customer8 = shop.addCustomer("Diane");
		return shop;
	}

}
