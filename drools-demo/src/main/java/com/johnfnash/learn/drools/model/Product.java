package com.johnfnash.learn.drools.model;

public class Product {
	
	public final static String GOLD = "GOLD";
	public final static String SILVER = "SILVER";
	
	private String type;
	
	private Integer discount = 0;

	public Product() {
	}
	
	public Product(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	
}
