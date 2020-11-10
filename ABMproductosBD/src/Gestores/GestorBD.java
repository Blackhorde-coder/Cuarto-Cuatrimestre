package Gestores;

import DTO.DtoFiltro;
import DTO.DtoReporte;
import DTO.DtoVenta;
import Modelos.Producto;
import Modelos.TipoProducto;
import Modelos.Venta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class GestorBD 
{
    public String STRINGCON="jdbc:sqlserver://BLACKHORDENOT:1500;databaseName=AMBproductosBD";
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

    public void agregarProducto(Producto p) throws ClassNotFoundException
    {
        try 
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement("insert into Productos (nombre, precio) values (?,?) ");
            st.setString(1, p.getNombre());
            st.setDouble(2, p.getPrecio());
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
    public ArrayList<Producto> listaProductos()
    {
        ArrayList<Producto> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Productos");
            
            while(rs.next())
            {
                int codigo = rs.getInt("Codigo");
                String nombre = rs.getString("Nombre");
                double precio = rs.getDouble("Precio");
                Producto p = new  Producto(codigo,nombre,precio);
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
    public void editarProducto(Producto p) throws ClassNotFoundException
    {
        try 
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement("update Productos set Nombre = ? , Precio = ? where Codigo = ? ");
            st.setString(1, p.getNombre());
            st.setDouble(2, p.getPrecio());
            st.setInt(3, p.getCodigo());
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
    public ArrayList<TipoProducto> obtenerTipoProducto()
    {
        ArrayList<TipoProducto> lista = new ArrayList<>();
        try 
        {
            abrirConexion();  
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from TipoProducto");
            
            while(rs.next())
            {
                int id = rs.getInt("Id");
                String nombre = rs.getString("Nombre");
                
                TipoProducto t = new  TipoProducto(id,nombre);
                lista.add(t);
            }
            rs.close();
            st.close();
            conn.close();
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
    
    public void agregarVenta(Venta v) throws ClassNotFoundException
    {
        try 
        {
          
            abrirConexion(); 
            PreparedStatement st = conn.prepareStatement("insert into Ventas (cliente, cantidad, codProducto) values (?,?,?) ");
            st.setString(1, v.getCliente());
            st.setInt(2, v.getCantidad());
            st.setInt(3, v.getProducto().getCodigo());
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
    public ArrayList<Venta> listaVentas()
    {
        ArrayList<Venta> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "select v.id, v.cliente, v.cantidad, p.Nombre, p.Precio\n" +
                                            "from ventas v\n" +
                                            "join Productos p on v.codProducto = p.Codigo");
            
            while(rs.next())
            {
                int idVenta = rs.getInt("id");
                String nombreCliente = rs.getString("cliente");
                int cantidad = rs.getInt("cantidad");
                String nombreProducto = rs.getString("Nombre");                
                double precio = rs.getDouble("Precio");
                
                Producto p = new Producto();
                p.setNombre(nombreProducto);
                p.setPrecio(precio);
                
                Venta v = new Venta(idVenta, nombreCliente, cantidad, p);
                lista.add(v);
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
        
    public ArrayList<DtoVenta> listaDtoVenta()
    {
        ArrayList<DtoVenta> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "select v.id, v.cliente, v.cantidad, p.Nombre, p.Precio\n" +
                                            "from ventas v\n" +
                                            "join Productos p on v.codProducto = p.Codigo");
            
            while(rs.next())
            {
                int idVenta = rs.getInt("id");
                String nombreCliente = rs.getString("cliente");
                int cantidad = rs.getInt("cantidad");
                String nombreProducto = rs.getString("Nombre");                
                double precio = rs.getDouble("Precio");
                
                DtoVenta v = new DtoVenta(nombreCliente, cantidad, nombreProducto, precio);
                lista.add(v);
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
    
    public ArrayList<DtoReporte> listaDtoReporte()
    {
        ArrayList<DtoReporte> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(     "select COUNT(*) 'Cantidad', Nombre 'Producto'\n" +
                                                "from Ventas v join Productos p on v.codProducto =p.Codigo\n" +
                                                "group by Nombre");
            
            while(rs.next())
            {
                int cantidad = rs.getInt("Cantidad");
                String nombre = rs.getString("Producto");   
                DtoReporte r = new DtoReporte(nombre, cantidad);
                lista.add(r);
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
        
    public double facturacion()
    {
        ArrayList<DtoReporte> lista = new ArrayList<>();
        double f = 0;
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(     "select sum(v.cantidad*p.precio)\n" +
                                                "from Ventas v join Productos p on v.codProducto=p.Codigo");
            rs.next();
            f = rs.getDouble(1);//numero de columna
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
        return f;
    }
    
    public ArrayList<DtoFiltro> ventaFiltrada(double importe)
    {
        ArrayList<DtoFiltro> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            String sql="select v.cliente,p.nombre,v.cantidad * p.Precio'importe'\n" +
                                            "from Ventas v join Productos p on v.codProducto=p.Codigo\n" +
                                            "where v.cantidad * p.Precio > ?\n" +
                                            "order by cantidad desc";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setDouble(1, importe);//setear el parametro
            ResultSet rs = st.executeQuery();//no va aca la sobrecarga
            
            while(rs.next())
            {
                String nombreCliente = rs.getString("cliente");
                String nombreProducto = rs.getString("nombre");                
                double total = rs.getDouble("importe");
                
                DtoFiltro dto = new DtoFiltro(nombreCliente, nombreProducto, total);
                lista.add(dto);
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
    public DtoVenta ventaMayor() {
        DtoVenta dto = null;
        try
        {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select top 1 v.cliente, v.cantidad, p.nombre, p.precio \n" +
                                            "FROM Ventas v JOIN Productos p ON v.codProducto = p.codigo\n" +
                                            "order by cantidad desc");
            rs.next();
            
            String cliente = rs.getString("cliente");
            int cantidad = rs.getInt("cantidad");
            String producto = rs.getString("nombre");
            double precio = rs.getDouble("precio");
            dto = new DtoVenta(cliente, cantidad, producto, precio);
            
            rs.close();
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        return dto;
    }



}


