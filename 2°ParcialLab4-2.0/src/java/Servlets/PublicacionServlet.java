/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorActividades;
import Gestores.GestorPublicaciones;
import Modelos.Publicacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
@WebServlet(name = "PublicacionServlet", urlPatterns =
{
    "/PublicacionServlet"
})
public class PublicacionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Publicacion p = (Publicacion) request.getSession().getAttribute("Publicacion");
//        GestorPublicaciones gestor = new GestorPublicaciones();
        RequestDispatcher rd;
        String idtipo = (String) request.getParameter("tipo");
        int tipo = (Integer.parseInt(idtipo));
        
        System.out.println(p.getIdPublicacion());
        System.out.println(p.getFecha());
        System.out.println(p.getIdActividad());
        System.out.println(p.getTexto());
        System.out.println(p.isHabilitado());

//        if (tipo==1)
//        {
//            gestor.getAgregarPublicacion(p);
//            rd = getServletContext().getRequestDispatcher("/index.jsp");
//            rd.forward(request, response);
//        } 
//        else
//        {
////            gestor.getAgregarPublicacion((Publicacion) request.getSession().getAttribute("cargarPublicacion"));
//            rd = getServletContext().getRequestDispatcher("/cargarPublicacion.jsp");
//            rd.forward(request, response);
//        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
