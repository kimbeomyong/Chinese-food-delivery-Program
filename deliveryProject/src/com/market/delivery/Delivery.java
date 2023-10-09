package com.market.delivery;

public class Delivery extends Item {
	
	private String introduction;// 메뉴 소개글
	private String size;// 1인분

	public Delivery() {
	}

	public Delivery(String menu, String starScore, int cost, String deliveryTime) {
		super(menu, starScore, cost, deliveryTime);
	}

	public Delivery(String menu, String starScore, String introduction, int cost, String size, String deliveryTime) {
		super(menu, starScore, cost, deliveryTime);
		this.size = size;
		this.introduction = introduction;
	}

	@Override
	public String getMenu() {
		return menu;
	}

	@Override
	public String getStarScore() {
		return starScore;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public String getDeliveryTime() {
		return deliveryTime;
	}

	@Override
	public void setMenu(String menu) {
		this.menu = menu;
	}

	@Override
	public void setStarScore(String starScore) {
		this.starScore = starScore;
	}

	@Override
	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	
}
