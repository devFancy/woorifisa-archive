package dev.syntax.step03generic.step01;

public class WithoutGeneric {

	public static void main(String[] args) {
		Box fruitBox = new Box();
		Apple apple1 = new Apple();

		// 박스에 사과담기
		fruitBox.setApple(apple1);
		
		// 사과 꺼내기
		System.out.println(fruitBox.getApple());
		
		// 박스에 바나나 담기
		// 제약조건 : Box 클래스 내부에
		// Banana 필드는 선언하면 안됨
		
		Banana banana1 = new Banana();
		fruitBox.setApple(banana1);
	}

}
