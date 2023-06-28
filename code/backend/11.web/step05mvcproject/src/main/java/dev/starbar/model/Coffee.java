package dev.starbar.model;

public class Coffee {
	private int id;
	private String name;
	private String size;
	private int price;
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSize() {
		return size;
	}
	public int getPrice() {
		return price;
	}
	
	
	public Coffee(int id, String name, String size, int price) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.price = price;
	}
	
	public Coffee(String name, String size, int price) {
		this.name = name;
		this.size = size;
		this.price = price;
	}
	
}
