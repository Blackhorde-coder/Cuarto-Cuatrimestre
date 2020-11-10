package Controladores;
import Modelos.Componente;
import Modelos.DTOreporte;
import Modelos.Produccion;
import Modelos.Responsable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708.
 */
public class ControladorBD 
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
        catch (Exception ex) 
        {
            ex.printStackTrace();        
        }
    }
    private void cerrarConexion()
    {
        try 
            {
                if(conn != null && !conn.isClosed())
                conn.close();
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
    }
    public ArrayList<Componente> listaComponentes()
    {
        ArrayList<Componente> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "select * from Componente");
            
            while(rs.next())
            {
                int idComponente = rs.getInt("idComponente");
                String descripcion = rs.getString("descripcion");
                Componente c = new Componente(idComponente,descripcion);
                lista.add(c);
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
    public ArrayList<Responsable> listaResponsables()
    {
        ArrayList<Responsable> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "select * from responsable");
            
            while(rs.next())
            {
                int idResponsable = rs.getInt("idResponsable");
                String nombre = rs.getString("nombre");
                Responsable c = new Responsable(idResponsable,nombre);
                lista.add(c);
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
    public void altaProduccion(Produccion p) throws ClassNotFoundException
    {
        try 
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement(   "insert into produccion(idResponsable,idComponente,cantidadProduccion,fecha) \n" +
                                                            "values (?,?,?,?)");
            st.setInt(1, p.getResponsable().getIdResponsable());
            st.setInt(2, p.getComponente().getIdComponente());
            st.setInt(3, p.getCantidad());
            st.setString(4, p.getFecha());
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
    public ArrayList<Produccion> listaProduccion()
    {
        ArrayList<Produccion> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "select p.idProduccion 'id',p.fecha 'fecha', p.cantidadProduccion 'cantidad', c.descripcion 'componente', r.nombre 'responsable'\n" +
                                            "from Produccion p\n" +
                                            "join Componente c on c.idComponente=p.idComponente\n" +
                                            "join Responsable r on r.idResponsable=p.idResponsable");
            
            while(rs.next())
            {
                String fecha = rs.getString("fecha");
                int id = rs.getInt("id");
                int cantidad = rs.getInt("cantidad");
                Componente c = new Componente();
                c.setDescripcion(rs.getString("componente"));
                Responsable r = new Responsable();
                r.setNombre(rs.getString("responsable"));
                Produccion p = new Produccion(id,r,c,cantidad,fecha);
                
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
    public DTOreporte produccionTotal(int idResponsable)
    {
        DTOreporte reporte = null;
        try 
        {
            abrirConexion(); 
            String sql=         "select r.nombre, sum(p.cantidadProduccion)\n" +
                                "from Responsable r\n" +
                                "join Produccion p on r.idResponsable=p.idResponsable\n" +
                                "where r.idResponsable=?\n" +
                                "group by r.nombre";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setDouble(1, idResponsable);//setear el parametro
            ResultSet rs = st.executeQuery();//no va aca la sobrecarga
            reporte = new DTOreporte();
            rs.next();
            reporte.setNombre(rs.getString(1));
            reporte.setCantidad(rs.getInt(2));
            
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
        return reporte;
    }
    public void modificarProduccion(Produccion p) throws ClassNotFoundException
    {
        try 
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement(   "update Produccion \n" +
                                                            "set fecha= ?, cantidadProduccion=?\n" +
                                                            "where idProduccion = ?");
            st.setString(1, p.getFecha());
            st.setInt(2, p.getCantidad());
            st.setInt(3, p.getIdProduccion());
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
}
