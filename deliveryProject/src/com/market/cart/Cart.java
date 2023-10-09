package com.market.cart;

import java.util.ArrayList;

import com.market.delivery.Delivery;

public class Cart implements CartInterface {
	public ArrayList<CartItem> cartItem = new ArrayList<CartItem>();
	public static int cartCount = 0;

	public Cart() {
	}

	@Override
	public void printDeliveryList(ArrayList<Delivery> deliveryList) {
		for (int i = 0; i < deliveryList.size(); i++) {
			Delivery delivery = deliveryList.get(i);
			System.out.print(delivery.getMenu() + " | ");// 메뉴
			System.out.print(delivery.getStarScore() + " | ");// 별점
			System.out.print(delivery.getIntroduction() + " | ");// 소개글
			System.out.print(delivery.getCost() + " | ");// 가격
			System.out.print(delivery.getSize() + " | ");// 1인분
			System.out.print(delivery.getDeliveryTime());// 배달시간
			System.out.println("");
		}
		
	}

	@Override
	public boolean isCartInDelivery(String menu) {
		boolean flag = false;
		for (int i = 0; i < cartItem.size(); i++) {
			if(menu.equals(cartItem.get(i).getMenu())) {
				cartItem.get(i).setQuantity(cartItem.get(i).getQuantity() + 1);
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public void insertDelivery(Delivery delivery) {
		CartItem deliveryItem = new CartItem(delivery);
		cartItem.add(deliveryItem);
		cartCount = cartItem.size();
	}

	@Override
	public void removeCart(int num) {
		cartItem.remove(num);
		cartCount = cartItem.size();
	}

	@Override
	public void deleteDelivery() {
		cartItem.clear();
		cartCount = 0;
	}

	public void printCart() {
		System.out.println("배달 목록 보기");
		System.out.println("---------------------------------------------");
		System.out.println(" 메뉴\t | 수량 \t|  합계");
		for (int i = 0; i < cartItem.size(); i++) {
			System.out.print("  " + cartItem.get(i).getMenu() + " \t| ");
			System.out.print("  " + cartItem.get(i).getQuantity() + " \t| ");
			System.out.print("  " + cartItem.get(i).getTotalPrice());
			System.out.println(" ");
		}
		System.out.println("---------------------------------------------");
	}


}
