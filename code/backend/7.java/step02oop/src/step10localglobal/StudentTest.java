package step10localglobal;

public class StudentTest {

	public static void main(String[] args) {
		Student yoon = new Student();
		yoon.name = "윤영인";
		// yoon.centerName = "핀테크랩"; // The static field Student.centerName should be accessed in a static way
		Student.centerName = "핀테크랩";
		
		Student lee = new Student();
		lee.name = "이준희";
		
		System.out.println(lee.centerName);
	}

}
