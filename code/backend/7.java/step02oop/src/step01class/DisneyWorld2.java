package step01class;

public class DisneyWorld2 {

	public static void main(String[] args) {

		// 기본 생성자 - 생성자 이름은 기본 class 명과 동일해야 함
		Mouse jerry = new Mouse();

		// name 필드에 "미키마우스" 초기화
		jerry.name = "제리";
		jerry.age = 82;

		// 인스턴스를 생성할 때, 필드를 한 번에 초기화
		Mouse mickey = new Mouse(5);
		System.out.println(mickey);
		System.out.println(mickey.age);
		
		System.out.println(mickey.toString());
		System.out.println(mickey);
	}

}
