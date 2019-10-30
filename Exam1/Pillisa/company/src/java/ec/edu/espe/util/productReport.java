/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.util;

import ec.edu.espe.company.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author chris
 */
public class productReport {
    private Conection conect = new Conection();

    public Product showProduct() {
        Product product = null;
        Statement st;
        Connection con = conect.getConnection();
        String sql = "SELECT *FROM product WHERE ci_prov LIKE '" + 1 + "'";
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                product = new Product();
                product.setId(rs.getString(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setStock(rs.getInt(4));
                product.setStock(rs.getInt(5));
                rs.close();
                st.close();
            }
        } catch (Exception e) {

        }
        return product;
    }
    
    
}
