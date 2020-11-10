/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
@WebServlet(name = "ServletLogeo", urlPatterns =
{
    "/ServletLogeo"
})
public class ServletLogeo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String us = request.getParameter("usuario");
        String pass = request.getParameter("contr");

        if (us.equals("admin") && pass.equals("admin"))
        {
            request.getSession().setAttribute("usuario", us);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/menuprincipal.jsp");
            rd.forward(request, response);

        } else
        {
            request.setAttribute("error", "Usuario o contraseña incorrecta incorrecto");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }


@Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
