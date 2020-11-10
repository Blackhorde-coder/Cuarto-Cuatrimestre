/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlest;

import Gestores.GestorActividades;
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
@WebServlet(name = "ModificarPublicacion", urlPatterns =
{
    "/ModificarPublicacion"
})
public class ModificarPublicacion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String idpublicacion = (String) request.getParameter("id");
        int id = Integer.parseInt(idpublicacion);
        String idestado = (String) request.getParameter("estado");
        int estado = Integer.parseInt(idestado);
        
        
        if (estado == 1)
        {
            GestorActividades gestor = new GestorActividades();
            Publicacion p = gestor.getPublicacion(id);
            
            request.getSession().setAttribute("publicacion", p);
            request.getSession().setAttribute("estado", estado);
            request.getSession().setAttribute("idpublicacion", idpublicacion);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/editarPublicacion.jsp");
            rd.forward(request, response);
        } else if (estado == 2)
        {
            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
