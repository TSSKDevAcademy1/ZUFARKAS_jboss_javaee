package testShop;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jws.WebService;
@WebService
@Singleton
public class RegistrationSoapService {

	@Inject
	Registration registration;

	/**
	 * @param customer
	 * @see testShop.Registration#addNewCustomer(testShop.Customer)
	 */
	public void addNewCustomer(Customer customer) {
		registration.addNewCustomer(customer);
	}
	
}
