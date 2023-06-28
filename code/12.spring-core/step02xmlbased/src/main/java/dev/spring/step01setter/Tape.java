package dev.spring.step01setter;

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

	public void setName(String name) {
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