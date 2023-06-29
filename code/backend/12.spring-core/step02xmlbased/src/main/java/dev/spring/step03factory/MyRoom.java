package dev.spring.step03factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		// spring 에서 제공해주는 factory로 TapeReader에 대한 의존성(인스턴스)를 주입받아야함

		// 해야할 일
		// 1. 스프링에서 제공해주는 스프링 컨테이너(팩토리) 생성
		// 2. 컨테이너에게 프로그램 동작 시, 사용할 빈(bean)으로 어떤 것들이 있는 지 지정

		// context = 컨테이너
		ApplicationContext context = new ClassPathXmlApplicationContext("factory-config.xml");

		// TapeReader 생성
		// 컨테이너가 의존성을 추가하는 방식 = 의존성 주입
		TapeReader reader = context.getBean(TapeReader.class);
		Tape tape = context.getBean(Tape.class);

		reader.test();

	}

}
