package edu.ai.client.iwanttoeat.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anna
 * Date: 13.02.12
 * Time: 11:00
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class imageSwitchBean {
    public class Img{
        private String src;
        private String description;

        public Img(String src, String description) {
            this.src = src;
            this.description = description;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
    private List<Img> images;

    public imageSwitchBean() {
        images = new ArrayList<Img>();
        images.add(new Img("/Smetannik/1.jpg", "Brouse"));
        images.add(new Img("/Smetannik/2.jpg","Cancel"));
    }

    public List<Img> getImages() {
        return images;
    }

    public void setImages(List<Img> images) {
        this.images = images;
    }
}
