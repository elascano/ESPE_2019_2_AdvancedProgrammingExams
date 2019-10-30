/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.delsalto.dto;

import ec.edu.espe.delsalto.classes.Product;
import ec.edu.espe.delsalto.connection.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class ProductDTO {
    private ArrayList<Product> productList = null;
    
    public ProductDTO(){
        productList = new ArrayList<Product>();
    }
    
    public ArrayList<Product> getProducts(){
        DBConn connection = new DBConn();
        Connection conn = connection.getConexion();
        Product product = null;
        
        if(conn!=null){
            try {
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM product");
                ResultSet rs = statement.executeQuery();
                
                while(rs.next()){
                    product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getFloat(5));
                    productList.add(product);
                }
                
            } catch (SQLException ex) {
                System.out.println("ERROR EN OBTENCION DE DATOS TOTALES DE PRODUCT");
            }
        }
        return this.productList;
    }
    
    public Product getProduct(int id){
        DBConn connection = new DBConn();
        Connection conn = connection.getConexion();
        List <Product> productList = new ArrayList<Product>();
        Product item = null;
        
        if (conn!=null){
            item = new Product();
            productList = getProducts();
            for (int i = 0; i < productList.size(); i++){
                if (productList.get(i).getProduct_id() == id){
                    item = productList.get(i);
                }
            }
        }
        return item;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}
