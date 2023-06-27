package step01class;

public class DisneyWorld {

	public static void main(String[] args) {

		// 미키마우스 생성
		// 참조타입(Mouse) 참조변수 = new 참조타입();
		// 기본 생성자 - 생성자 이름은 기본 class 명과 동일해야 함
		Mouse mickey = new Mouse(); // 생성

//				System.out.println(mickey);
//				
		// name 필드에 "미키마우스" 초기화
		mickey.name = "미키마우스";
		System.out.println(mickey.name);
		System.out.println(mickey.age);
		System.out.println(mickey.address);
		mickey.sing();
	}

}
