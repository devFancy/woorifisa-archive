package dev.summer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import dev.spring.TapeReader;

@Component
public class DrinkTest {
	
	public static void main(String[] args) {
		
		// dev.summer 를 컴포넌트 스캔 대상으로 동작하는 컨테이너 생성
		ApplicationContext contextSummer = new AnnotationConfigApplicationContext("dev.summer"); // 오버로딩
		
		// Drink를 bean으로 주입받고
		Drink drink = contextSummer.getBean(Drink.class);
		
		// 테스트
		System.out.println(drink);
		
	}
}
