package dev.pattern.step01singleton.basic;

import java.util.Iterator;

/*
 * 상황 가정 : 회사 내 프린터기(CompanyPrinter)가 1대밖에 없기 때문에
 * 직원(Employee)들이 번갈아가면서 사용해야 함
 */

public class Company {
	
	// 최대 직원 수
	private static final int EMPLOYEES = 5;

	public static void main(String[] args) {
		
		Employee[] employees = new Employee[EMPLOYEES];
		
		for (int i = 0; i < EMPLOYEES; i++) {
			employees[i] = new Employee("user-" + i);
			employees[i].usePrinter();
		}
		
		// 기본 생성자 - 생성자 없으면, 자동으로 생성
		// new 로 새로 생성한 인스턴스는 고유함 | new 뒤에는 생성자 호출
//		CompanyPrinter printer = new CompanyPrinter();
//		// 인스턴스를 만들고 나서, 필드값에 접근 가능
//		CompanyPrinter printer2 = new CompanyPrinter();
//		System.out.println(printer == printer2); // false : 서로 다른 주소값이므로
		
//		CompanyPrinter printer1 = CompanyPrinter.getPrinter(); // getPrinter로 접근
//		CompanyPrinter printer2 = CompanyPrinter.getPrinter();
//		System.out.println(printer1 == printer2);
//		System.out.println(printer1);
//		System.out.println(printer2);
		
		
	}

}
