package dev.spring.step03constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Tape {
	private String name; // 테이프 이름
	private boolean isWorked; // 정상 동작 여부

	public Tape() {
		super();
		System.out.println("Tape() called");
		//	tapeReader bean에서 property로 tape를 읽어줌 -> tape라는 기본 생성자 생성됨
	}

	@Autowired
	public Tape(@Value("아일랜드")String name, @Value("true")boolean isWorked) {
		super();
		System.out.println("Tape(name, isWorked) called");
		this.name = name;
		this.isWorked = isWorked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) { // @Value() : 파라미터 옆에도 쓸 수 있다.
		System.out.println("setName(String name) called()");
		this.name = name;
	}

	public boolean isWorked() {
		return isWorked;
	}

	public void setWorked(boolean isWorked) {
		System.out.println("setWorked(boolean isWorked) called()");
		this.isWorked = isWorked;
	}
}