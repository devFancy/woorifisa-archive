package dev.syntax.step03generic.step01;

public class WithoutGenericSolution {

	public static void main(String[] args) {
		Box fruitBox = new Box();
		Apple apple1 = new Apple();
		Banana banana1 = new Banana();
		
		fruitBox.setAnyFruit(apple1);
		fruitBox.setAnyFruit(banana1); // 물론 사과의 참조값이 바나나로 대체하게 됨
		
		// 한계점1 : 직접 다운캐스팅이 필요
		Banana newBanana = (Banana)fruitBox.getAnyFruit();
		
		// 한계점2 : 런타임 에러 발생 가능성 있음(현재 Banana가 들어있기 때문에)
		Apple apple = fruitBox.getAnyFruit(); // 현재는 바나나가 들어있으므로 런타임 에러 발생
		
		// 한계점3 : 과일말고 다른 모든 객체들도 포함될 수 있음
	}

}
