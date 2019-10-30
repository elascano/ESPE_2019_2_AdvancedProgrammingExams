/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.product.control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Santiago Vivas
 */
public class BaseConnection {

    public BaseConnection() {

    }

    public Connection getConexion() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//crea una nueva instancia de la clase representada
            connection = DriverManager.getConnection("jdbc:mysql://localhost/database_product", "root", "viv.viv1997");
            System.out.println("That's ok the base conection");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return connection;
    }
}
