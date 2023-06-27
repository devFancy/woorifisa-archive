package dev.syntax.step01exception;

public class Ex4 {

	public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(0 / 0);
            System.out.println(4); // 실행되지 않는다.
        } catch (ArithmeticException ae) {
            if (ae instanceof ArithmeticException)
                System.out.println("ae는 ArithmeticException 클래스로 형 변환 가능 ");
            if (ae instanceof Exception)
                System.out.println("ae는 Exception 클래스로 형 변환 가능 ");
            if (ae instanceof Object)
                System.out.println("ae는 Object 클래스로 형 변환 가능 ");
        } catch (Exception e) {
            System.out.println("Exception");
        } // try-catch의 끝
        System.out.println(6);
    }// main의 끝


}