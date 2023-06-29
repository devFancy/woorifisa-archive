package dev.spring.step02setter;

import org.springframework.beans.factory.annotation.Autowired;

public class TapeReader {

	private Tape tape;
	
	
	public TapeReader() {
		System.out.println("TapeReader() called");
		// bean 을 통해서, 해당 생성자가 생성됨
	}

	// test() 메소드가 실행될 때, tape 의존성도 추가해야 함
	public void test() {

		if (tape.isWorked()) {
			System.out.println(tape.getName() + " 정상 동작합니다");
		} else {
			System.out.println(tape.getName() + " 사기 당했습니다");
		}

	}

	
	@Autowired // setter 메서드 기반 의존성 주입(injection)
	public void setTape(Tape tape) {
		// 위의 @@Autowired는 이 과정과 같음
		// private Tape tape;
		System.out.println("setTape() called");
		this.tape = tape;
	}

	@Override
	public String toString() {
		return "TapeReader 입니다.";
	}

}
