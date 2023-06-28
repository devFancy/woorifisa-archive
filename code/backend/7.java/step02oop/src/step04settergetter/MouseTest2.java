package step04settergetter; // package는 폴더라고 보면 됨

public class MouseTest2 {

	public static void main(String[] args) {
		
		// 검은색 미키마우스 생성
		Mouse2 mickey = new Mouse2("black");
		
		// 지브리 직원이 침투
		// mickey.color = "white";
		// The field Mouse2.color is not visible
		
		mickey.setColor("white");
		System.out.println(mickey.getColor());
	}
}
