package servlet;

import org.primefaces.model.UploadedFile;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
    private List<UploadedFile> imgFiles;

    public ImageBean() {
        imgFiles = new ArrayList<UploadedFile>();
    }

    @Override
    public UploadedFile getImgFile(int index) {
        return this.imgFiles.get(index);
    }


    @Override
    public void setImgFile(int index, UploadedFile file) {
        this.imgFiles.add(index,file);
    }
}
