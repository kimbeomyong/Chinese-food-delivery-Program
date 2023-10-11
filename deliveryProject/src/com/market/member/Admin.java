package com.market.member;

public class Admin extends Customer {
	private String id = "1";
	private String password = "1";
	
	//bill 출력할때 사용
	public Admin(String name, int phone) {
		super(name, phone);
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

}
