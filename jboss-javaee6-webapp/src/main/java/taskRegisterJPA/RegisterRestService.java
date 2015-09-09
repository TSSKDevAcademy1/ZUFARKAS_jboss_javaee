package taskRegisterJPA;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.tools.examples.data.MemberRepository;
import org.jboss.tools.examples.model.Member;
import org.jboss.tools.examples.service.MemberRegistration;

@Path("/persons")
@RequestScoped
public class RegisterRestService {

	@Inject
	Register1 register;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person1> listAllPersons() {
		return register.listAllPersons();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person1 getPerson(@PathParam("id") long id) {

		Person1 person = register.getPerson(id);
		if (person == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return person;
	}
}
