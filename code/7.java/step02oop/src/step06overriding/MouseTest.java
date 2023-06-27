package step06overriding;

public class MouseTest {

	public static void main(String[] args) {
		Animal anAnimal = new Animal();

		anAnimal.name = "어떤 동물";
//		anAnimal.showName();

		Mouse jerry = new Mouse();
		jerry.name = "제리";
		jerry.address = "하와이";

//		jerry.showName();

//		jerry.showName("톰");

		// 다형성(多形性), polymorphism
		long a = 5; // a는 long타입, 5는 정수형 기본타입 int
		Animal mickey = new Mouse();

		mickey.name = "미키마우스"; // Animal이 가진 필드이기 때문에 가능
//		mickey.address = "롯데타워"; // 상위 타입의 참조변수(Animal mickey)로 하위 타입의 멤버 참조 불가

		// 상위 타입의 참조변수지만(mickey), 오버라이딩 되었기 때문에 예외적으로 Mouse의 오버라이딩된 메서드가 호출됨
		mickey.showName();

//		mickey.showAddr(); 
		// 상위 타입의 참조변수(Animal mickey)로 하위 타입의 멤버 사용 불가
	}

}
