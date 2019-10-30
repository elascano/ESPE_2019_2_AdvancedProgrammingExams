/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jefferson
 */
public class productDAO {

    private int id;
    private String name;
    private String description;
    private int stock;
    private int price;

    public productDAO() {

    }

    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.obtenerConexion();
    }
    private Conexion conexion = new Conexion();

    public productDAO(int id, String name, String description, int stock, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public ArrayList<productVO> viewProductoById(String carrier) {
        ArrayList<productVO> listaB = new ArrayList<productVO>();
        productVO product;
        try {
            Connection acceso = conexion.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT * from product WHERE id='" + carrier + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product = new productVO();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setStock(rs.getInt(4));
                product.setPrice(rs.getInt(5));

                listaB.add(product);
                System.out.println(product.toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }


    public ArrayList<productVO> viewListOfProducts() {
        ArrayList<productVO> listaB = new ArrayList<productVO>();
        productVO producto;
        Conexion con = new Conexion();
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM product");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                producto = new productVO();
                producto.setId(rs.getInt(1));
                producto.setName(rs.getString(2));
                producto.setDescription(rs.getString(3));
                producto.setStock(rs.getInt(4));
                producto.setPrice(rs.getInt(5));

                listaB.add(producto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<productVO> viewProductTotalMoney() {
        ArrayList<productVO> listaB = new ArrayList<productVO>();
        productVO producto;
        Conexion con = new Conexion();
        float total = 0.0f;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT sum(price)as totalMoney\n" +
"FROM product;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                producto = new productVO();
                producto.setId(rs.getInt(1));
                producto.setName(rs.getString(2));
                producto.setDescription(rs.getString(3));
                producto.setStock(rs.getInt(4));
                producto.setPrice(rs.getInt(5));                
                listaB.add(producto);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }





    /**
     * @return the id
     */
    /**
     * @return the instrictor
     */
}
