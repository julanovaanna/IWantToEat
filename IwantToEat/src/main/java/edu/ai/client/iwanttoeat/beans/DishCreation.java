package edu.ai.client.iwanttoeat.beans;

import edu.ai.client.iwanttoeat.FoodDAO;

import edu.ai.client.iwanttoeat.entity.*;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import servlet.ImageLocal;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
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
    private ImageLocal im;
    @EJB
    private FoodDAO foodDAO;
    private String dishName;
    private String ingridients;
    private String dishDescription;
    private String mainImgSrc;
    private UploadedFile mainImgFile;
    private List<ImageBean> images;
    int i=0;


    public DishCreation() {
        this.setMainImgSrc("/my_images/authors.png");
        images = new ArrayList<ImageBean>();
    }
    public void upload() {
        FacesMessage msg = new FacesMessage("Файл "+mainImgFile.getFileName() + " успешно загружен.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Файл", event.getFile().getFileName() + " успешно загружен.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        ImageBean imageBean = new ImageBean();
        imageBean.setUploadedFile(event.getFile());
        imageBean.setDescription("пусто");
        imageBean.setSrc(Integer.toString(i));
        images.add(imageBean);

        im.setImgFile(i,event.getFile());
        i++;
    }
    public String next1(){
        return "dishCreationStep2";
    }
    public void saveImages(){
        i =i+1;
        i=i-1;

    }
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getMainImgSrc() {
        return mainImgSrc;
    }

    public void setMainImgSrc(String mainImgSrc) {
        this.mainImgSrc = mainImgSrc;
    }

    public UploadedFile getMainImgFile() {
        return mainImgFile;
    }

    public List<ImageBean> getImages() {
        return images;
    }

    public void setImages(List<ImageBean> images) {
        this.images = images;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    public void persistDish(){
        Dish dish = new Dish();
        dish.setName(this.getDishName());
        dish.setDescription(this.getDishDescription());
        dish.setIngridients(this.getIngridients());
        dish.setProducts(this.getProductsFromIngrid());
        dish.setImages(this.getImagesFromInstruction());
        foodDAO.persistDish(dish);

    }

    private Collection<Image> getImagesFromInstruction() {
        List<Image> imageList = new ArrayList<Image>();
        for(ImageBean imageBean: images){
            Image image = new Image();
            image.setMode(imageBean.getMode());
            image.setContent(imageBean.getUploadedFile().getContents());
            image.setDescription(imageBean.getDescription());
            imageList.add(image);
        }
        Image imMain = new Image();
        imMain.setMode("main");
        imMain.setContent(getMainImgFile().getContents());
        imageList.add(imMain);
        return imageList;
    }

    private Collection<Product> getProductsFromIngrid() {
        List<Product> products = new ArrayList<Product>();
        String[] strings = this.getIngridients().split("\r\n");
        for (int i=0;i<strings.length;i++){
            String prodName = strings[i].split("^([а-я,А-Я]+ *)+\\(*\\-*")[0];
            Product productFromDB = foodDAO.isProductExist(prodName.substring(0,prodName.length()-2).trim());
            if(productFromDB==null){
                Product product = new Product();
                product.setName(prodName.substring(0,prodName.length()-2).trim());
                products.add(product);
            }else {
                products.add(productFromDB);
            }
        }
        return products;
    }

    public void setMainImgFile(UploadedFile mainImgFile) {
        this.mainImgFile = mainImgFile;
        im.setMainImgFile(mainImgFile);
        mainImgSrc="http://localhost:8080/IwantToEat-1.0-SNAPSHOT/ImageServlet?main=1";
    }
}
