package step07poly.step02param;

public class Person {

	// 동물과 산책하는 기능
	// p.walk(c); 호출 시, Animal a = new Cat("TOM");
	// p.walk(d); 호출 시, Animal a = new Dog("jerry");
	// 인수를 더 상위개념(Animal)타입으로 받음
	void walk(Animal a) {
		
		// instanceof 연산자
		// A instanceof B
		
		// 인수로 전달받은 참조변수 a의 실제 인스턴스가 new Cat() 인스턴스인지?
		if(a instanceof Cat) {
			Cat c = (Cat)a; // Cat c = new Cat();과 동일!
			// instanceof 는 런타임에 구분하기 때문에,
			// 해당 코드를 돌리기 위해서 형변환해야 함
			// 전달받은 a가 new Animal()이 아닌경우, Cat타입으로 안전하게 형 변환 가능
			// 결국 Cat c = new Cat(); 이 된다는 의미
			c.play();
			
		}else if(a instanceof Dog) { // dog인지 확
			Dog d = (Dog)a;
			d.play();
		}
		
	}

	// 고양이와 산책하는 기능
//	public void walk(Cat c) {
//		c.play();
//	}
//
//	// 멍멍이와 산책하는 기능
//	public void walk(Dog d) {
//		d.play();
//	}
}
