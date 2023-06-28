package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

// data 패키지 - 외부 데이터와 관련된 역할을 하는 패키지

// CSV 파일을 파싱해주는 클래스
// CSV : Comma-Separated-Values
public class BankStatementCSVParser implements BankStatementParser {
	
	final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	
	// 한 줄만 파싱하는 기능
	// 이 메서드는 이 클래스에서만 사용할 예정 (접근제한, private)
	@Override
	public BankTransaction parseFrom(final String line) {
		
		final String[] columns = line.split(","); // tab으로 구분
		
		// 각 column을 parsing 처리
		LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]); // 문자열 -> double 변환
		final String description = columns[2];
		
		// 파싱된 개별 값들을 BankTransaction 이라는 클래스로 묶어줌(Wrapping)
		BankTransaction bankTransaction = new BankTransaction(date, amount, description);
		return bankTransaction;
	}

	
	
	// 한줄씩 파싱된 데이터를 리스트에 추가
	// 이 메서드는 외부에서 호출 가능하도록
	@Override
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		
		List<BankTransaction> bankTranstions = new ArrayList<BankTransaction>();
		
		// parseFromTSV
		for (String line : lines) {
			// paserFromCSV 에서 파싱처리 한 BankTransaction을 리스트에 넣어주기
			bankTranstions.add(parseFrom(line)); // 리스트의 개별 요소로 추가
		}
		
		return bankTranstions;
	}
}
