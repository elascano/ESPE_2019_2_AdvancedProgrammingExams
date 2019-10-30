/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.api.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Abi
 */
public class ProductDAO {
    Conexion1 con;

    public ProductDAO(Conexion1 con) {
        this.con = con;
    }
    
    public ArrayList<Product> searchProduct(){
        ArrayList <Product> listaB=new ArrayList <Product>();
        Product product;
        
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM product");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setQuantityStock(rs.getInt(3));
                product.setPrice(rs.getFloat(4));
                
                listaB.add(product);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    
    public Product searchProductById(int id){
        Product product= new Product();
        
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM product WHERE id='" +id+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setQuantityStock(rs.getInt(3));
                product.setPrice(rs.getFloat(4));
                
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return product;
    }
    
}
