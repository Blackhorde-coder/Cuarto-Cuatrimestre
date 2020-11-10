/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.DTOcantidadVisitas;
import Modelos.Empleado;
import Modelos.Paciente;
import Modelos.Visita;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.jar.Pack200.Packer.PASS;
import static javafx.css.StyleOrigin.USER;

/**
 *
 * @author Hernan Mauricio Pena leg: 111708
 */
public class GestorBD 
{
    public String STRINGCON="jdbc:sqlserver://BLACKHORDENOT:1500;databaseName=Visitas";
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
    public ArrayList<Empleado> listaEmpleados()
    {
        ArrayList<Empleado> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from empleados");
            
            while(rs.next())
            {
                int legajo = rs.getInt("Legajo");
                String nombre = rs.getString("Nombre");
                Empleado e = new Empleado(legajo, nombre);
                lista.add(e);
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
    public ArrayList<Paciente> listaPacientes()
    {
        ArrayList<Paciente> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Pacientes");
            
            while(rs.next())
            {
                int idPaciente = rs.getInt("idPaciente");
                String nombre = rs.getString("Nombre");
                Paciente p = new Paciente(idPaciente, nombre);
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
    public void agregarVisita(Visita v) throws ClassNotFoundException
    {
        try 
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement(   "insert into Visitas (idPaciente, LegajoRecepcionista,Nombre,Duracion) \n" +
                                                            "values (?,?,?,?)");
            st.setInt(1, v.getPaciente().getIdPaciente());
            st.setInt(2, v.getEmpleado().getLegajo());
            st.setString(3, v.getNombre());
            st.setInt(4, v.getDuracion());
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
    public ArrayList<Visita> listaVisitas()
    {
        ArrayList<Visita> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "select v.IdVisita'id', p.Nombre 'Paciente',v.Nombre'Visita',e.Nombre'Empleado',v.Duracion'Duracion'\n" +
                                            "from Visitas v\n" +
                                            "join Pacientes p on p.IdPaciente = v.IdPaciente\n" +
                                            "join Empleados e on e.Legajo=v.LegajoRecepcionista\n" +
                                            "order by p.Nombre");      
            while(rs.next())
            {
                int idVisita = rs.getInt("id");
                String paciente = rs.getString("Paciente");
                Paciente p = new Paciente();
                p.setNombre(paciente);
                String visita = rs.getString("Visita");
                Empleado e = new Empleado();
                e.setNombre(visita);
                int tiempo = rs.getInt("Duracion");
                Visita v = new Visita(idVisita,p,e,visita,tiempo);
               
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
    public ArrayList<DTOcantidadVisitas> cantidadVisitas()
    {
        ArrayList<DTOcantidadVisitas> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "select p.nombre 'Nombre', count(*)'Cantida'\n" +
                                            "from Visitas v\n" +
                                            "join Pacientes p on p.IdPaciente=v.IdPaciente\n" +
                                            "group by p.nombre");
            
            while(rs.next())
            {
                String nombre = rs.getString("Nombre");
                int idPaciente = rs.getInt("Cantida");
                DTOcantidadVisitas reporte = new DTOcantidadVisitas(nombre, idPaciente);
                lista.add(reporte);
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
    public double promediotiempovisita()
    {
        double prom = 0;
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(     "select avg(duracion)\n" +
                                                "from Visitas\n" +
                                                "where Duracion > 10");
            rs.next();
            prom = rs.getDouble(1);//numero de columna
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
        return prom;
    }
        
        
       
}
