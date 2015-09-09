package gameStudio;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.model.Member;

@Stateless
public class UserRegistrationBean{

	@Inject
    private EntityManager em;
	
	public void register(RegisteredPerson member) throws Exception {
       
        em.persist(member);
      
    }
}
