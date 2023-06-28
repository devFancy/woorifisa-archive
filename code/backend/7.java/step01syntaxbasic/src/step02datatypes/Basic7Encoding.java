package step02datatypes;

public class Basic7Encoding {

	public static void main(String[] args) {
		// 컴퓨터에서 모든 값들은 결국 0과 1인 byte로 처리되는데, 문자의 처리는?
		char firstLetter = 'A';
		System.out.println(firstLetter);

		// 저장된 문자는 메모리 상에서 결국 숫자(정수)로 변환됨
		int castedValue = firstLetter;
		System.out.println(castedValue); // 문자 A의 ASCII 코드는 65

		char sameWithCastedValue = 65;
		System.out.println(sameWithCastedValue);
	}

}
