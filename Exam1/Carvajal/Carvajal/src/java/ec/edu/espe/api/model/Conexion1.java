/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.api.model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Diego
 */
public class Conexion1 {
    String bd="product";
    String login="root";
    String passw="root";
    String url = "jdbc:mysql://localhost:3306/product?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    Connection objConex=null;
    
    public Conexion1 (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            objConex = DriverManager.getConnection(url,login,passw);
            if(objConex!=null)
                System.out.println("Conexion a BD ok");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException o){
            System.out.println(o);
        }
    }
 

    public Connection obtenerConexion()
    {
        return objConex;
    }
}

