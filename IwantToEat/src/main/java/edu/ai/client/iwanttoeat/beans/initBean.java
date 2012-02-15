package edu.ai.client.iwanttoeat.beans;

import edu.ai.client.iwanttoeat.FoodDAO;
import edu.ai.client.iwanttoeat.entity.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by IntelliJ IDEA.
 * User: Анна
 * Date: 07.02.12
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean
@SessionScoped
public class initBean {
    @EJB
    FoodDAO foodDAO;
    private String productName;
    public void persistProduct(){
        Product product = new Product();
        product.setName(this.getProductName());
        foodDAO.persistProduct(product);
        this.setProductName("");
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
