package step05extends;

public class Animal {
	// extends Object 가 생략되어 있는 
	
	// 상속은 특성을 물려받는 것
	/**
	 * 
	 * 특성
	 * 
	 * 1. 필드
	 * 2. 메서드
	 */
	private int age;
	private String color;
	
	public Animal() {
		System.out.println("Animal() called");
	}
	
	public Animal(int age) {
		this.age = age;
		System.out.println(age);
	}
	
	public Animal(int age, String color) {
		super();
		this.age = age;
		this.color = color;
		System.out.println(age + " " + color);
	}
	
	public void sing() {
		System.out.println("동물은 어떻게 울지?..");
	}
	
}
