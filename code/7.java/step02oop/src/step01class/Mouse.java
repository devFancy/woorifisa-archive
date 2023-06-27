package step01class;

public class Mouse {
	// 일반적으로 필드, 메서드 순으로 작성

	// 멤버 필드
	String name; // 쥐는 이름을 가질 수 있음
	String country; // 국적
	int age; // 나이
	String religion; // 지역
	String address; // 주소

	// 멤버 메서드
	void sing() {
		System.out.println("찍찍");
		System.out.println(name + "찍찍");
	}

	// 기본 생성자 - 생성자도 메서드(특별한 메서드)
	// 인스턴스 생성할 때 사용하는 특별한 메서드
	// new 뒤에 사용할 수 있는 메서드는 생성자만 가능
	public Mouse() {
		System.out.println("default constructor called");
	}

	// 매개변수가 있는 생성자
	public Mouse(int age) {
		System.out.println(this);
		this.age = age;
	}

	public Mouse(String name, String country, int age, String religion, String address) {
		super();
		this.name = name;
		this.country = country;
		this.age = age;
		this.religion = religion;
		this.address = address;
	}

	// Alt(option) + Shift + S
	@Override
	public String toString() {
		return "Mouse [name=" + name + ", country=" + country + ", age=" + age + ", religion=" + religion + ", address="
				+ address + "]";
	}

}
