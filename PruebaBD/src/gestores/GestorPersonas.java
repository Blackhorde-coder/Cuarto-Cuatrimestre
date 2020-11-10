
package gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;

public class GestorPersonas 
{
    private String CONN="jdbc:sqlserver://BLACKHORDENOT;databaseName=ABMpersonasBD";
    private String USER="sa";
    private String PASS = "34671716";

    public void agregar(Persona nueva)
    {
        try 
        {
            Connection conn = DriverManager.getConnection(CONN, USER,PASS );
            PreparedStatement st = conn.prepareStatement("insert into Personas (nombre, apellido, edad) values (?,?,?) ");
            st.setString(1, nueva.getNombre());
            st.setString(2, nueva.getApellido());
            st.setInt(3, nueva.getEdad());

            st.executeUpdate();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public ArrayList <Persona> obtenerTodos ()
    {
        ArrayList<Persona> lista = new ArrayList<>();
        Connection conn = null;
        try 
        {
            conn = DriverManager.getConnection(CONN, USER,PASS);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Personas");
            
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                Persona p = new Persona(id, nombre, apellido, edad);
                lista.add(p);
            }
            st.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try 
            {
                if(conn != null && !conn.isClosed())
                conn.close();

            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        return lista;
    }
    
    public Persona obtener (int id)
    {
    
    }
}
