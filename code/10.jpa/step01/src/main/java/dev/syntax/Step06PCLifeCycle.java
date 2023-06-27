package dev.syntax;

public class Step06PCLifeCycle {

	// In JS, todo.test.js or todo2.spec.js
	// Java에서는 별도의 test 폴더에 작성

	// 1. Save the data(entity) - manager.persist(entity) - INSERT SQL
	void persist를_수행할_경우_엔티티가_영속화되고_commit이_수행될_경우_DB에_저장된다() {

	}

	// 2. Retrieve the record - manager.find(Entity.class, id) - SELECT SQL
	void 한번_영속화된_엔티티는_다시_조회시_DB가_아닌_영속성컨텍스트에서_조회된다() {

	}

	// 3. Update the record - not supported with method - UPDATE SQL
	void 엔티티의_값을_수정하고_commit하면_변경감지가_발생되어_UPDATE쿼리가_수행된다() {

	}

	// 4. Delete the record - manager.remove(entity) - DELETE SQL
	void 만약_엔티티를_detach할경우_필드의_값을_변경해도_UPDATE쿼리가_수행되지_않는다() {

	}

	// etc lifecycle

	// 5. Detach an entity from the Persistence Context - manager.detach(entity)
	void remove를_수행할경우_PC와_DB에서_데이터가_제거된다() {

	}

	// 6. Remove the EntityManager & PC - manager.close()
	void 영속성컨텍스트를_초기화할경우_모든_엔티티가_제거됨() {

	}

	void 엔티티매니저가_제거됨() {

	}

}
