package com.market.cart;

import com.market.delivery.Delivery;

public interface CartInterface {
	void printDeliveryList(Delivery[] p);

	boolean isCartInDelivery(String menu);

	void insertDelivery(Delivery p);

	void removeCart(int num);

	void deleteDelivery();
}