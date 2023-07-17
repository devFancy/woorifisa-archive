package dev.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스를 bean 설정용 파일로 쓰겠다.
@ComponentScan(basePackages = "dev.spring") // component bean으로 읽
public class JavaBasedConfiguration {
	
	/*
	 * 아래의 Bean 생략해도 됨
	 * componentscan 어노테이션을 사용했기 때문에 dev.spring 패키지 내부의 component들을 bean으로 자동 생성하기 때문
	@Bean
	public TapeReader tapeReader() {
		return new TapeReader(tape());
	}
	
	@Bean
	public Tape tape() {
		return new Tape("아일랜드", true);
	}
	*/
	
}