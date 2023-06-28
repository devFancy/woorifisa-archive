package step02datatypes;

public class Basic5BoolType {

	public static void main(String[] args) {
		boolean isLogin = true;

		boolean result = 1 == 1; // 동등연산자(==)를 활용한 1과 1은 같은지?
		System.out.println(result);

		// Q. Java에서 1은 true, 0은 false로 취급될까?
		// https://stackoverflow.com/questions/2015071/why-boolean-in-java-takes-only-true-or-false-why-not-1-or-0-also
	}

}
