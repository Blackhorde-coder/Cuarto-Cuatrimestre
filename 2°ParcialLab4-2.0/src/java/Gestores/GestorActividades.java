/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelos.Actividad;
import Modelos.Publicacion;
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
public class GestorActividades {

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

    public void getAgregarActividad(Actividad a) {
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
        } catch (SQLException exc)
        {
            exc.printStackTrace();
        } finally
        {
            cerrarConexion();
        }
    }

    public ArrayList<Actividad> getListaActividad() {
        ArrayList<Actividad> lista = new ArrayList<Actividad>();
        try
        {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from actividades");

            while (rs.next())
            {
                int idActividad = rs.getInt("idactividad");
                String detalle = rs.getString("detalle");
                double costo = rs.getDouble("costo");
                boolean habilitado = rs.getBoolean("habilitado");
                Actividad a = new Actividad(idActividad, detalle, costo, habilitado);
                lista.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } finally
        {
            cerrarConexion();
        }
        return lista;
    }

}
