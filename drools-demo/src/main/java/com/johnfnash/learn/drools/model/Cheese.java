package com.johnfnash.learn.drools.model;

public class Cheese {

	private String type;
	
	private Integer price;
	
	private String age;
	
	public Cheese() {
	}

	public Cheese(String type, Integer price, String age) {
		this.type = type;
		this.price = price;
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cheese [type=" + type + ", price=" + price + ", age=" + age + "]";
	}
	
}
