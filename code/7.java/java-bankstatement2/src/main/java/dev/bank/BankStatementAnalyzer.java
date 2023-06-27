package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;
import dev.bank.data.BankStatementTSVParser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer {

	private static final String RESOURCES = "src/main/resources/";

	public void analyze(String fileName, BankStatementParser parser) throws IOException {
		// 1. 첫 번째 관심사 - 데이터 파일 읽기
		final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
		List<String> lines = Files.readAllLines(path);


		// 직원에게 일을 줘야함 - 직원에게 데이터를 전달하고,
		List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);

		// 3. 세 번째 관심사 - 연산처리
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
		
		// 4. 네 번째 관심사 - 연산 결과 출력
		collectSummary(processor);
	}
	
	private static void collectSummary(BankStatementProcessor processor) {
		System.out.println("총 사용 금액은 " + processor.calculateTotalAmount() + "입니다.");
		
		System.out.println("2월의 총 입출금액은" + processor.calculateTotalInMonth(Month.FEBRUARY) + "입니다");
	
		System.out.println("Salary 카테고리 별 총 금액은" + processor.calculateTotalCategory("Salary") + "입니다.");
	}

}
