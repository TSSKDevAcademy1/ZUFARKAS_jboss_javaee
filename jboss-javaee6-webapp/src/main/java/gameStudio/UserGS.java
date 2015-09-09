package gameStudio;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class UserGS implements Serializable {
	
	@Size(min=5, max=10)
	private String userName;

	@Size(min=5, max=10)
	@Pattern(regexp=".*\\d.*")
	private String password;

	/**
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param name the name to set
	 */
	public void setUserName(String name) {
		this.userName = name;
	}

	/**
	 * @return the passwordd
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
