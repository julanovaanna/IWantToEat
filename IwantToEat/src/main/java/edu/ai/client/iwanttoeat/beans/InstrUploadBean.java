package edu.ai.client.iwanttoeat.beans;

import org.primefaces.event.FileUploadEvent;
import servlet.ImageLocal;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anna
 * Date: 13.02.12
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class InstrUploadBean {
    @EJB
    private ImageLocal imageLocal;
    private List<ImageBean> images;
    int i=0;
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        ImageBean imageBean = new ImageBean();
        imageBean.setUploadedFile(event.getFile());

        imageBean.setDescription("пусто");
        images.add(imageBean);
        imageLocal.setImgFile(i,event.getFile());
        i++;
    }
    public void saveImages(){
        int i=0;
        for (ImageBean iBean: images){
            iBean.setSrc(Integer.toString(i));
            i++;
        }
    }
    public InstrUploadBean() {
        images = new ArrayList<ImageBean>();
    }

    public List<ImageBean> getImages() {
        return images;
    }

    public void setImages(List<ImageBean> images) {
        this.images = images;
    }
}
