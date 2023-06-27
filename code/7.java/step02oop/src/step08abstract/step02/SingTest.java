package step08abstract.step02;

public class SingTest {

	public static void main(String[] args) {
		// 다형성 : 하나의 참조타입이 다양한 형태로 변할 수 있는 성질
//		Animal a = new Cat();
//		Animal b = new Dog();
//		Animal c = new Mouse();
//		Animal d = new Animal();
//		
//		a.sing();
//		b.sing();
//		c.sing();
//		d.sing();
//		
		// Animal 타입만 받을 수 있는 길이가 4인 고정 배열 선언, 초기
		Animal[] animals = new Animal[4];
		
		animals[0] = new Cat();
		animals[1] = new Mouse(); // 추상메서드 구현부 작성이 안됐으니까!
		animals[2] = new Dog();
		animals[3] = new Dog();
		
		for(Animal i : animals) {
			i.sing();
		}

	}

}
