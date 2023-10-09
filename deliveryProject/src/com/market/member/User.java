package com.market.member;

public class User extends Customer {

	public User(String name, int phone) {
		super(name, phone);
	}

	public User(String name, int phone, String adress) {
		super(name, phone, adress);
	}

}
