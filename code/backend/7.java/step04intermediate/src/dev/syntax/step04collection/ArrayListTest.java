package dev.syntax.step04collection;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		Mouse mini = new Mouse(10, "미니", "하와이", "구직중");
		Mouse mickey = new Mouse(25, "미키", "런던", "맨체스터 유나이티드");
		Mouse jay = new Mouse(15, "제이", "상하이", "텐센트");
		Mouse jerry = new Mouse(20, "제리", "도쿄", "라인");
		Mouse jamie = new Mouse(40, "제이미", "대한민국", "삼성");

		// ArrayList 객체 생성
		ArrayList<Mouse> list = new ArrayList<>(5);
		list.add(mini); // 요소 추가
		list.add(mickey);
		list.add(jay);
		list.add(jerry);
		list.add(jamie);

		// 리스트 내에 포함된 전체 요소의 개수 size()
		System.out.println("list의 요소의 개수: " + list.size());

		// 1번째 인덱스에 들어있는 요소 조회
		Mouse mouse = list.get(0);
		System.out.println("list의 첫 번째 요소: " + mouse);

		// 3번째의 요소 삭제(2번째 인덱스로 접근)
		System.out.println(list.remove(2));

		// 제리의 나이를 21살로 수정.
		list.get(2).setAge(21); // 왜 2번째 인덱스지?
		System.out.println();

		// 수정된 제리의 나이만 조회.
		System.out.println("제리의 나이 : " + list.get(2).getAge());
		System.out.println();

		// 새로운 쥐 '지니' 추가.
		list.add(new Mouse(30, "지니", "대한민국", "스타벅스"));

		// 전체 요소 조회
		System.out.println("전체 요소 조회");
		for (Mouse mouse1 : list) {
			System.out.println(mouse1);
		}
	}

}
