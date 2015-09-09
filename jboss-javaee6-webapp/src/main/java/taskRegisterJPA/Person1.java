package taskRegisterJPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person1 {
	@Id
	@GeneratedValue
	private long id;
	
	public Person1() {
	}

	/** Name of this person. */
	private String name;

	/** Phone number of this person. */
	private String phoneNumber;

	/**
	 * Construct a person.
	 * 
	 * @param name
	 *            name of the person
	 * @param phoneNumber
	 *            phone number of the person
	 */
	public Person1(String name, String phoneNumber) {
		this.name = name;
		this.setPhoneNumber(phoneNumber);
	}
	
	public long getId() {
		return id;
	}
	/**
	 * Returns name of this person.
	 * 
	 * @return name of this person
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of this person.
	 * 
	 * @param nameNew
	 *            name of this person
	 */
	public void setName(String nameNew) {
		name = nameNew;
	}

	/**
	 * Returns phone number of this person.
	 * 
	 * @return phone number of this person
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets phone number of this person.
	 * 
	 * @param phoneNumberNew
	 *            phone number of this person
	 */
	public void setPhoneNumber(String phoneNumberNew) {
		if (!isValidPhoneNumber(phoneNumberNew)) {
			throw new RuntimeException("Phone number is not valid");
		}
		phoneNumber = phoneNumberNew;
	}

	/**
	 * Validates the phone number. Valid phone numbers contains only 10 digits.
	 * 
	 * @param phoneNumber
	 *            phone number to validate
	 * @return <code>true</code> if phone number is valid, <code>false</code>
	 *         otherwise
	 */
	private boolean isValidPhoneNumber(String phoneNumber) {

		if (phoneNumber == null || phoneNumber.equals("") || phoneNumber.length() > 10 || phoneNumber.length() < 10) {
			return false;
		}
		int len = phoneNumber.length();
		for (int i = 0; i < len; i++) {

			if (!Character.isDigit(phoneNumber.charAt(i))) {
				return false;

			}
		}

		return true;

	}


}

