package taskRegisterJPA;

import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jws.WebService;

@WebService
@Singleton
public class RegisterSOAPService {

	@Inject
	Register1 register;

	/**
	 * @param id
	 * @return
	 * @see taskRegisterJPA.Register1#getPerson(int)
	 */
	public Person1 getPerson(long id) {
		return register.getPerson(id);
	}

	/**
	 * @param person
	 * @see taskRegisterJPA.Register1#addPerson(TaskRegister.Person)
	 */
	public void addPerson(Person1 person) {
		register.addPerson(person);
	}

	/**
	 * @return
	 * @see taskRegisterJPA.Register1#listAllPersons()
	 */
	public List<Person1> listAllPersons() {
		return register.listAllPersons();
	}

	public Person1 findPersonByName(String name) {
		return register.findPersonByName(name);
	}

	/**
	 * @param phoneNumber
	 * @return
	 * @see taskRegisterJPA.Register1#findPersonByPhoneNumber(java.lang.String)
	 */
	public Person1 findPersonByPhoneNumber(String phoneNumber) {
		return register.findPersonByPhoneNumber(phoneNumber);
	}

	/**
	 * @param person
	 * @see taskRegisterJPA.Register1#removePerson(taskRegisterJPA.Person1)
	 */

}
