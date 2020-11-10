
package interfaz;

import java.sql.Connection;
import java.sql.DriverManager;

public class Principal {

    public static void main(String[] args) 
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDiver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://BLACKHORDENOT:1500;databaseName=ABMpersonasBD", "sa", "34671716");
             
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        
    }
    
}
