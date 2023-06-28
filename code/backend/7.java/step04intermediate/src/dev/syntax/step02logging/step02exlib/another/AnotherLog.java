package dev.syntax.step02logging.step02exlib.another;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnotherLog {
	private static Logger logger = LogManager.getLogger(AnotherLog.class);

	public static void main(String[] args) {
		logger.debug("Debug log message");
		logger.info("Info log message");
		logger.error("Error message");
	}
}
