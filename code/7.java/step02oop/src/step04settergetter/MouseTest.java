package step04settergetter;

public class MouseTest {

	public static void main(String[] args) {
		
		// 검은색 미키마우스 생성
		Mouse mickey = new Mouse("black");
		
		// 지브리 직원이 디즈니에 침투
		// 현재 Mouse 클래스의 color 필드는 공개되어 있
		mickey.color = "white";
		System.out.println(mickey.color);

	}

}
