package edu.ai.client.iwanttoeat.beans;

import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by IntelliJ IDEA.
 * User: anna
 * Date: 13.02.12
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class ImageBean {
    private UploadedFile uploadedFile;
    private String description;
    private String src;
    private String mode;

    public ImageBean() {
        src="http://localhost:8080/IwantToEat-1.0-SNAPSHOT/ImageServlet?index=";
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSrc() {
        return src;

    }

    public void setSrc(String src) {
        this.src = this.src.concat(src);
    }
}