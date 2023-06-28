package step04settergetter;

public class Mouse2 {

	private String color; // private : 접근 제어자

	// 색상 지정하여 생성하는 생성자 메서드
	public Mouse2(String color) {
		this.color = color;
	}
	
	// 일반 메서드
	// setter 메서드,set + 필드명(camelCase)
	// 값을 설정해주는 메서드 
	public void setColor(String color) {
		// 로직을 작성할 수 있는 부분
		if(color == "white") {
			System.out.println("너 누구임...");
			return;
		}
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}
