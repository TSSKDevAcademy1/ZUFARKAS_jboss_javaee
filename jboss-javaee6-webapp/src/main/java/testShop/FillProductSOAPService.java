package testShop;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jws.WebService;

@WebService
@Singleton
public class FillProductSOAPService {

	@Inject
	FillProduct prod;

	/**
	 * @param product
	 * @see testShop.FillProduct#addProduct(testShop.Product)
	 */
	public void addProduct(Product product) {
		prod.addProduct(product);
	}
	
	
}
