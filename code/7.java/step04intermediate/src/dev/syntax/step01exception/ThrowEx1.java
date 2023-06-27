package dev.syntax.step01exception;

public class ThrowEx1 {
	public static void main(String[] args) {
		try {
			Exception e = new Exception("고의로 발생시킴");
			throw e; // 예외를 발생시킴
			// throw new Exception("고의로 발생시킴"); 한 문장으로 가능.
		} catch (Exception e) {
			System.out.println("예외 메시지 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 정상 종료.");
	}
}
