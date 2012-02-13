package edu.ai.client.iwanttoeat;

import edu.ai.client.iwanttoeat.entity.Cuisine;
import edu.ai.client.iwanttoeat.entity.Disease;
import edu.ai.client.iwanttoeat.entity.Product;
import edu.ai.client.iwanttoeat.entity.Vitamin;
import org.apache.commons.io.filefilter.FalseFileFilter;
import sun.font.TrueTypeFont;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Анна
 * Date: 02.01.12
 * Time: 21:08
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class FoodDAO {
    @PersistenceContext(unitName = "sample")
    EntityManager em;

    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public void persistCuisine(Cuisine cuisine){
        em.persist(cuisine);
    }
    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
     public void persistVitamin(Vitamin vitamin){
        em.persist(vitamin);
    }
    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public void persistDisease(Disease disease){
        em.persist(disease);
    }
    @TransactionAttribute (value = TransactionAttributeType.REQUIRES_NEW)
    public void persistProduct(Product product){
        em.persist(product);
    }
    public List<Cuisine> getCuisines(){
        List<Cuisine> cuisines = (List<Cuisine>)em.createQuery("from Cuisine").getResultList();
        return cuisines;
    }
    public List<Disease> getDiseases(){
        List<Disease> Diseases = (List<Disease>)em.createQuery("from Disease").getResultList();
        return Diseases;
    }
    public List<Vitamin> getVitamins(){
        List<Vitamin> Vitamins = (List<Vitamin>)em.createQuery("from Vitamin").getResultList();
        return Vitamins;
    }
    public List<Product> getProducts(String beginning){
        beginning = beginning+'%';
        List<Product> products = (List<Product>)em.createQuery("from Product p where upper(p.name) like upper(:prodName)").setParameter("prodName",beginning).getResultList();
        return products;
    }
    public boolean isProductExist(String productName){

        Product product = (Product)em.createQuery("from Product p where upper(p.name)like upper(:prodName)").setParameter("prodName", productName).getSingleResult();
        return product!=null;
    }
}
