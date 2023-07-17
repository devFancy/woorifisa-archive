package dev.spring;


public class TapeReader {

	private Tape tape;
	

	// tape에 대한 의존성은 매개변수가 있는 생성자를 통해 주입
	public TapeReader(Tape tape) {
		System.out.println("TapeReader(Tape tape) called");
		this.tape = tape;
	}

	// test() 메소드가 실행될 때, tape 의존성도 추가해야 함
	public void test() {

		if (tape.isWorked()) {
			System.out.println(tape.getName() + " 정상 동작합니다");
		} else {
			System.out.println(tape.getName() + " 사기 당했습니다");
		}

	}

	@Override
	public String toString() {
		return "TapeReader 입니다.";
	}

}
