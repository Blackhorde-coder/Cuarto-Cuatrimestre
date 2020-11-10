/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;
import Modelos.Socio;
import Modelos.TipoDocumento;
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
public class GestorSocios 
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
    public void getAgregarSocio(Socio s)
    {
        try 
        {
            abrirConexion(); 
            PreparedStatement st = conn.prepareStatement("insert into socios "
                                                        +"(nombre, apellido, documento,idtipodoc,direccion,numero,localidad,telefono,email,habilitado)\n" +
                                                         "values (?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, s.getNombre());
            st.setString(2, s.getApellido());
            st.setInt(3, s.getDocumento());
            st.setInt(4, s.getTipodocumento());
            st.setString(5, s.getDireccion());
            st.setInt(6, s.getNumero());
            st.setString(7, s.getLocalidad());
            st.setString(8, s.getTelefono());
            st.setString(9, s.getEmail());
            st.setBoolean(10, s.isHabilitado());
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
    public void getActualizarSocio(Socio s)
    {
        try 
        {
            abrirConexion(); 
            PreparedStatement st = conn.prepareStatement("update socios\n" +
                                                         "set nombre = ?, apellido=?,idtipodoc=?,direccion=?,numero=?,localidad=?,telefono=?,email=?,habilitado=?\n" +
                                                         "where documento=?");
            st.setString(1, s.getNombre());
            st.setString(2, s.getApellido());     
            st.setInt(3, s.getTipodocumento());
            st.setString(4, s.getDireccion());
            st.setInt(5, s.getNumero());
            st.setString(6, s.getLocalidad());
            st.setString(7, s.getTelefono());
            st.setString(8, s.getEmail());
            st.setBoolean(9, s.isHabilitado());
            st.setInt(10, s.getDocumento());
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
    public ArrayList<Socio> getListaSocios()
    {
        ArrayList<Socio> lista = new ArrayList<Socio>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from socios");
            
            while(rs.next())
            {
                String  nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int documento = rs.getInt("documento");
                int tipodocumento = rs.getInt("idtipodoc");
                String direccion = rs.getString("direccion");
                int numero = rs.getInt("numero");
                String localidad = rs.getString("localidad");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                boolean habilitado = rs.getBoolean("habilitado");
                
                Socio s = new Socio(nombre, apellido, documento, tipodocumento, direccion, numero, localidad, telefono, email, habilitado);
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
    public ArrayList<TipoDocumento> getTipoDocumentos()
    {
        ArrayList<TipoDocumento> lista = new ArrayList<TipoDocumento>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from TiposDocumentos");
            
            while(rs.next())
            {
                int idtipodoc=rs.getInt("idtipodoc");
                String  detalle = rs.getString("detalle");
                TipoDocumento td = new TipoDocumento(idtipodoc, detalle);
                lista.add(td);
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
