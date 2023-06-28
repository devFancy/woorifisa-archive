package step05extends;

// Mouse 는 Animal이다.
public class Mouse extends Animal {
	
	private String address;

	public Mouse() {
		super(); // 메서드
		System.out.println("Mouse() called");

		// super = Animal
		// => Animal(); : 부모 생성자 생성
	}
	
	public Mouse(int age) {
		super(age); // age는 부모 요소이므로
	}
	
	public Mouse(int age, String color) {
		super(age, color);
	}

	public Mouse(int age, String color, String address) {
		// age, color는 상위 요소에서
		super(age, color);
		
		// address는 현재 요소에서
		this.address = address;
	}

	// 부모 요소 -> 새롭게 재정의 : 오버라이딩
	// @ : 어노테이션
	@Override
	public void sing() {
		System.out.println("찍찍!");
	}

	// toString 은 Object 의 메서드를 다시 오버라이딩 한 것
	@Override
	public String toString() {
		return "Mouse [address=" + address + "]";
	}
	
}
