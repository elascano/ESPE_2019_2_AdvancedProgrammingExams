/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.connection;

import ec.edu.espe.hardware.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class DBConnect {

    Connection ct;
    String bd = "prueba";
    String url = "jdbc:mysql://localhost/" + bd;
    String user = "root";
    String pass = "";

    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ct = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("Successful connection");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR");
        }
        return ct;
    }

    public Object showById(String id) throws SQLException {
        DBConnect connect = new DBConnect();
        String query;
        query = "SELECT * from products where id = ?";
        PreparedStatement state = connect.connect().prepareStatement(query);
        state.setString(1, id);
        ResultSet rs = state.executeQuery();
        product product = null;

        while (rs.next()) {
            product = new product(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity"), rs.getDouble("price"));

        }
        rs.close();
        state.close();
        return product;
    }

    public ArrayList showAllProducts() throws SQLException {
        DBConnect connect = new DBConnect();
        String query;
        query = "SELECT * from products";
        PreparedStatement state = connect.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();
        product tempProduct;
        ArrayList<product> producto = new ArrayList();
        while (rs.next()) {
            tempProduct = new product(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity"), rs.getDouble("price"));
            producto.add(tempProduct);

        }
        rs.close();
        state.close();
        return producto;

    }

    public Object totalMountValues() throws SQLException {
        DBConnect connect = new DBConnect();
        product product = null;
        double total = 0;
        String query;
        String table = "products";
        query = "SELECT * FROM " + table;
        PreparedStatement state = connect.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();

        while (rs.next()) {
            total += (rs.getDouble("price") * rs.getDouble("quantity"));
        }
        rs.close();
        state.close();

        return total;
    }

    public static void main(String[] args) throws SQLException {
        DBConnect c = new DBConnect();
        c.connect();

    }

}
