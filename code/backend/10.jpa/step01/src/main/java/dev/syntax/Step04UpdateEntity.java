package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step04UpdateEntity {

	/*
	 *	Entity 값(Java 에서는 Entity 클래스의 필드, DB로 보면 컬럼)을 변경(수정)
	 *	Update Query
	 */
	public static void main(String[] args) {
		
		// Factory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
		
		// Manager
		EntityManager manager = factory.createEntityManager();
		
		// Transaction
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			
			transaction.begin(); // BEGIN
			
			// 1. 수정하기 위해서는 일단, 해당 id의 값의 데이터를 찾기
			Book book = manager.find(Book.class, 1);
			System.out.println(book);
			
			// 2. JPA에서는 별도의 UPDATE를 위한 메서드를 제공하지 않음
			book.updateBookName("ABC"); // Book의 이름을 JPA에서 ABC로 변경
			
			// 3. manager에게 값을 받은 것을 다시 영속화 한다고 알려줘야함
			manager.persist(book); // 다시 영속화
			
			// 4. Query 진행시켜
			transaction.commit(); // COMMIT;
			
			/*
			 * tx.commit()을 통해 flush()가 호출될 경우, DB 적용 전에 변경 감지가 먼저 수행됨
			 * 새롭게 변경된 엔티티(`bookName: ABC`) ← 변경 감지 → 기존 엔티티(`bookName: JPA`)
			 */
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
	}

}
