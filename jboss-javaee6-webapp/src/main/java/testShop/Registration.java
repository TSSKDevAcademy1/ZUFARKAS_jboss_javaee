package testShop;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;

import taskRegisterJPA.Person1;


public class Registration {

	@Inject
	EntityManager em;
	
	public void addNewCustomer(Customer customer) {
		em.persist(customer);

	}
	
	public Customer getCustomer(long id) {
		return em.find(Customer.class, id);
	}
	
	
}
