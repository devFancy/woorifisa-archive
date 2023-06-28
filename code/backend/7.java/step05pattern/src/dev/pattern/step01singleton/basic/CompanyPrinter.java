package dev.pattern.step01singleton.basic;

public class CompanyPrinter {
	int age; // 필드 앞에 static이 없으면 인스턴스 필드이기 때문에
	// 인스턴스를 먼저 생성하지 않으면 접근이 불가능

	// s2. 클래스 내에서 직접 인스턴스를 생성
	// 매번 새로운 인스턴스가 생성되는 게 아니라, 고유한 인스턴스를 얻을 수 있다.
	 private static CompanyPrinter printer = new CompanyPrinter();

	// s1. 생성자의 접근 제어자를 private으로 설정해서 객체의 생성(인스턴스화)를 외부로부터 차단
	// 외부: 해당 클래스(CompanyPrinter)를 제외한 다른 모든 클래스들
	private CompanyPrinter() {
		System.out.println("기본 생성자 호출됨");
	}

	// s3. 클래스 내에서 생성한 프린터를 취득할 수 있는 메서드를 제공
	// getPrinter 를 통해서 접근할 수 있다. => printer가 private이니까 직접 접근을 못하므로
	public static CompanyPrinter getPrinter() {
		return printer;
	}

	// s4. 프린터 일련번호 확인
	@Override
	public String toString() {
		return "Serial No." + Integer.toHexString(hashCode());
	}
	
}
