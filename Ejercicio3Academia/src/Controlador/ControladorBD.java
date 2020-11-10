
package Controlador;

import Modelo.Alumno;
import Modelo.Curso;
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
public class ControladorBD 
{
    public String STRINGCON="jdbc:sqlserver://BLACKHORDENOT:1500;databaseName=Academia";
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
    
    public ArrayList<Curso> listaCursos()
    {
        ArrayList<Curso> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "select * from Curso");
            
            while(rs.next())
            {
                int idCurso = rs.getInt("idCurso");
                String nombreCurso = rs.getString("nombreCurso");
                String turno = rs.getString("turno");                
                int cupoMax = rs.getInt("cupoMax");
                
                Curso c = new Curso();
                c.setIdCurso(idCurso);
                c.setNombreCurso(nombreCurso);
                c.setTurno(turno);
                c.setCupoMaximo(cupoMax);
                
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
    
    public void altaAlumno(Alumno a) throws ClassNotFoundException
    {
        try 
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement(   "insert into Alumno (legajo, apeNom, tituloNivelMedio, idCurso) \n" +
                                                            "values (?,?,?,?)");
            st.setInt(1, a.getLegajo());
            st.setString(2, a.getApeNom());
            st.setString(3, a.getTituloMedio());
            st.setInt(4, a.getIdCurso());
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
    public void altaCurso(Curso c) throws ClassNotFoundException
    {
        try 
        {
            abrirConexion();
            PreparedStatement st = conn.prepareStatement(   "insert into Curso (nombreCurso, turno, cupoMax) values (?,?, ?)");
            st.setString(1, c.getNombreCurso());
            st.setString(2, c.getTurno());
            st.setInt(3,c.getCupoMaximo());
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
    public int cuentaAlumnos(int idCurso)
    {
        String sql =    "select count(*)\n" +
                        "from Alumno a\n" +
                        "join Curso c on c.idCurso=a.idCurso\n" +
                        "where c.idCurso=?";
        int total=0;
        try 
        {
            abrirConexion(); 
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idCurso);
            ResultSet rs = st.executeQuery();
            rs.next();
            total = rs.getInt(1);
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
        return total;
    }
    public ArrayList<Alumno> listaAlumnos(int idCurso)
    {
        ArrayList<Alumno> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "select * from Alumno where idCurso= "+idCurso);
            
            while(rs.next())
            {
                int legajo = rs.getInt("legajo");
                String nombreApellido = rs.getString("apeNom");
                String tituloMedio = rs.getString("tituloNivelMedio");                
                Alumno a = new Alumno(legajo, nombreApellido, tituloMedio, idCurso);
                lista.add(a);
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
    public ArrayList<Alumno> listaAlumnosTitulo(String titulo)
    {
        ArrayList<Alumno> lista = new ArrayList<>();
        try 
        {
            abrirConexion(); 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "select * from Alumno where tituloNivelMedio = '" +titulo+"'");
            
            while(rs.next())
            {
                int legajo = rs.getInt("legajo");
                String nombreApellido = rs.getString("apeNom");
                String tituloMedio = rs.getString("tituloNivelMedio");
                int idCurso = rs.getInt("idCurso");

                Alumno a = new Alumno(legajo, nombreApellido, tituloMedio, idCurso);
                lista.add(a);
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
