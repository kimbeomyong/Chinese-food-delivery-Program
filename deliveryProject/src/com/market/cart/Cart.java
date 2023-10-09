package com.market.cart;

import com.market.delivery.Delivery;

public class Cart implements CartInterface {
	static final int NUM_MENU = 3;
	public CartItem[] cartItem = new CartItem[NUM_MENU];
	public static int cartCount;

	public Cart() {
	}

	@Override
	public void printDeliveryList(Delivery[] deliveryList) {
		for (int i = 0; i < deliveryList.length; i++) {
			System.out.print(deliveryList[i].getMenu() + " | ");// 메뉴
			System.out.print(deliveryList[i].getStarScore() + " | ");// 별점
			System.out.print(deliveryList[i].getIntroduction() + " | ");// 소개글
			System.out.print(deliveryList[i].getCost() + " | ");// 가격
			System.out.print(deliveryList[i].getSize() + " | ");// 1인분
			System.out.print(deliveryList[i].getDeliveryTime() + " | ");// 배달시간
			System.out.println("");
		}

	}

	@Override
	public boolean isCartInDelivery(String menu) {
		boolean flag = false;
		for (int i = 0; i < cartCount; i++) {
			if (menu == cartItem[i].getMenu()) {
				cartItem[i].setQuantity(cartItem[i].getQuantity() + 1);
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public void insertDelivery(Delivery delivery) {
		cartItem[cartCount++] = new CartItem(delivery);
	}

	@Override
	public void removeCart(int num) {
		CartItem[] cartItem = new CartItem[NUM_MENU];
		int number = 0;
		for (int i = 0; i < cartCount; i++)
			if (num != i)
				cartItem[number++] = cartItem[i];

		cartCount = number;
		cartItem = cartItem;

	}

	@Override
	public void deleteDelivery() {
		CartItem[] cartItem = new CartItem[NUM_MENU];
		cartCount = 0;
	}

	public void printCart() {
		System.out.println("배달 목록 보기");
		System.out.println("---------------------------------------------");
		System.out.println(" 메뉴\t| 수량 \t|  합계");
		for (int i = 0; i < cartCount; i++) {
			System.out.print("  " + cartItem[i].getMenu() + " \t| ");
			System.out.print("  " + cartItem[i].getQuantity() + " \t| ");
			System.out.print("  " + cartItem[i].getTotalPrice());
			System.out.println(" ");
		}
		System.out.println("---------------------------------------------");
	}
}
