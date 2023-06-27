package step07poly.step02param;

public class WalkTest {

	public static void main(String[] args) {
		Cat c = new Cat("Tom");
		Dog d = new Dog("jerry");

		// 산책할 사람 생성
		Person p = new Person();
		
		// 누구랑 산책할 것인지? walk()의 인자로 전달
		p.walk(c);
		
		p.walk(d);
	}

}
