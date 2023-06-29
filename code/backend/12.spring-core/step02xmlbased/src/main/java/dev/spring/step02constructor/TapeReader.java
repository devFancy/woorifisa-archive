package dev.spring.step02constructor;

public class TapeReader {

	private Tape tape;
	
	
	public TapeReader() {
		System.out.println("TapeReader() called");
		// bean 을 통해서, 해당 생성자가 생성됨
	}

	// 생성자 기반으로 Tape 의존성 주입
	public TapeReader(Tape tape) {
		super();
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
