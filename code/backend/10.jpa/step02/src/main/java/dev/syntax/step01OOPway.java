package dev.syntax;

import dev.syntax.model.Major;
import dev.syntax.model.Student;

public class step01OOPway {
	/*
	 * RDB이 없이 객체지향만으로 Student와 Major의 관계 구현
	 */
	public static void main(String[] args) {
		Student hwang = new Student(1, "철원");
		Student han = new Student(2, "윤서");
		
		Major computer = new Major(1, "Computer Science");
		
		hwang.setMajor(computer);
		han.setMajor(computer);
		
		// 철원님의 전공이 무슨 과인지 확인
		Major majorHwanfg = hwang.getMajor();
		System.out.println(majorHwanfg);
				
	}

}
