package servlet;

import org.primefaces.model.UploadedFile;

import javax.ejb.Local;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Анна
 * Date: 10.01.12
 * Time: 23:07
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface ImageLocal {
    public UploadedFile getImgFile(int index);
    public void setImgFile(int index, UploadedFile file);
    public UploadedFile getMainImgFile();
    public void setMainImgFile(UploadedFile uploadedFile);

}
