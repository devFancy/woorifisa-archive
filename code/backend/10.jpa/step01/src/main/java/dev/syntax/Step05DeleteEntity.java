package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step05DeleteEntity {

	public static void main(String[] args) {
		// Factory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

		// Manager
		EntityManager manager = factory.createEntityManager();

		// Transaction
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			
			transaction.begin();
			
			// 삭제를 위해 select를 해야함
			Book book = manager.find(Book.class, 1);
			
			// remove - query delete하는 메소드가 존재!
			manager.remove(book);
			
			transaction.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
			factory.close();
		}

	}

}
