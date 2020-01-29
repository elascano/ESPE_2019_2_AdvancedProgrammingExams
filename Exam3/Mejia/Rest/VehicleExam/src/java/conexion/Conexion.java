
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String db = "vechichle?useSSL=false";
    private static final String URL = "jdbc:mysql://bdvehicle.chwmix0lilvf.us-east-2.rds.amazonaws.com:3306/" + db;
  
    private static final String USERNAME = "root";
    private static final String PASSSWORD = "12345678";

    public  Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSSWORD);
            System.out.println("Conexion realizada con exito");
        } catch (Exception e) {
            System.out.println("Conexion Fallida...");
        }
        return connection;
    }
    

}
