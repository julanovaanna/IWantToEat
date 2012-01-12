package edu.ai.client.iwanttoeat;

import edu.ai.client.iwanttoeat.entity.Cuisine;
import edu.ai.client.iwanttoeat.entity.Disease;
import edu.ai.client.iwanttoeat.entity.Dish;
import edu.ai.client.iwanttoeat.entity.Product;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Анна
 * Date: 04.01.12
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class DishDAO {
    @PersistenceContext(unitName = "sample")
    EntityManager em;

    public List<Dish> getDishes(List<Product> products) {
        List<Dish> properDishes = new ArrayList<Dish>();
        List<Dish> dishes = em.createQuery("from Dish").getResultList();
        for (Dish dish : dishes) {
            if (products.containsAll(dish.getProducts())) {
                properDishes.add(dish);
            }
        }
    return dishes;
    }
    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public void persist(Cuisine cuisine, String description,int difficulty, List<Disease> goodFor,List<Product> products){
        Dish dish = new Dish();
        dish.setCuisine(cuisine);
        dish.setDescription(description);
        dish.setDifficulty(difficulty);
        dish.setGoodFor(goodFor);
        dish.setProducts(products);
        em.persist(cuisine);
    }

}
