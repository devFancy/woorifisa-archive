package step08abstract.step02;

public class Mouse extends Animal{

	@Override
	// 추상 메서드, 선언부만 있고, 구현부는 작성하지 않음
	void sing() {
		System.out.println("찍찍!");
	}
	// The type Mouse must implement the inherited abstract method Animal.sing()
}