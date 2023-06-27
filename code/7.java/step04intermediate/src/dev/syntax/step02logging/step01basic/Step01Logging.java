package dev.syntax.step02logging.step01basic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Step01Logging {
	// 로거 객체 생성
	private static final Logger logger = Logger.getLogger(Step01Logging.class.getName());

	public static void main(String[] args) {
		// Java 로깅은 java.util.logging 패키지로 사용 가능(내장 라이브러리)

		// 기본 로그 레벨은 INFO
//		logger.log(Level.INFO, "INFO 레벨 출력");
//		logger.log(Level.WARNING, "WARNING 레벨 출력");

		java.util.logging.Logger.getLogger("").getHandlers()[0].setLevel(Level.FINE);
		logger.setLevel(Level.FINE);

		logger.log(Level.INFO, "INFO 레벨 출력");
		logger.log(Level.WARNING, "WARNING 레벨 출력");
		logger.log(Level.CONFIG, "CONFIG 레벨 출력");
		logger.log(Level.FINE, "FINE 레벨 출력");
		logger.log(Level.FINER, "FINER 레벨 출력");

	}

}
