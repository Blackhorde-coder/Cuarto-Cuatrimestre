/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
@WebServlet(name = "Subida", urlPatterns =
{
    "/Subida"
})
@MultipartConfig(
        fileSizeThreshold = 1024*1024,
        maxFileSize = 1024*1024*5,
        maxRequestSize = 1024*1024*6,
        location = "C:/Users/Blackhorde/Documents/NetBeansProjects/ServletsWEB/web/Archivos"
)
public class Subida extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        for( Part part: request.getParts())
        {
            String fileName = getFileName(part);
            if(!fileName.isEmpty())
                part.write(fileName);
        } 
    }
    private String getFileName (Part part)
    {
        for(String content: part.getHeader("content-disposition").split(";"))
        {
            if(content.trim().startsWith("filename"))
            {
                return content.substring(content.indexOf("=")+2, content.length()-1);
            }
        }
        return "";
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
