package dev.syntax.step02logging.step01basic;

import java.util.Date;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class MyFormatter extends SimpleFormatter {

	// SimpleFormatter의 format메서드를 오버라이딩 
	@Override
	public String format(LogRecord record) {
		return record.getSourceClassName()+"::"
                +record.getSourceMethodName()+"::"
                +new Date(record.getMillis())+"::"
                +record.getMessage()+"\n";
    }
	
}