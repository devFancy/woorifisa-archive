package dev.syntax;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step02DoPersist {

	public static void main(String[] args) {
		
		// JPA 인터페이스에서 제공하는 EntityManagerFactory에
		// Persistence 클래스로 하이버네이트 구현체를 인스턴스화
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

		EntityManager manager = factory.createEntityManager();
		
		// 영속화(persist(entity))
		
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			
			transaction.begin();
			
			// Book 엔티티 생성, 30번 라인 시점까지는 transient 상태(비영속)
			// 영속화 되어있지 않음
			// 영속화(): 영속성 컨텍스트에서 관리되고 있지 않은 상태
			Book book = new Book("JPA", "무명", new Date());
			
			
			manager.persist(book); // 영속화 진행시켜
			
			
			transaction.commit(); // COMMIT;
			// tx.commit() -> flush() -> INSERT Query 진행시켜
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close(); // 매니저 제거, 영속성 컨텍스트 제거 - 매니저가 없으니까, 영속성 관리도 당근 X
			factory.close(); // 공장 제거
		}
		

	}

}
