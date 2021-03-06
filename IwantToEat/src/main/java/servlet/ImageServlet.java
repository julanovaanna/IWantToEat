package servlet;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Анна
 * Date: 10.01.12
 * Time: 23:01
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ImageServlet", urlPatterns = "/ImageServlet")
public class ImageServlet extends HttpServlet{
    @EJB
    private ImageLocal Img;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("main")!=null){
        if (Integer.parseInt(request.getParameter("main"))==1){
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            byte[] img = Img.getMainImgFile().getContents();
            os.write(img);
            os.flush();
        }
        }

        if (Img.getImgFile(Integer.parseInt(request.getParameter("index"))) != null){
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        byte[] img = Img.getImgFile(Integer.parseInt(request.getParameter("index"))).getContents();
        os.write(img);
        os.flush();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }
}
