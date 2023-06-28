package dev.syntax.step02logging.step01basic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Step02ConfigLevel {
	// 로거 객체 생성
	private static final Logger logger = Logger.getLogger(Step02ConfigLevel.class.getName());

	public static void main(String[] args) {
		// 부모 로거 생성
		Logger rootLogger = Logger.getLogger("");
		rootLogger.setLevel(Level.INFO); // 전역 설정 변경
		rootLogger.getHandlers()[0].setLevel(Level.INFO); // logger 설정 변경(전역 설정 변경과 동일하게)
		logger.setLevel(Level.INFO);

		logger.log(Level.INFO, "INFO 레벨 출력");
		logger.log(Level.WARNING, "WARNING 레벨 출력");
		logger.log(Level.CONFIG, "CONFIG 레벨 출력");
		logger.log(Level.FINE, "FINE 레벨 출력");
		logger.log(Level.FINER, "FINER 레벨 출력");

	}

}
