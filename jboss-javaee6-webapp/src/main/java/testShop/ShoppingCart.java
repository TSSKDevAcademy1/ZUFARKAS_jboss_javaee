package testShop;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ShoppingCart {

	@Inject
	EntityManager em;

	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}
	
//	public void removeProduct(Long id) {
//		em.createQuery("DELETE FROM ---- p WHERE p.id = :id").setParameter("id", id).executeUpdate();
//		}
//		
	
//	public List<Person> getAllPersons() {
//		List<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
//		return persons;
//		}
//	
}
