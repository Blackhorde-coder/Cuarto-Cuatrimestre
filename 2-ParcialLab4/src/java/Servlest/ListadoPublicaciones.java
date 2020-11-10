/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlest;

import Gestores.GestorActividades;
import Gestores.GestorAdministradores;
import Modelos.Publicacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ListadoPublicaciones", urlPatterns =
{
    "/ListadoPublicaciones"
})
public class ListadoPublicaciones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        int idactividad = Integer.parseInt(request.getParameter("actividad"));
        GestorActividades gestor = new GestorActividades();
        ArrayList<Publicacion> lista = gestor.getListaPublicacionesFiltrada(idactividad);
        request.getSession().setAttribute("listapublicaciones", lista);

        if (request.getSession().getAttribute("origen") == "noticias")
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/noticias.jsp");
            rd.forward(request, response);

        } else if (request.getSession().getAttribute("origen") == "publicaciones")
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoPublicaciones.jsp");
            rd.forward(request, response);

        }
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
