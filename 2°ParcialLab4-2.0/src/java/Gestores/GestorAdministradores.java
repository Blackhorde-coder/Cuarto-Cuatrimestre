/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelos.Socio;
import Modelos.TipoDocumento;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class GestorAdministradores {

    public String STRINGCON = "jdbc:sqlserver://BLACKHORDENOT:1500;databaseName=ClubDeBarrio";
    private String USER = "sa";
    private String PASS = "34671716";
    private Connection conn;

    private void abrirConexion() {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(STRINGCON, USER, PASS);
        } catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    private void cerrarConexion() {
        try
        {
            if (conn != null && !conn.isClosed())
            {
                conn.close();
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean getAdministrador(String usuario, String contraseña) 
    {
        boolean existe = false;
        try
        {
            
            abrirConexion();
            PreparedStatement st = conn.prepareStatement("select * from Administradores\n"
                                                        + "where usuario=? and contraseña=? and habilitado=1");
            st.setString(1, usuario);
            st.setString(2, contraseña);
            ResultSet rs =  st.executeQuery();
            if(rs != null)
            {
                existe = true;

            }

            st.close();
        } catch (SQLException exc)
        {
            exc.printStackTrace();
        } finally
        {
            cerrarConexion();
            return existe;
        }
      
    }
}
