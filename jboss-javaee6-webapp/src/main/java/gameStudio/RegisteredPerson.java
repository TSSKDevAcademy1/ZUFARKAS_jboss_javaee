package gameStudio;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//@SuppressWarnings("serial")
@Entity
//@Named
public class RegisteredPerson implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;

	/** First name of this person. */
	
	@NotNull
	@Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String firstName;
	
	@NotNull
	@Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String lastName;
	
	@NotNull
	@Size(min=5, max=10)
	private String userName;
	
	@NotNull
	@Size(min=5, max=10)
	@Pattern(regexp=".*\\d.*")
	private String password;

	public RegisteredPerson() {
		
	}
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the secondName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param secondName
	 *            the secondName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	private boolean isValidUserName(String username) {
		return username != null && username.length() >= 5 && username.length() <= 10;
	}

	private boolean isValidPassword(String passwd) {
		return isValidUserName(passwd) && passwd.matches(".*\\d.*");
	}

}
