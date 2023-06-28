package model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 손님, 캐셔, 바리스타, 사장 등 사람의 기본 필드를 구성하는 클래스
 *
 * Field Summary
 * 1. 이름 - String name;
 * 2. 나이 - int age;
 * 3. 성별 - Gender gender
 *
 * Method Summary
 * 1. 매장으로 들어온다. - getIn()
 * 2. 매장에서 나간다. - getOut()
 */
@Setter
@Getter
@RequiredArgsConstructor
public class Person {
	private String name;
	private int age;
	private Gender gender; // 'Person' has A 'Gender'
	
	public void getIn(Person person) {
        System.out.println(person + "가 매장으로 들어왔다.");
    }

    public void getOut(Person person) {
        System.out.println(String.format("%s가 매장에서 나갔다.", person.getName()));
    }
}
