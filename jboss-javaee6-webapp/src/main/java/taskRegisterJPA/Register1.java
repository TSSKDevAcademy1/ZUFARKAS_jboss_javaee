package taskRegisterJPA;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Register1 {

	@Inject
	EntityManager em;

	public Register1() {

	}

	public Person1 getPerson(long id) {
		return em.find(Person1.class, id);
	}

	public void addPerson(Person1 person) {
		em.persist(person);

	}

	public List<Person1> listAllPersons() {
		// em.getTransaction();
		List<Person1> persons = em.createQuery("select p from Person1 p", Person1.class).getResultList();

		return persons;

	}

	public Person1 findPersonByName(String name) {
		return em.createQuery("SELECT p FROM Person1 p WHERE p.name=:name", Person1.class).setParameter("name", name)
				.getSingleResult();

	}

	public Person1 findPersonByPhoneNumber(String phoneNumber) {
		return em.createQuery("SELECT p FROM Person1 p WHERE p.phoneNumber=:phoneNumber", Person1.class)
				.setParameter("phoneNumber", phoneNumber).getSingleResult();

	}

//	public void remove(long id) {
//		em.createQuery("DELETE FROM Person1 p WHERE p1.id=:id").setParameter("id", id).executeUpdate();
//	}
	

}
