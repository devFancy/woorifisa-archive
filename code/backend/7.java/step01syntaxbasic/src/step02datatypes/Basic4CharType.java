package step02datatypes;

public class Basic4CharType {

	public static void main(String[] args) {
		// 4. 문자 타입

		// 한 글자의 문자만 저장할 때 사용
		char a = 'A';
//		char b = 'AB'; // Too many characters in character literal; 

		/*
		 * 문자와 문자'열'은 서로 다르다.(문자 리터럴과 문자열 리터럴 링크 참조) char : Character, 문자의 줄임표현, 홑
		 * 따옴표('')사용, 하나의 문자만 감쌀 때 사용하는 Java 키워드 String : String, 끈을 의미, 하나의 문자가 연속적으로
		 * 나열되어있다는 의미, 쌍 따옴표("") 사용, 두 개 이상의 문자를 사용할 때 쓰는 Java 키워드
		 */

		char grade = 'A';
		// String chocolate = 'ABC'; // Compile Error : Too many characters in character
		// literal,
		// -> 홑따옴표로 썼더니 문자 리터럴로 인식됨. 쌍따옴표를 사용해야함.
		String chocolate = "ABC"; // 두 개 이상의 문자, 즉 문자열을 저장하기 위한 타입 String

		// 4-3. 공백 값(Blank value), 빈 문자열(Empty string)
		String emptyString = ""; // 문자열 리터럴 ""은 아무런 값도 없이 비어있는 문자열을 작성할 수 있음.
		// char emptyChar = ''; // Compile Error : Empty character literal, 문자 리터럴은 불가능.
		char blankValue = ' '; // 공백(blank)도 하나의 값(value)으로 취급됨.

		// 4-4. 문자열 결합(String Concatenation)
		// +를 사용하면 값과 값을 연산할 수 있다. 자세한 내용은 연산자와 피연산자에서 설명.

		// 4-4-1. 문자열에서의 연산 처리
		// 다른 타입들과는 다르게 문자열 리터럴은 예외적으로 +를 활용하여 문자열 결합을 수행할 수 있다.
		String orange = "orange";
		String cookie = "cookie";

		String orangeCookie = orange + cookie; // 문자열 + 문자열의 연산결과는 문자열 타입
		String sixSigma = 6 + "sigma"; // 숫자 리터럴 + 문자열의 연산결과는 문자열 타입
		String surprise = true + "혹은 거짓"; // 논리 리터럴 + 문자열 = 문자열
		System.out.println(surprise);

		// 변수생성 없이 리터럴만으로 결과 확인
		System.out.println(5 + "5"); // 55

	}

}
