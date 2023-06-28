package dev.syntax.step01exception;

public class Ex1 {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for (int i = 0; i < 10; i++) {
			result = number / (int)(Math.random() * 10); // 100을 랜덤 숫자로 나눔
			System.out.println(result);
		}
	}

}
