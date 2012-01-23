package edu.ai.client.iwanttoeat.beans;

import edu.ai.client.iwanttoeat.FoodDAO;

import edu.ai.client.iwanttoeat.entity.*;
import org.primefaces.event.FileUploadEvent;
import servlet.ImageLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Анна
 * Date: 04.01.12
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class DishCreation {
    @EJB
    private ImageLocal ImgFile;
    @EJB
    private FoodDAO foodDAO;
    private String dishName = "Пожалуйста, укажите название блюда...";
    private String dishDescription;
    private Cuisine selectedCuisine;
    private List<Cuisine> cuisines;
    private String cuisineName;
    private String cuisineDescription;
    private List<Disease> selectedDiseases;
    private List<Disease> diseases;
    private List<Vitamin> selectedVitamins;
    private List<Vitamin> vitamins;
    private String vitaminName;
    private String vitaminDescription;
    private String diseaseName;
    private String diagnosis;
    private String products;

    public DishCreation() {
        cuisines = new ArrayList<Cuisine>();
        selectedDiseases = new ArrayList<Disease>();
        selectedVitamins = new ArrayList<Vitamin>();
        diseases = new ArrayList<Disease>();
        vitamins = new ArrayList<Vitamin>();

    }
    public void handleSaveCuisine() {
        Cuisine cuisine = new Cuisine();
        cuisine.setName(this.getCuisineName());
        cuisine.setDescription(this.getCuisineDescription());
        foodDAO.persistCuisine(cuisine);
    }
    public void handleSaveVitamin() {
        Vitamin vitamin = new Vitamin();
        vitamin.setName(this.getVitaminName());
        vitamin.setDescription(this.getVitaminDescription());
        foodDAO.persistVitamin(vitamin);
    }
    public void handleSaveDisease() {
        Disease disease = new Disease();
        disease.setName(this.getDiseaseName());
        disease.setDiagnosis(this.getDiagnosis());
        foodDAO.persistDisease(disease);
    }
    public void submitDish(ActionEvent event){
        Dish dish = new Dish();
        dish.setName(this.getDiseaseName());
        dish.setDescription(this.getDishDescription());
        dish.setGoodFor(this.getSelectedDiseases());
        dish.setProducts(this.getProductsFromStr(this.getProducts()));
    }
    public List<Product> getProductsFromStr(String productsStr){
     List<Product> products = new ArrayList<Product>();
        String[] prodStrings = productsStr.split("(\\s*[А-Яа-я]+\\s*)+[0-9]*\\s*[А-Яа-я]*\\s*");
        for (int i=0;i<prodStrings.length;i++){
            Product product = new Product();
            String prodName = (prodStrings[i].split("[^/0-9]+"))[0];
            if (!foodDAO.isProductExist(prodName)){

            }
            product.setName((prodStrings[i].split("[^/0-9]+"))[0]);

        }
        return products;
    }
    public List<Vitamin> getSelectedVitamins() {
        return selectedVitamins;
    }

    public void setSelectedVitamins(List<Vitamin> selectedVitamins) {
        this.selectedVitamins = selectedVitamins;
    }

    public List<Vitamin> getVitamins() {
        return foodDAO.getVitamins();
    }

    public void setVitamins(List<Vitamin> vitamins) {
        this.vitamins = vitamins;
    }

    public List<Disease> getSelectedDiseases() {
        return selectedDiseases;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setSelectedDiseases(List<Disease> selectedDiseases) {
        this.selectedDiseases = selectedDiseases;
    }

    public List<Disease> getDiseases() {
        return foodDAO.getDiseases();
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public void handleFileUpload(FileUploadEvent event) {
        this.ImgFile.setImgFile(event.getFile());
    }

    public String getVitaminName() {
        return vitaminName;
    }

    public void setVitaminName(String vitaminName) {
        this.vitaminName = vitaminName;
    }

    public String getVitaminDescription() {
        return vitaminDescription;
    }

    public void setVitaminDescription(String vitaminDescription) {
        this.vitaminDescription = vitaminDescription;
    }

    public ImageLocal getImgFile() {
        return ImgFile;
    }

    public void setImgFile(ImageLocal imgFile) {
        ImgFile = imgFile;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public Cuisine getSelectedCuisine() {
        return selectedCuisine;
    }

    public void setSelectedCuisine(Cuisine selectedCuisine) {
        this.selectedCuisine = selectedCuisine;
    }

    public List<Cuisine> getCuisines() {
        return foodDAO.getCuisines();
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

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

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}
