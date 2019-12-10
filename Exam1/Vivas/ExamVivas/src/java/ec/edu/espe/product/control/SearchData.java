/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.product.control;

import ec.edu.espe.product.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Santiago Vivas
 */
public class SearchData {

    public static ArrayList<Product> allProducts() {
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        Product product = new Product();
        ArrayList<Product> arrayProduct = new ArrayList<Product>();
        //Sacar datos
        String sql = "SELECT * FROM product";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                product = new Product(rs.getString(1), rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)), Float.parseFloat(rs.getString(5)));
                arrayProduct.add(product);
            }

        } catch (SQLException ex) {

        }

        return arrayProduct;

    }
    
    public static String totalPrize() {
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        Product product = new Product();
        ArrayList<Product> arrayProduct = new ArrayList<Product>();
        String totalPrize;
        //Sacar datos
        String sql = "SELECT * FROM product";
        Statement st;
        float prize=0.0f;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                product = new Product(rs.getString(1), rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)), Float.parseFloat(rs.getString(5)));
                prize = (prize + (product.getPrice()*product.getQuantityStock()));
                arrayProduct.add(product);
                
            }

        } catch (SQLException ex) {

        }
        
        totalPrize = Float.toString(prize);
        

        return totalPrize;

    }

    public static Product searchProductById(String id) {
        BaseConnection conexion = new BaseConnection();
        Connection cn = conexion.getConexion();
        Product product = new Product();
        //Sacar datos
        String sql = "SELECT * FROM product";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(id)) {

                    product = new Product(rs.getString(1), rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)), Float.parseFloat(rs.getString(5)));
                }

            }

        } catch (SQLException ex) {

        }

        return product;

    }

}
