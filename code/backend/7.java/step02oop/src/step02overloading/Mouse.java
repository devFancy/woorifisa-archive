package step02overloading;

public class Mouse {

	//
	int age;
	String name;

	// 메서드 명이 같지만, 파라미터 순서나 타입이 다른 경우 - 메서드 오버로딩 가능
	// 오버로딩 = 중복 정의
	// 기본 생성자 메서드
	public Mouse() {
		super();
	}

	// 나이만 지정하여 생성하는 생성자 메서드
	public Mouse(int age) {
		super();
		this.age = age;
	}

	// 이름만 지정하여 생성하는 생성자 메서드
	public Mouse(String name) {
		super();
		this.name = name;
	}

	// 나이와 이름을 지정하여 생성하는 생성자 메서드
	public Mouse(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

}
