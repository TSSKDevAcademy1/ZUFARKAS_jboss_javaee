package task1;

import javax.enterprise.inject.Default;

@Default
public class FormalMessagerBean implements Messager {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dobry den";
	}

}
