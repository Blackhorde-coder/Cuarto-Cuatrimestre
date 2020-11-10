/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlest;

import gestores.GestorPersonas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EstadoCivil;
import modelo.Persona;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
@WebServlet(name = "NuevaPersona", urlPatterns = {"/NuevaPersona"})
public class NuevaPersona extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestorPersonas gestor = new GestorPersonas();
        ArrayList <EstadoCivil> lista = gestor.obtenerEstadosCiviles();
        request.setAttribute("lista", lista);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevaPersona.jsp");
        rd.forward(request, response);
        


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
//        String nombre = request.getParameter("txtNombre");
//        String apellido = request.getParameter("txtApellido");
//        int edad =Integer.parseInt(request.getParameter("txtEdad"));
//        int idEstadoCivil = Integer.parseInt(request.getParameter("cboEstadoCivil"));
//        
//        EstadoCivil nuevoEC = new EstadoCivil(idEstadoCivil, "");
//        Persona p = new Persona(0,nombre, apellido,edad, nuevoEC);
        
        GestorPersonas gestor = new GestorPersonas ();
        gestor.agregar((Persona)request.getSession().getAttribute("nuevaPersona"));
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cargar nueva persona</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Persona cargada correctametne</h1>");
            out.println("</body>");            
            out.println("</html>");                             
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>

}
