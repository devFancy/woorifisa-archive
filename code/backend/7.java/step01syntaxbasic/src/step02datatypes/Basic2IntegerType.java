package step02datatypes;

public class Basic2IntegerType {

	public static void main(String[] args) {
		// 정수형(양의 정수, 0, 음의 정수)
		
		// 정수형 타입의 종류(키워드)
		// byte, short, int(주로 사용, 사용 권장), long
		// 왼쪽부터 값을 담을 수 있는 크기가 작음
		
		byte a = 127; // 허용 범위: -128 ~ 127, 2의 8제곱(256)
		short b = -32768; // 허용범위: -32768 ~ 32767
		int c = 0; // 허용범위: 약 20억, 정수형을 사용할 때 주로 사용하는 기본 타입
//		long d = 20000000000; // 허용범위: 2의 약 63제곱
		// -> int가 정수형에서 기본 타입으로 사용되기 때문에 작성한 200억은 int로 인식되지만,
		// int의 값을 벗어났기 때문에 에러 발생 
		long d = 20000000000L;
		
		long e = 20_000_000_000L; // Java 7버전부터 리터럴 중간에 구분자 _(Underbar) 작성 가능
		
//		byte f = 128; // Type mismatch: cannot convert from int to byte
	}

}
