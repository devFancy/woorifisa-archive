package dev.spring.step01field;

import org.springframework.beans.factory.annotation.Autowired;

public class TapeReader {

	@Autowired  // 1. 필드를 통해서 의존성 주입
				// 설정 파일을 기반으로, TapeReader에서 Tape 필드가 Autowired되어 있으면, 
				// bean에서 따로 연결 설정( = property, .. )을 하지 않아도, 자동으로 의존성이 주입된다.
				// xml에서 쓰던 방식을 annotation으로 추상화시킨 것
	// @Autowired 는 필드 뿐만 아니라, 생성자 ..등에도 사용 가능
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

	// setter 메서드 기반 의존성 주입
	public void setTape(Tape tape) {
		System.out.println("setTape() called");
		this.tape = tape;
	}

	@Override
	public String toString() {
		return "TapeReader 입니다.";
	}

}
