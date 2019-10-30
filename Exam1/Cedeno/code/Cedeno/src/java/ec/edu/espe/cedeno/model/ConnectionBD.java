/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.cedeno.model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Melissa
 */
public class ConnectionBD {
    private String bd="cedeno";
    private String login="root";
    private String passw="1234";
    private String url="jdbc:mysql://localhost:3306/"+bd+"?autoReconnect=true&useSSL=false";
    Connection objConex=null;
    
    public ConnectionBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
            objConex=DriverManager.getConnection(url,login,passw);
            if(objConex!=null){
                System.out.println("Conexion a BD OK");
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection obtenerConexion(){
        return objConex;
    }
    
}
