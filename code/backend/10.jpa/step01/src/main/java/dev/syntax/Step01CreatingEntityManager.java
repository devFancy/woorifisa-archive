package dev.syntax;

import java.util.ArrayList;
import java.util.List;

// persistence : 인터페이스
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import com.mysql.cj.xdevapi.SessionFactory; // hibernate : 구현체

public class Step01CreatingEntityManager {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

		EntityManager manager = factory.createEntityManager();
		
		System.out.println(manager);
		
		// 구현체의 타입으로 직접 사용
		ArrayList<String> list1 = new ArrayList<String>();
		
		// 인터페이스로 사용
		List<String> list2 = new ArrayList<String>();
		
		// SessionFactory // jpa로 사용하는 이유는 - 위의 List로 arrayList를 선언한것과 비슷한 맥락
					   	  // 구현체로 사용하면, 좀 더 편하니까..
	}

}
