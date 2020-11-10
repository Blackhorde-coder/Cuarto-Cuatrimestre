package Gestores;

import Modelos.Oferta;
import Modelos.Producto;
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
public class GestorBD 
{
    public String STRINGCON="jdbc:sqlserver://BLACKHORDENOT:1500;databaseName=Supermercado";
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
    
    public ArrayList<Producto> listaProductos()
    {
        ArrayList<Producto> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Producto");
            
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Producto p = new Producto(id, nombre);
                lista.add(p);
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
    public void agregarOferta(Oferta o) throws ClassNotFoundException
    {
        try 
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement(   "insert into Oferta (idProducto, precioNormal, precioOferta, stockDisponible, fechaInicioOferta, diasVigencia)\n" +
                                                            "values (?,?,?,?,?,5)");
            st.setInt(1, o.getIdProducto());
            st.setDouble(2, o.getPrecioNormal());
            st.setDouble(3, o.getPrecioOferta());
            st.setInt(4, o.getStock());
            st.setString(5, o.getFechaInicioOferta());
            st.setInt(6, o.getDiasOferta());
            st.executeUpdate();
            st.close();
        } 
        catch (Exception exc) 
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
    }
    public double totalNoGanadoPorProductoOfertado(int idProducto)
    {
        double total = 0;
        String sql =    "select sum((precioNormal - precioOferta)*stockDisponible)\n" +
                        "from Oferta\n" +
                        "where idProducto = ?";
        try 
        {
            abrirConexion();
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idProducto);
            ResultSet rs = st.executeQuery();
            rs.next();
            total = rs.getDouble(1);
            st.close();
        } 
        catch (Exception exc) 
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        return total;
    }
}
