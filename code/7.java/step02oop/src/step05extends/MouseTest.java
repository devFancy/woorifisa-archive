package step05extends;

public class MouseTest {

	public static void main(String[] args) {
		
		// Mouse 생성자
//		Mouse jerry = new Mouse();
//		Mouse mickey = new Mouse(5);
//		Mouse mickey2 = new Mouse(5, "pink");
//		Mouse joo = new Mouse(5, "pink", "뉴욕시");
		
		Mouse jerry = new Mouse();
		jerry.sing();
		
		System.out.println(jerry.toString());
	}

}