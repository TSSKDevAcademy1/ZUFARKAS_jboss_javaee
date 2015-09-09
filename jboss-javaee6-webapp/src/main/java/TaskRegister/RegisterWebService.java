package TaskRegister;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;

import com.sun.org.apache.regexp.internal.recompile;

@Singleton
@WebService
public class RegisterWebService {

	@Inject
	private ListRegister listregister;

	@Inject
	private EntityManager em;
	/**
	 * @param person
	 * @see TaskRegister.ListRegister#addPerson(TaskRegister.Person)
	 */
	public void addPerson(Person person) {
		listregister.addPerson(person);
	}

	/**
	 * @param name
	 * @return
	 * @see TaskRegister.ListRegister#findPersonByName(java.lang.String)
	 */
	public Person findPersonByName(String name) {
		return listregister.findPersonByName(name);
	}

	/**
	 * @param phoneNumber
	 * @return
	 * @see TaskRegister.ListRegister#findPersonByPhoneNumber(java.lang.String)
	 */
	public Person findPersonByPhoneNumber(String phoneNumber) {
		return listregister.findPersonByPhoneNumber(phoneNumber);
	}

	/**
	 * @param person
	 * @see TaskRegister.ListRegister#removePerson(TaskRegister.Person)
	 */
	public void removePerson(Person person) {
		listregister.removePerson(person);
	}
	
	public List<Person> getAllPersons() {
		return listregister.getPersons();
	}
	
	
	
}
