package com.market.cart;

import com.market.delivery.Delivery;

public class CartItem {

	private Delivery itemDelivery;
	private String menu; // menu
	private int quantity; // 메뉴 수량
	private int totalPrice; //합계 가격

	public CartItem() {
	}

	public CartItem(Delivery itemDelivery) {
		this.itemDelivery = itemDelivery;
		this.menu = itemDelivery.getMenu();
		this.quantity = 1;
		updateTotalPrice();
	}

	public Delivery getItemDelivery() {
		return itemDelivery;
	}

	public void setitemDelivery(Delivery itemDelivery) {
		this.itemDelivery = itemDelivery;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
		this.updateTotalPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void updateTotalPrice() {
		totalPrice = this.itemDelivery.getCost() * this.quantity;
	}

}
