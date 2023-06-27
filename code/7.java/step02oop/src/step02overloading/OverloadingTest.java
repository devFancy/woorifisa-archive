package step02overloading;

public class OverloadingTest {

	public static void main(String[] args) {
		Mouse jerry = new Mouse();

		// 나이만 지정하여 생성하는 생성자 메서드
		Mouse jay = new Mouse(15);

		// 이름만 지정하여 생성하는 생성자 메서드
		Mouse jamie = new Mouse("제이미");

		// 나이와 이름을 지정하여 생성하는 생성자 메서드
		// 컴파일러 입장에서 String, int를 받는 생성자는 존재하지 않기 때문에 에
		// Mouse joo = new Mouse("주", 15);

	}

}
