package edu.ai.client.iwanttoeat.beans;

import edu.ai.client.iwanttoeat.FoodDAO;
import edu.ai.client.iwanttoeat.entity.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Анна
 * Date: 07.02.12
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean
@SessionScoped
public class newDish {
    @EJB
    FoodDAO foodDAO;
    private String prodName;
    private String amount;
    private String selectedMeasure;
    private List<String> measureList;
    private String ingridients;

    public newDish() {
        measureList = new ArrayList<String>();
        this.initMeasureList();
    }

    public List<String> complete(String query) {
        List<String> result = new ArrayList<String>();
        List<Product> productList = foodDAO.getProducts(query);
        for (Product prod : productList) {
            result.add(prod.getName());
        }
        return result;
    }

    private void initMeasureList() {
        this.measureList.add("гр");
        this.measureList.add("шт");
        this.measureList.add("ст.л");
        this.measureList.add("ч.л.");
        this.measureList.add("щ.");
        this.measureList.add("по вкусу");
    }

    public void saveIngr() {
        this.persistProdIfNotExist(this.getProdName());
        this.fillIngridients(this.getProdName(), this.getAmount(), this.getSelectedMeasure());
        this.clearFields();


    }

    private void clearFields() {
        this.prodName="";
        this.selectedMeasure="...";
        this.amount="";
    }

    private void fillIngridients(String prodName, String amount, String selectedMeasure) {
        if(prodName!=""){
        String spases = " ";
        for (int i = 0; i < 20 - prodName.length(); i++) {
            spases = spases.concat(" ");
        }
        this.ingridients.concat("\n").concat(prodName).concat(spases).
                concat((amount == "") ? "" : amount).concat(" ").concat((selectedMeasure == "...") ? "" : selectedMeasure);
        }


    }

    private void persistProdIfNotExist(String prodName) {
        if (foodDAO.isProductExist(prodName)!=null) {
            Product product = new Product();
            product.setName(prodName);
            foodDAO.persistProduct(product);
        }
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSelectedMeasure() {
        return selectedMeasure;
    }

    public void setSelectedMeasure(String selectedMeasure) {
        this.selectedMeasure = selectedMeasure;
    }

    public List<String> getMeasureList() {
        return measureList;
    }

    public void setMeasureList(List<String> measureList) {
        this.measureList = measureList;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }
}
