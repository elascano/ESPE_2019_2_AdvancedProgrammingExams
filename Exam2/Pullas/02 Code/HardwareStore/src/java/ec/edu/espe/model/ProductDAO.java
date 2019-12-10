/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anshelo
 */
public class ProductDAO {
   DBConnect con;
   

    public ProductDAO() {
        con=new DBConnect();
    }
  
    
   
    public Product addProduct(Product product)throws SQLException{
        Connection acceso = con.connect();
        String sql = "INSERT INTO product (idProduct,nameProduct,typeProduct,quantityProduct) VALUES(?,?,?,?)";
         try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getType());
            ps.setInt(4, product.getQuantity());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        product = new Product( product.getId(), product.getName(), product.getType(), product.getQuantity());
        return product;
    }
    
    
    public ArrayList<Product> getCarriers() {
        ArrayList <Product> listaB=new ArrayList <Product>();
        Product product;
        Connection acceso = con.connect();
        try{
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM product");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                product=new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setType(rs.getString(3));
                product.setQuantity(rs.getInt(4));
                listaB.add(product);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    
   
}
