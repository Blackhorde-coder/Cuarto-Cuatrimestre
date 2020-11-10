/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelos.Actividad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class GestorActividades 
{
    public String STRINGCON="jdbc:sqlserver://BLACKHORDENOT:1500;databaseName=ClubDeBarrio";
    private String USER="sa";
    private String PASS = "34671716";
    private Connection conn;
 
    private void abrirConexion()
    {
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(STRINGCON, USER,PASS );
        } 
        catch (Exception exc) 
        {
            exc.printStackTrace();        
        }
    }
    private void cerrarConexion()
    {
        try 
            {
                if(conn != null && !conn.isClosed())
                conn.close();
            } 
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
    }
    public void getAgregarActividad(Actividad a)
    {
        try 
        {
            abrirConexion(); 
            PreparedStatement st = conn.prepareStatement("insert into actividades (detalle,costo,habilitado) values (?,?,?)");
            st.setString(1, a.getDetalle());
            st.setDouble(2, a.getCosto());
            st.setBoolean(3, a.isHabilitado());
            st.executeUpdate(); //para insert, update, delete
                                // executeQuerry() para sentencias select
                               //execute () mas general.... pero es mas c-omplejo 
            st.close();       
        } 
        catch (SQLException exc) 
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
    }
}
