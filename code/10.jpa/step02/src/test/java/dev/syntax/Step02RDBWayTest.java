package dev.syntax;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dev.syntax.model.Major;
import dev.syntax.model.Student;

class Step02RDBWayTest {

	// 테스트를 위한 기본 구성
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step02"); // 프로젝트 명이랑 같아야 함

	EntityManager manager = factory.createEntityManager();

	EntityTransaction transaction = manager.getTransaction();

	@Test
	void testSave() {
		transaction.begin();

		// 학과 데이터 저장
		Major major = new Major("컴퓨터 공학");
		manager.persist(major);

		
		// - 학생 1 생성 , 저장
		Student kim = new Student("민수");
		// - 학생에게 전공 추가
		kim.setMajor(major);
		// - 영속화
		manager.persist(kim);

		
		// - 학생 2 생성 , 저장
		Student yoon = new Student("동열");
		// - 학생에게 전공 추가
		yoon.setMajor(major);
		// - 영속화
		manager.persist(yoon);

		transaction.commit();
	}

	@Test
	void testRead() {
		// id가 1인 학생 entity
		Student student = manager.find(Student.class, 1);
		System.out.println(student);
		
		Major major = student.getMajor();
		System.out.println(major);
		
		System.out.println("전공이름 : " + major.getMajorName());
	}

	@Test
	void testUpdateRelation() {
		// 전공을 변경
		transaction.begin();
		
		// 새로운 전공 국문학과 생성
		Major major = new Major("국문학과");
		// 영속화
		manager.persist(major);
		
		// 학번이 1인 학생(민수)의 전공을 국문학과로 변경
		Student student = manager.find(Student.class, 1);
		student.setMajor(major); // 국문학과로 변경
		
		transaction.commit();
		
		// 커밋 시, 더티 채킹이 발생하여, 새로운 값으로 변경
	}

	@Test
	void testDeleteEntity() {
		// 국문학과 제거
		transaction.begin();
		
		Student student = manager.find(Student.class, 1);
		student.setMajor(null); // 다른 과로 가세요
		
		Major major = manager.find(Major.class, 2);
		manager.remove(major); // 국문학과 제거 
		
		transaction.commit();
	}

}
