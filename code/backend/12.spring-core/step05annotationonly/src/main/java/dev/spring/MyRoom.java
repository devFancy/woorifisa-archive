package dev.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MyRoom {

	public static void main(String[] args) {
		
		// 1. 별도의 bean 설정 용 XML없이, Annotation 만으로 컨테이너에 bean을 등록하고, 구성하는 방식
		// ApplicationContext : interface
		ApplicationContext contextSpring = new AnnotationConfigApplicationContext("dev.spring"); // 오버로딩
		// XML에 작성했던 <component-scan base-package="dev.spring" /> 을 대체하기 위한 인자값
		
		System.out.println(contextSpring);
		
		
		TapeReader reader = contextSpring.getBean(TapeReader.class);
		Tape tape = contextSpring.getBean(Tape.class);
		System.out.println(reader);
		System.out.println(tape);
		
		reader.test();

	}

}
