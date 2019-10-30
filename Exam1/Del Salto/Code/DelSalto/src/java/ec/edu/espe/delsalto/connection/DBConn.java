/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.delsalto.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Windows 10
 */
public class DBConn {
    private String db = "company"; 
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost/" + db;
    
    private Connection conexion = null;
    
    public DBConn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url,user,password);
            //JOptionPane.showMessageDialog(null, "Conectado");
        }catch(SQLException ex){
            System.out.println("ERROR EN CONEXION");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void desconectar(){
        conexion = null;
    }
}
