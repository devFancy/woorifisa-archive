package dev.bank.data;

import java.util.List;

import dev.bank.domain.BankTransaction;

// parseFromTSV 와 parseFromCSV 가 해당 인터페이스를 구현하도록
public interface BankStatementParser {
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);
}
