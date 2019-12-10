/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.controller;

import ec.edu.espe.moto.model.PieceVO;
import ec.edu.espe.moto.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Galo Pichucho
 */
public class ProductDAO {
    
    
    public ArrayList<Product> mostrarListaProductos() {
        ArrayList<Product> listPiece = new ArrayList<Product>();
        Product piece;

        try {
            BaseConnection conexion = new BaseConnection();
            Connection cnn = conexion.getConnection();
            //Connection acceso = conexion.obtenerConexion();
            PreparedStatement ps = cnn.prepareStatement("SELECT * FROM products");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                piece = new Product();
                piece.setId(rs.getInt(1));
                piece.setName(rs.getString(2));
                piece.setType(rs.getString(3));
                piece.setQuantity(rs.getInt(4));
               
                listPiece.add(piece);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listPiece;
    }

    public Product addPiece(Product piece) throws SQLException {
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();
        String sql = "INSERT INTO products VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, piece.getId());
            ps.setString(2, piece.getName());
            ps.setString(3, piece.getType());
            ps.setInt(4, piece.getQuantity());
            

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return piece;
    }

   
    
}
