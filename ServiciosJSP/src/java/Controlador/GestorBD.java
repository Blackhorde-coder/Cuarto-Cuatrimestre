/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelos.Servicio;
import java.sql.*;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class GestorBD 
{
    public String STRINGCON="jdbc:sqlserver://BLACKHORDENOT:1500;databaseName=Produccion";
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
    public ArrayList<Servicio> listaServicios()
    {
        ArrayList<Servicio> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Servicios");
            
            while(rs.next())
            {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                double costo = rs.getDouble("costo");
                Servicio s = new Servicio(id, tipo, descripcion, costo);
                lista.add(s);
            }
            rs.close();
            st.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        return lista;
    }
    
    
}
