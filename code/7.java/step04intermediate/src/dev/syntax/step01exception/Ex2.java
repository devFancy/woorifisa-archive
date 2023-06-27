package dev.syntax.step01exception;

public class Ex2 {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;

		for (int i = 0; i < 10; i++) {
			try {
				
				result = number / (int) (Math.random() * 10); // 100을 랜덤 숫자로 나눔
				
			} catch (Exception e) { // Exception e; // Exception타입의 참조변수 e 선언
				// 0으로 나누는 상황이 발생하면 내부적으로 new ArithMeticException();가 생성됨
				// Exception e = new ArithMeticException();가 수행됨
				
				System.out.println(e);
				e.printStackTrace();// Stack에 발생한 내역을 추적해서 출력
				
				// 예외가 발생할 경우, 실행될 코드를 작성하는 부분
				System.out.println("0으로 나누시면 안되죠");
			}
			System.out.println(result);
		}
	}

}
