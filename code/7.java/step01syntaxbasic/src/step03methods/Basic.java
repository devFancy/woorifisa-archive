package step03methods;

public class Basic {

	public static void main(String[] args) {
		// 1. Java에서는 함수 대신 메서드라는 용어 사용

		// 모든 메서드는 class 내부에 작성
		/*
		 * Basic이라는 클래스에는 1개의 메서드가 존재
		 */
		String result = drinkMachine(2);
		System.out.println(result);
	}

	// Java에서 메서드는 메서드명 앞에 반환 타입을 명시

	// 반환 타입이 String인 drinkMachine() 메서드
	// number라는 지역 변수는 타입이 int
	public static String drinkMachine(int number) { // 메서드 선언부
		String drink;

		if (number == 1) {
			drink = "제로 콜라";
		} else if (number == 2) {
			drink = "스프라이트";
		} else {
			return "환타";
		}

		return drink; // drink 변수의 반환 타입은 String
	}

}
