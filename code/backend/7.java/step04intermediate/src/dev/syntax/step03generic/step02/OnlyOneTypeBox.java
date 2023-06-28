package dev.syntax.step03generic.step02;

// 하나의 타입만 받을 수 있는 클래스
// <> : diamond operator (다이아몬드 연산자)
// 클래스 옆에 작성, T : Type의 줄임 표현
public class OnlyOneTypeBox<T> {
	
//	private Apple t;
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
}
