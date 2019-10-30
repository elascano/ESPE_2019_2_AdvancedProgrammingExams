/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.util;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author chris
 */
public class Conection {
    public Conection() {
    }

    public com.mysql.jdbc.Connection getConnection() {
        com.mysql.jdbc.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.116/company", "root", "");
            System.out.println("Conexion Existosa");
        } catch (SQLException ex) {
            System.out.println("BDD INCORRECTA" + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return con;
    }
}
