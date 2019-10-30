/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
class conexion {
    
    
    
    
     Connection con = null;

    public static Connection getConnection() {

        String rutaBD = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "DbaLuis";
        String contraseña = "12345";

        Connection con = null;
        System.out.println("Searching for Oracle JDBC driver...");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//Oracle  Connection
        } catch (ClassNotFoundException ex) {
            System.out.println("Oracle JDBC driver not found!");
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(rutaBD, usuario, contraseña); //ORACLE database
            System.out.println("conexion Exitosa...");

        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
