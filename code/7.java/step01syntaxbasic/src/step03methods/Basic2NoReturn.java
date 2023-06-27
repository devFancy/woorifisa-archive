package step03methods;

// 자동 import 단축키 : command + shift + o
import java.util.Random;

public class Basic2NoReturn {

	public static void main(String[] args) {
		drinkMachine();

	}

	public static void drinkMachine() { // 함수 선언부
		// 별도의 반환타입이 없을 때는 void라는 키워드를 사용한다.

		int number = new Random().nextInt(3); // Random cannot be resolved to a type
		// import 후, Type mismatch: cannot convert from Random to int 에러 발생
		// new Random().nextInt() - int로 받기

		if (number == 0) { // 랜덤 번호가 0일 경우 스프라이트
			System.out.println("현재 스프라이트의 재고가 없습니다.");
		} else if (number == 1) { // 랜덤 번호가 1일 경우 닥터페퍼
			System.out.println("현재 닥터 페퍼의 재고가 없습니다.");
		} else if (number == 2) { // 랜덤 번호가 2일 경우 물
			System.out.println("현재 물의 재고가 없습니다.");
		}
	}
	
}
