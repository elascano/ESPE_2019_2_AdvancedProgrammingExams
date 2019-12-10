/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Config.DBConnect;
import Models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class ProductDAO {
    DBConnect conec = new DBConnect();
    public ArrayList<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();
        Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
        try {
            ps = con.prepareStatement("SELECT * from product");
            rs = ps.executeQuery();
            Product product ;
            while(rs.next()){
                product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                products.add(product);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
    
    public String postProduct(Product product){
        Connection con = null;
        con = conec.getConnection();
        String response="";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO product(name_product,type_product,quantity_product) values(?,?,?)");
            ps.setString(1, product.getName_product());
            ps.setString(2, product.getType_product());
            ps.setInt(3, product.getQuantity_product());
            ps.executeUpdate();
            response="Succesfull Save Service";
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
         return response;
    }
    
    
}
