package dev.syntax.step03generic.step02;

import dev.syntax.step03generic.step01.Apple;
import dev.syntax.step03generic.step01.Banana;

public class FirstGeneric {

	public static void main(String[] args) {
		
		// < typeA > : typeA이라는 타입만 받을 수 있음
		// type을 지정하기 때문에, 따로 다운캐스팅을 할 필요 없다.
		OnlyOneTypeBox<Apple> appleBox = new OnlyOneTypeBox<>();
		
		Apple apple = new Apple();
		appleBox.set(apple);
		
		Banana banana = new Banana();
		// 장점1. 실수로라도 다른 타입으로 세팅할 수 없음
		// appleBox.set(banana);
		// => type이 Apple이기 때문에, Banana 타입은 들어갈 수 없음
		
		OnlyOneTypeBox<Banana> bananaBox = new OnlyOneTypeBox<>();
		
		// 장점2 : 강제 형변환도 불가능(애초에 서로 다은 타입이기 때문에)
		// Apple apple2 = (Apple)bananaBox.get();
	}

}
