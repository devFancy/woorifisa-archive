package dev.syntax.step02logging.step01basic;

import java.util.Date;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class AnotherFormatter extends SimpleFormatter {
	private static final String format = "[%1$tF %1$tT] [%2$s] %3$s %n";
	
	@Override
	public synchronized String format(LogRecord record) {
		return String.format(format, new Date(record.getMillis()),
				record.getLevel().getLocalizedName(), record.getMessage());
	}
}
