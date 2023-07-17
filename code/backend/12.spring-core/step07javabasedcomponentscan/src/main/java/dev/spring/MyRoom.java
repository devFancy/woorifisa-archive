package dev.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MyRoom {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaBasedConfiguration.class); // 오버로딩
			
		TapeReader reader = context.getBean(TapeReader.class);

		System.out.println(reader);

		reader.test();
		
		((AnnotationConfigApplicationContext) context).close();

	}

}
