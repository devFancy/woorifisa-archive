package step10localglobal;

public class Animal {
	int age; // 전역변수 중 인스턴스 변수 -> 인스턴스를 생성하지 않으면 접근 불가
	static String kind; // 전역 변수 중 static(정적, 클래스) 변수
	
	// 인스턴스 메서드
	void instanceMethod() {
		System.out.println(age);
		/*
		 * 인스턴스 메서드가 호출된다는 것은 인스턴스가 이미 생성되었다는 것이기 때문에,
		 * 인스턴스 변수인 age 역시 접근(사용) 가능
		 * */
		System.out.println(kind); // class가 먼저 올라가기 때문에, static 변수인 kind부터 
		// static은 항상 인스턴스보다 메모리(method area)에 먼저 생기기 때문에 가능
		
		staticMethod(); // static method이기 때문에 error X
	}
	
	static void staticMethod() {
//		System.out.println(age); // age가 인스턴스 변수이기 때문에, 컴파일 error
		System.out.println(kind);
		
		// 인스턴스를 먼저 생성했기 때문에 30번 시점에서는 가능
	}
}
