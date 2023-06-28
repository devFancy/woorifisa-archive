package dev.bank;

import java.io.IOException;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;

public class MainApplication {

	// 사용자가 볼 수 있는 프로그램의 메인 화면
	public static void main(String[] args) throws IOException {
		
		// 분석기 생성
		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
		
		// 파서 생성
		final BankStatementParser parser = new BankStatementCSVParser();
		
		analyzer.analyze("bank-data-simple.csv", parser);
	}

}
