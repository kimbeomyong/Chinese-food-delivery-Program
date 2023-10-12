package com.market.cart;

import java.util.ArrayList;

import com.market.delivery.Delivery;

public interface CartInterface {
	//전체 메뉴 정보 목록을 출력
	void printDeliveryList(ArrayList<Delivery> delivery);

	//장바구니에 담긴 개수를 1씩 증가
	boolean isCartInDelivery(String menu);

	//cartItem에 메뉴 정보를 등록
	void insertDelivery(Delivery p);

	//장바구니 순번 num의 항목을 삭제
	void removeCart(int num);

	//장바구니의 모든 항목을 삭제
	void deleteDelivery();

}