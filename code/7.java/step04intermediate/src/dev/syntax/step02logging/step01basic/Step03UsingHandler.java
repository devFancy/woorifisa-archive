package dev.syntax.step02logging.step01basic;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Step03UsingHandler {
	// 로거 객체 생성
	private static final Logger logger = Logger.getLogger(Step03UsingHandler.class.getName());

	public static void main(String[] args) {
		Logger rootLogger = Logger.getLogger("");
		rootLogger.setLevel(Level.FINE); // 전역 설정 변경
		rootLogger.getHandlers()[0].setLevel(Level.FINE); // logger 설정 변경(전역 설정 변경과 동일하게)

		logger.setLevel(Level.FINE);

		Handler handler = new MyHandler();
		logger.addHandler(handler);

		logger.log(Level.INFO, "INFO 레벨 출력");
		logger.log(Level.WARNING, "WARNING 레벨 출력");
		logger.log(Level.CONFIG, "CONFIG 레벨 출력");
		logger.log(Level.FINE, "FINE 레벨 출력");
		logger.log(Level.FINER, "FINER 레벨 출력");

	}

}
