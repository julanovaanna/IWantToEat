package edu.ai.client.iwanttoeat.beans;

import edu.ai.client.iwanttoeat.CuisineDAO;
import edu.ai.client.iwanttoeat.entity.Cuisine;
import edu.ai.client.iwanttoeat.entity.Dish;

import javax.ejb.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Анна
 * Date: 20.12.11
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped

public class IndexBean {
    @PersistenceContext(unitName = "sample")
    private EntityManager em;
    private String dishName;
    private String cuisineName;
    private String cuisineDescription;



    public String getUsersProducts() {
        return usersProducts;
    }

    public void setUsersProducts(String usersProducts) {
        this.usersProducts = usersProducts;
    }

    private String usersProducts;

    @EJB
    CuisineDAO cuisineDAO;

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public String getCuisineDescription() {
        return cuisineDescription;
    }

    public void setCuisineDescription(String cuisineDescription) {
        this.cuisineDescription = cuisineDescription;
    }

    public String getDishName() {
        Dish result = null;
        try {
            result = (Dish) em.createQuery("from Dish d where d.id=1 ").getSingleResult();
        } catch (NoResultException ignore){

        }

        return (result == null? "not found": result.getDescription());
    }

    public String persistCuisine(){
        Cuisine cuisine = new Cuisine();
        cuisine.setName(getCuisineName());
        cuisine.setDescription(getCuisineDescription());
        cuisineDAO.persist(cuisine);
        setCuisineName("ttttt");
        String st = "ry,eth,ryhj,ryj";
        String[] star = st.split("[а-я,А-Я]");
        String k;
        return "index";
    }
}
