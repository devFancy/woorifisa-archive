package step01class;

public class DisneyWorld3 {

	public static void main(String[] args) {

		// jerry 생성, 나이 73, 이름은 제리, 주소는 뉴욕 - 기본 생성자로 생성 후 필드값을 직접 추가하는 방식
		Mouse jerry = new Mouse();
		jerry.age = 73;
		jerry.name = "제리";
		jerry.address = "뉴욕시";
		System.out.println(jerry);

		// mickey 생성 - 매개변수가 있는 생성자를 작성
		Mouse mickey = new Mouse("미키마우스", "미국", 85, "무교", "플로리다주");
		System.out.println(jerry);
		System.out.println(mickey);

		System.out.println(jerry == mickey);

		// mickey값을 출력했는데, jerry의 정보가 나왔음.
		// 참조변수 mickey에 참조변수 jerry의 주소값을 할당했기 때문에
		mickey = jerry;
		System.out.println(mickey.name);
	}

}
