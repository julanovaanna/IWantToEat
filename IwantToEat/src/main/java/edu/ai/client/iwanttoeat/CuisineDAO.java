package edu.ai.client.iwanttoeat;

import edu.ai.client.iwanttoeat.entity.Cuisine;

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
public class CuisineDAO {
    @PersistenceContext(unitName = "sample ququ")
    EntityManager em;

    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public void persist(Cuisine cuisine){
        em.persist(cuisine);
    }
    public List<Cuisine> getCuisines(){
        return (List<Cuisine>)em.createQuery("from Cuisine").getResultList();
    }
}
