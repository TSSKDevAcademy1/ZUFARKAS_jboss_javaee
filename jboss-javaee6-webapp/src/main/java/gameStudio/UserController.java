package gameStudio;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

//@Named
//@SessionScoped
@Model
public class UserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Produces
    @Named
    private RegisteredPerson newRegisteredPerson;
	
	@Inject
	private UserRegistrationBean userRegistrationBean;
	
	public void register() throws Exception {
		userRegistrationBean.register(newRegisteredPerson);
    }

}
