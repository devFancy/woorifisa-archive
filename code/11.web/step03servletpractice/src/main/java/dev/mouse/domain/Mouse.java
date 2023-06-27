package dev.mouse.domain;


public class Mouse {
	int id;
	String name;
	String country;
	String address;
	
	// 생성자
	public Mouse(int id, String name, String country, String address) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.address = address;
	}
	
	// 생성자
	public Mouse(String name, String country, String address) {
		super();
		this.name = name;
		this.country = country;
		this.address = address;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
