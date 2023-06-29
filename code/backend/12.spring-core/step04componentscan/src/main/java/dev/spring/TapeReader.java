package dev.spring;

import org.springframework.stereotype.Component;

/* 
 	@Component : 스프링 컨테이너가 해당 class인 TapeReader를 bean으로 자동으로 등록
  				 컴포넌트 스캔을 통해 TapeReader가 하나의 Component인 것을 확인했기 때문에

   				 component와 autowired는 관계 X !!!!! 오해 NO
   				 
   				 @Component : xml파일에 자동으로 해당 class를 bean으로 생성해주는 역할
   				 @Autowired : 의존성 주입 | xml 파일에서 property로 연결해줬던 걸, 추상화 되었다고 보면 된다 ~
*/ 
@Component
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
