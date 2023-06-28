package dev.syntax.step01exception;

public class Finally {

	public static void main(String[] args) {
		method1();
		System.out.println("method1() 수행종료, main()으로 복귀");
	}
	
	public static void method1 () {
		try {
			System.out.println("method1 호출함");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외가 발생하건 안 하건, 상관없이 수행되는 부분
			// 1로 수행됨 : finally 내부 코드를 먼저 수행하고, try 수행
			System.out.println("method1()의 finally block 호출됨");
		}
	}

}
