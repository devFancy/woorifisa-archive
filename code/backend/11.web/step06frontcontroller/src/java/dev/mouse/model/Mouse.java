package java.dev.mouse.model;

public class Mouse {
	private int id;
	private String name;
	private String country;
	private String address;

	public Mouse(String name, String country, String address) {
		super();
		this.name = name;
		this.country = country;
		this.address = address;
	}

	public Mouse(int id, String name, String country, String address) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Mouse [id=" + id + ", name=" + name + ", country=" + country + ", address=" + address + "]";
	}

}
