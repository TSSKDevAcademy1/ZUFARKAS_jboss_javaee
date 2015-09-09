package task1;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FormatterBean {
	@Inject
	@Informal // @Default//
	Messager messager;

	@Inject
	@Default
	Messager formalmessager;

	public String getFormattedMessage() {
		return messager.getMessage().toUpperCase() + " " + formalmessager.getMessage();

	}
}
