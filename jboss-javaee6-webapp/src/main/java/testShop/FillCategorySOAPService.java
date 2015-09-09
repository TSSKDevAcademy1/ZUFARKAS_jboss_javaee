package testShop;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jws.WebService;

@WebService
@Singleton
public class FillCategorySOAPService {

	@Inject
	FillCategory categ;

	/**
	 * @param category
	 * @see testShop.FillCategory#addcategory(testShop.Category)
	 */
	public void addcategory(Category category) {
		categ.addcategory(category);
	}
	
	
}
