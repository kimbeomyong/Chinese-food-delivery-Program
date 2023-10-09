package com.market.delivery;

public abstract class Item {
	String menu;// 중식 메뉴
	String starScore;// 별점
	int cost;// 가격
	String deliveryTime;// 배달시간

	public Item() {
	}

	public Item(String menu, String starScore, int cost, String deliveryTime) {
		this.menu = menu;
		this.starScore = starScore;
		this.cost = cost;
		this.deliveryTime = deliveryTime;
	}

	public abstract String getMenu();

	public abstract String getStarScore();

	public abstract int getCost();

	public abstract String getDeliveryTime();

	public abstract void setMenu(String menu);

	public abstract void setStarScore(String starScore);

	public abstract void setCost(int cost);

	public abstract void setDeliveryTime(String deliveryTime);

}
