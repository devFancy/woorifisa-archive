package step02datatypes;

// 자주색으로 작성된 단어들은 키워드(keyword) - 키워드로 변수명 만들면 안됨
public class Basic {

	public static void main(String[] args) {
		// 1. 값의 타입
		
		// 1-1. 대표적인 기본(Primitive) 타입들
		// Java는 데이터 타입을 세분화하여 관리
		// 타입이름이 곧 키워드이기 때문에, 변수명처럼 식별자로 사용 불가
		int apples = 7;
		
		float eyesight = 1.5f; // Java에서 float(실수형)타입은 뒤에 f 명시
		
		char initialLetter = 'Y'; // 하나의 문자에서만 '' 사용 가능
								  // 단 한글자의 '문자' 타입, 홑따옴표만 가능
		
		String name = "yoo"; // 두 글자 이상의 문자'열'타입, 쌍따옴표만 가능
		boolean isChecked = true; // 논리형 타입(true, fasle)
		
		System.out.println(apples);
		System.out.println(eyesight);
		System.out.println(initialLetter);
		System.out.println(name);
		System.out.println(isChecked);

	}

}