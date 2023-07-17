package dev.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스를 bean 설정용 파일로 쓰겠다.
public class JavaBasedConfiguration {
	
	@Bean
	public TapeReader tapeReader() {
		return new TapeReader(tape());
	}
	
	@Bean
	public Tape tape() {
		return new Tape("아일랜드", true);
	}
	
}