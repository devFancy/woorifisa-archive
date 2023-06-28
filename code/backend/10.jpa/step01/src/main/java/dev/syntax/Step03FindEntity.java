package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step03FindEntity {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

		EntityManager manager = factory.createEntityManager();

		// SELECT 는 transaction 필요 X
		Book book = manager.find(Book.class, 1);

		System.out.println(book);
	}

}
