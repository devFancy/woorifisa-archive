package dev.syntax.step04collection;

public class MouseTest {

	public static void main(String[] args) {
		Mouse mini = new Mouse(10, "미니", "하와이", "구직중");
		Mouse mickey = new Mouse(25, "미키", "런던", "맨체스터 유나이티드");
		Mouse jay = new Mouse(15, "제이", "상하이", "텐센트");
		Mouse jerry = new Mouse(20, "제리", "도쿄", "라인");
		Mouse jamie = new Mouse(40, "제이미", "대한민국", "삼성");

		Mouse[] mice = new Mouse[5];
		mice[0] = mini;
		mice[1] = mickey;
		mice[2] = jay;
		mice[3] = jerry;
		mice[4] = jamie;
		// Mouse[] array = { mini, mickey, jay, jerry, jamie }; // 리터럴로 초기화

		for (Mouse mouse : mice) {
			System.out.println(mouse);// log.info(mouse);
		}

		// 쥐 수정 - jay의 거주지를 프랑스, 회사를 루브르 박물관으로 변경한 후 확인하기.
		System.out.println("쥐 정보 수정");
		jay.setAddress("프랑스");
		jay.setCompany("루브르 박물관");
		System.out.println(mice[2]);
		System.out.println();

		System.out.println("쥐 정보 조회");
		System.out.println("jerry의 회사 : " + mice[3].getCompany());
		System.out.println();

		// 쥐 정보 제거 - jay, jamie의 정보를 mice 배열에서 제거
		mice[2] = null; // jay 객체 제거
		System.out.println(mice[2]);

		for (Mouse mouse : mice) {
			System.out.println(mouse);// log.info(mouse);
		}
	}

}
