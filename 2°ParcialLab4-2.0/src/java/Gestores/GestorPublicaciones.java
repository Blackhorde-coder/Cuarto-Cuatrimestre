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
public class GestorPublicaciones {

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

    public void getAgregarPublicacion(Publicacion p) {
        try
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement("insert into publicaciones (idactividad, texto,fecha,habilitado) values (?,?,?,?)");
            st.setInt(1, p.getIdActividad());
            st.setString(2, p.getTexto());
            st.setString(3, p.getFecha());
            st.setBoolean(4, p.isHabilitado());
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

    public ArrayList<Publicacion> getListaPublicaciones() {
        ArrayList<Publicacion> lista = new ArrayList<Publicacion>();
        try
        {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from publicaciones");

            while (rs.next())
            {
                int idpublicacion = rs.getInt("idpublicacion");
                int idactividad = rs.getInt("idactividad");
                String texto = rs.getString("texto");
                String fecha = rs.getString("fecha");
                boolean habilitado = rs.getBoolean("habilitado");
                Publicacion p = new Publicacion(idpublicacion, idactividad, texto, fecha, habilitado);
                lista.add(p);
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

    public ArrayList<Publicacion> getListaPublicacionesFiltrada(int actividad) {
        ArrayList<Publicacion> lista = new ArrayList<Publicacion>();
        try
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement("select * from publicaciones\n"
                    + "where idactividad = ? ");
            st.setInt(1, actividad);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                int idpublicacion = rs.getInt("idpublicacion");
                int idactividad = rs.getInt("idactividad");
                String texto = rs.getString("texto");
                String fecha = rs.getString("fecha");
                boolean habilitado = rs.getBoolean("habilitado");
                Publicacion p = new Publicacion(idpublicacion, idactividad, texto, fecha, habilitado);
                lista.add(p);
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

    public Publicacion getPublicacion(int id) {
        Publicacion p = new Publicacion();
        try
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement("select * from publicaciones\n"
                    + "where idpublicacion=? ");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                int pid = rs.getInt("idpublicacion");
                int pida = rs.getInt("idactividad");
                String ptext = rs.getString("texto");
                String pfecha = rs.getString("fecha");
                Boolean phabilitado = rs.getBoolean("habilitado");
                p.setIdPublicacion(pid);
                p.setIdActividad(pida);
                p.setTexto(ptext);
                p.setFecha(pfecha);
                p.setHabilitado(phabilitado);
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
        return p;
    }

    public void getEditarPublicacion(Publicacion p) {
        try
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement("update publicaciones\n"
                    + "set idactividad=?, texto=?, fecha=?, habilitado=?\n"
                    + "where idpublicacion=?");
            st.setInt(1, p.getIdActividad());
            st.setString(2, p.getTexto());
            st.setString(3, p.getFecha());
            st.setBoolean(4, p.isHabilitado());
            st.setInt(5, p.getIdPublicacion());
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

}
