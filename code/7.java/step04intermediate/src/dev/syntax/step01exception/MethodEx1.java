package dev.syntax.step01exception;

public class MethodEx1 {
	public static void main(String[] args) {
//		method1(); // 같은 클래스내의 static멤버이므로 객체생성없이 직접 호출가능.
	} // main메서드의 끝

	
	static void method1() throws Exception{
		method2();
	} // method1의 끝

	
	static void method2() throws Exception {// throws - 호출한 쪽으로 예외를 떠넘김
		
		throw new Exception(); // throw - 예외를 생성, 던짐
		// 예외를 method2()에 던짐
		
	} // method2의 끝
}
