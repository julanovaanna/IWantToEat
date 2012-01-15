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
    private String dishName;
    private String dishDescription;
    private Cuisine selectedCuisine;
    private List<Cuisine> cuisines;
    private String cuisineName;
    private String cuisineDescription;

    public DishCreation() {
        cuisines = new ArrayList<Cuisine>();

    }

    public void handleFileUpload(FileUploadEvent event) {
        this.ImgFile.setImgFile(event.getFile());
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
        Cuisine c = new Cuisine();
        c.setName("Японская");
        c.setDescription("Суши, роллы");
        cuisines.add(c);
        Cuisine c1 = new Cuisine();
        c1.setName("Армянская");
        c1.setDescription("Мяяясо");
        cuisines.add(c1);
        return cuisines;
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
}
