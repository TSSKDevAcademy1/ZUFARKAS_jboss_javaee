package testShop;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import taskRegisterJPA.Person1;

public class FillCategory {

	@Inject
	EntityManager em;

	public FillCategory() {
		// TODO Auto-generated constructor stub
	}

	public void addcategory(Category category) {
		em.persist(category);
	}
	
	public void removeCategory(Long id) {
		em.createQuery("DELETE FROM Category c WHERE c.id = :id").setParameter("id", id).executeUpdate();
		}
}

