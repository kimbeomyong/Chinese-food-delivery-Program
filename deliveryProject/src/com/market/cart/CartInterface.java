package com.market.cart;

import java.util.ArrayList;

import com.market.delivery.Delivery;

public interface CartInterface {
	void printDeliveryList(ArrayList<Delivery> deliveryList);

	boolean isCartInDelivery(String menu);

	void insertDelivery(Delivery p);

	void removeCart(int num);

	void deleteDelivery();

}