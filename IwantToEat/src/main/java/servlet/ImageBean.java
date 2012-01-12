package servlet;

import org.primefaces.model.UploadedFile;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Анна
 * Date: 10.01.12
 * Time: 23:05
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@Local(ImageLocal.class)
public class ImageBean implements ImageLocal{
    private UploadedFile imgFile;
    @Override
    public UploadedFile getImgFile() {
        return this.imgFile;
    }

    @Override
    public void setImgFile(UploadedFile file) {
        this.imgFile = file;
    }
}
