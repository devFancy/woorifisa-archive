package dev.spring.step02setter;

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

	public Tape(String name, boolean isWorked) {
		super();
		this.name = name;
		this.isWorked = isWorked;
	}

	public String getName() {
		return name;
	}

	@Autowired // @Autowired : 값을 엮어주기 위해서, Autowired 어노테이션을 기입
	public void setName(@Value("아일랜드") String name) { // @Value() : 파라미터 옆에도 쓸 수 있다.
		System.out.println("setName(String name) called()");
		this.name = name;
	}

	public boolean isWorked() {
		return isWorked;
	}

	@Autowired
	public void setWorked(@Value("true") boolean isWorked) {
		System.out.println("setWorked(boolean isWorked) called()");
		this.isWorked = isWorked;
	}
}

