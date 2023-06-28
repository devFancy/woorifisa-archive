package dev.syntax;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dev.syntax.model.Book;

class Step06PCLifeCycleTest {


	// 테스트를 위한 기본 구성
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

	EntityManager manager = factory.createEntityManager();

	EntityTransaction transaction = manager.getTransaction();

	@Test
	public void testPersist를_수행할_경우_엔티티가_영속화되고_commit이_수행될_경우_DB에_저장된다() {
		transaction.begin();

		Book jpaBook = new Book("JPA", "무명", new Date());
		manager.persist(jpaBook);

		transaction.commit();

		Book foundBook = manager.find(Book.class, jpaBook.getId()); // select 해 온 Book 객체의 id를 찾아보기
		// 영속성 컨텍스트에 존재하면, select문이 따로 실행되지 않는다.
		// 교안 영속성 조회 - select 부분 확인하기!

		System.out.println(jpaBook == foundBook);
		assertEquals(jpaBook, foundBook); // 단정문
	}

	@Test
	public void test한번_영속화된_엔티티는_다시_조회시_DB가_아닌_영속성컨텍스트에서_조회된다() {
		int id = 2;

		Book foundBook = manager.find(Book.class, id); // 첫번째 select 한 entity

		System.out.println(foundBook);

		Book foundBookTwice = manager.find(Book.class, id); // 두번째 select 한 entity

		assertEquals(foundBook, foundBookTwice);
		// 영속성에 첫번째 select 이후에 select로 불러온 데이터는 영속성 컨텍스트에 그대로 있기 때문에,
		// 2번째 find() 메소드에서는 select query가 또 실행되지 않는다.
	}

	@Test
	public void test엔티티의_값을_수정하고_commit하면_변경감지가_발생되어_UPDATE쿼리가_수행된다() {
		int id = 2;

		transaction.begin();

		Book foundBook = manager.find(Book.class, id);

		foundBook.updateBookName("ABC"); // foundBook 엔티티의 도서명 변경

		// manager.persist(foundBook);
		transaction.commit(); // 기존의 commit snapshot & updated entity와 비교
	}

	@Test
	void test만약_엔티티를_detach할경우_필드의_값을_변경해도_UPDATE쿼리가_수행되지_않는다() {
		int id = 2;
		transaction.begin();

		// id가 1번인 엔티티 조회
		Book foundBook = manager.find(Book.class, id);
		foundBook.updateBookName("QAW");

		manager.detach(foundBook); // foundBook 엔티티를 PC에서 분리(detach)
		// update 쿼리 수행 안됨

		transaction.commit();

		// 영속성 컨텍스트에서 제거되었기 때문에 다시 SELECT가 수행됨
		Book foundBookTwice = manager.find(Book.class, id);
		assertNotEquals(foundBook, foundBookTwice);
	}

	@Test
	void testRemove를_수행할경우_PC와_DB에서_데이터가_제거된다() {
		int id = 2;
		transaction.begin();
		Book foundBook = manager.find(Book.class, id);
		manager.remove(foundBook);

		transaction.commit();

		// JS, () => {}, fat arrow
		assertThrows(NullPointerException.class, () -> {// In java, Thin Arrow(() -> {})

			// 위에서 remove가 되었기 때문에 select를 보내도 존재하지 않고, null이 할당됨
			Book foundBookTwice = manager.find(Book.class, id);
			// null.updateBookName()을 수행했기 때문에 nullPointer 발생(테스트 성공)
			foundBookTwice.updateBookName("Effective Unit Testing");

			// PC에 남아있으면 SELECT를 수행하지 않기 때문에 기존에 있던 엔티티와 비교 시 true가 나올 것
			// -> 확인 결과, 남아있지 않음

			// 'foundBook == foundBookTwice 조건의 결과가 false일 것이다'라는 단정문
			assertFalse(foundBook == foundBookTwice);

		});
	}

	@Test
	public void test영속성컨텍스트를_초기화할경우_모든_엔티티가_제거됨() {
		int id = 3;
		
		Book foundBook = manager.find(Book.class, id);
		
		manager.clear(); // PC 한번 청소 해, 엔티티 모두 치워
		
		Book foundBookTwice = manager.find(Book.class, id);
		
		assertFalse(foundBook == foundBookTwice);
	}

	@Test
	public void test엔티티매니저가_제거됨() {
		EntityManager beforeClose = manager;
		
		// 엔티티 매니저 자체를 제거
		manager.close();
		EntityManager afterClose = manager;
		
		assertNotEquals(beforeClose, afterClose);
	}


}
