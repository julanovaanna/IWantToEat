package edu.ai.client.iwanttoeat.beans;

import edu.ai.client.iwanttoeat.CuisineDAO;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import edu.ai.client.iwanttoeat.DishDAO;
import edu.ai.client.iwanttoeat.entity.Cuisine;
import edu.ai.client.iwanttoeat.entity.Disease;
import edu.ai.client.iwanttoeat.entity.Dish;
import edu.ai.client.iwanttoeat.entity.Product;
import org.primefaces.event.FileUploadEvent;
import servlet.ImageLocal;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Manifest;

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
    private String name;
    private String msg;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private String img;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    private UploadedFile file;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private Cuisine cuisine;
    private String description;
    private List<String> selectedCuisines;
    private Map<String,String> mapCuisines;

    @EJB
    private CuisineDAO cuisineDAO;

    public Map<String, String> getMapCuisines() {
        return mapCuisines;
    }

    public void setMapCuisines(Map<String, String> mapCuisines) {
        this.mapCuisines = mapCuisines;
    }

    public DishCreation() {
        selectedCuisines = new ArrayList<String>();
        mapCuisines = new HashMap<String,String>();
    }

    private Cuisine createCuisine(String name, String description) {
        Cuisine cuisine = new Cuisine();
        cuisine.setName(name);
        cuisine.setDescription(description);
        return cuisine;
    }

    public String getName() {
        return name;
    }

    public List<String> getSelectedCuisines() {
        return selectedCuisines;
    }

    public void setSelectedCuisines(List<String> selectedCuisines) {
        this.selectedCuisines = selectedCuisines;
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        this.ImgFile.setImgFile(event.getFile());
        setImg("http://localhost:8080/IwantToEat-1.0-SNAPSHOT/ImageServlet");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public Map<String,String> getCuisines() {
        List<Cuisine> cuisines = cuisineDAO.getCuisines();
        for (Cuisine cuisine:cuisines){
            mapCuisines.put(cuisine.getName(),Integer.toString(cuisine.getId()));
        }
        return mapCuisines;
    }

    public void setCuisines(Map<String, String> cuisines) {
        this.mapCuisines = cuisines;
    }

    public String test(){
        return "CreateDish";
    }
     public String test1(){
         List<String> cuisineList = this.getSelectedCuisines();
        for (String cuisine:cuisineList){
           String s = cuisine;
           String r = s;
        }
        return "index";
    }
    public void setName(String name) {
        this.name = name;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public List<Disease> getGoodFor() {
        return goodFor;
    }

    public void setGoodFor(List<Disease> goodFor) {
        this.goodFor = goodFor;
    }

    int difficulty;
    String products;
    List<Disease> goodFor;
}
