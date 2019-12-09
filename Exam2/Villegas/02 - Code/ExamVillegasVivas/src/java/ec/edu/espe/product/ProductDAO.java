/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Santiago Vivas
 */
public class ProductDAO {
    DBConnect con;

    public ProductDAO() {
        con = new DBConnect();
    }

    public ProductVO addProduct(ProductVO product) throws SQLException {
        Connection acceso = con.connect();
        String sql = "INSERT INTO product VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setString(1, product.getIdProduct());
            ps.setString(2, product.getNameProduct());
            ps.setString(3, product.getTypeProduct());
            ps.setString(4, product.getQuantityProduct());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return product;
    }
    
    public ArrayList<ProductVO> showAllCustomers() {
        ProductVO product = new ProductVO();
        Connection acceso = con.connect();
        ArrayList<ProductVO> allProducts = new ArrayList<>();
        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM product");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    product = new ProductVO();
                    product.setIdProduct(rs.getString(1));
                    product.setNameProduct(rs.getString(2));
                    product.setTypeProduct(rs.getString(3));
                    product.setQuantityProduct(rs.getString(4));

                allProducts.add(product);
                        
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return allProducts;
    }
}
