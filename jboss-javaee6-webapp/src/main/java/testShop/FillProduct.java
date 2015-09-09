package testShop;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
public class FillProduct {
	
	@Inject
	EntityManager em;
	
	public void addProduct(Product product) {
		em.persist(product);
	}
	
	
	public void updateProduct(long id, Product product){
		//@NamedQuery(name="updateProduct", query = "UPDATE Product p SET p.productName = :productName AND p.price = :price WHERE p.id = :id")	
	
		Query query = em.createNamedQuery("updateProduct");
		query.setParameter("prodctName", product.getProductName());
		query.setParameter("price", product.getProductName());
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	public void removeProduct(Long id) {
		em.createQuery("DELETE FROM Product p WHERE p.id = :id").setParameter("id", id).executeUpdate();
		}

}
