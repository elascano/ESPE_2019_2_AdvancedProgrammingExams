/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Galito
 */
public class BaseConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/hardwareproduct?useTimezone=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "galito.97";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println(" CONEXION EXITOSA. ");
            //JOptionPane.showMessageDialog(null, "Conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            System.out.println(" CONEXION FALLIDA. ");
        }
        return connection;
    }
    
}
