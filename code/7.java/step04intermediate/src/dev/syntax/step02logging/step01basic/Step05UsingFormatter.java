package dev.syntax.step02logging.step01basic;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Step05UsingFormatter {
	// 로거 객체 생성 - 로거를 사용하기 위해
	// main method가 static이기 때문에 얘도 static선언
	// 상수로 만들기 ! - final
	private static final Logger logger = Logger.getLogger(Step05UsingFormatter.class.getName()); 
	
	public static void main(String[] args) {
		Logger rootLogger = Logger.getLogger("");
		rootLogger.setLevel(Level.FINE); // 전역 설정 변경
		rootLogger.getHandlers()[0].setLevel(Level.FINE); // logger 설정 변경(전역 설정 변경과 동일하게) 
		
		logger.setLevel(Level.FINE);
		
		// 출력 방식을 포매팅해주는 역할인 Formatter 객체 생성
//		MyFormatter logFormatter = new MyFormatter();
//		MyFormatter logFormatter = new AnotherFormatter(); // MyFormatter와 AnotherFormatter의 타입이 다르니
		Formatter logFormatter = new AnotherFormatter();		
//		Formatter logFormatter = new MyFormatter(); // 다른 핸들러로 교체
		
		// 핸들러에 포매터 등록
		Handler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(logFormatter);
		
		// Logger에 핸들러 등록
		logger.setUseParentHandlers(false); // 기본 포매터가 동작하기 때문에 부모 핸들러 비활성화
		logger.addHandler(consoleHandler);
		
		logger.log(Level.INFO, "INFO 레벨 출력");
		logger.log(Level.WARNING, "WARNING 레벨 출력");
		logger.log(Level.CONFIG, "CONFIG 레벨 출력");
		logger.log(Level.FINE, "FINE 레벨 출력");
		logger.log(Level.FINER, "FINER 레벨 출력");
		
	}

}
