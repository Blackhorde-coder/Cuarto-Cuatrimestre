package gestores;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.EstadoCivil;
import modelo.Persona;

public class GestorPersonas {
    // Esta clase es la única que va a tener código del paquete java.sql.
    // Va ofrecer métodos para cada operacion con la BD
    // Esos métodos van a recibir parámetros y retornar resultados con objetos
    // únicamente del modelo.
    private String CONN = "jdbc:sqlserver://BLACKHORDENOT:1500;databaseName=ABMpersonasBD";
    private String USER="sa";
    private String PASS = "34671716";
    private Connection conn;
    
    private void abrirConexion()
    {
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(CONN, USER,PASS );
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
    
    public void agregar(Persona nueva) {
    
        try {

            abrirConexion();
            PreparedStatement st = conn.prepareStatement("insert into Personas(Nombre, Apellido, Edad, IdEstadoCivil) values(?,?,?,?)");
            st.setString(1,nueva.getNombre());
            st.setString(2,nueva.getApellido());
            st.setInt(3,nueva.getEdad());
            st.setInt(4,nueva.getEstadoCivil().getId());
            
            st.executeUpdate();
            st.close();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
        
    }
    
    public ArrayList<Persona> obtenerTodos() {
    
        ArrayList<Persona> lista = new ArrayList<>();
        try {

            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select p.id 'id', p.nombre 'nombre', p.apellido'apellido',p.edad'edad',p.idestadocivil'idestadocivil',ec.nombre'nombreEC'\n" +
                                            "from Personas p\n" +
                                            "join EstadosCiviles ec on p.idestadocivil=ec.id");
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                int idEstadoCivil = rs.getInt("idestadocivil");
                String nombreEstadoCivil = rs.getString("nombreEC");
                
                EstadoCivil ec = new EstadoCivil(idEstadoCivil, nombreEstadoCivil);
                Persona p = new Persona(id, nombre, apellido, edad, ec);

                lista.add(p);
            }
            
            st.close();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
        return lista;
        
    }
    
    public ArrayList<EstadoCivil> obtenerEstadosCiviles() {
        ArrayList<EstadoCivil> lista = new ArrayList<>();
        
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from EstadosCiviles");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                EstadoCivil ec = new EstadoCivil(id, nombre);
                lista.add(ec);
            }
            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
        return lista;
    }
    public ArrayList<EstadoCivil> getEstadosCiviles() {
        ArrayList<EstadoCivil> lista = new ArrayList<>();
        
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from EstadosCiviles");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                EstadoCivil ec = new EstadoCivil(id, nombre);
                lista.add(ec);
            }
            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
        return lista;
    }
}
