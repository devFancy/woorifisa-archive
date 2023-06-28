package dev.syntax.step02logging.step02exlib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // import 잘 하기

public class MyLog4jTest {

	private static Logger logger = LogManager.getLogger(MyLog4jTest.class);

	public static void main(String[] args) {
		// Log4j : 외부라이브러리 (Lombok과 같음)

		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
//			logger.debug("Debug log message"); //
//			logger.error("INFO 레벨 출력"); // = logger.log(Level.ERROR, "INFO 레벨 출력"); 이거랑 같은 거
			logger.error("error", e);
		}
	}
	// ERROR StatusLogger Log4j2 could not find a logging implementation.
	// 구현체가 없다는 의미.

}
