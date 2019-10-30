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
    private int  id;
    private String name;
    private String description;
    private int stock;
    private float price;
public ProductDAO(){
    
}
  public static void main(String[] args){
        Conexion c=new Conexion();
        c.obtenerConexion();
    }
    private Conexion conexion = new Conexion();

    public ProductDAO(int id, String name, String description, int stock, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }
  
 
  public ArrayList<ProductVO> SearchProduct(int id) {
        ArrayList <ProductVO> listaB=new ArrayList <ProductVO>();
        ProductVO producto;
        Conexion con = new Conexion();
        try{
            Connection acceso = con.obtenerConexion();
            
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM product where id='"+id+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new ProductVO();
                producto.setId(rs.getInt(1));
                producto.setName(rs.getString(2));
                producto.setDescription(rs.getString(3));
                producto.setStock(rs.getInt(4));
                producto.setPrice(rs.getFloat(5));
                                
                listaB.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
         
  }
    /**
     * @return the id
     */
    public ArrayList<ProductVO> mostrarListaProductos(){
        ArrayList <ProductVO> listaB=new ArrayList <ProductVO>();
        ProductVO producto;
        Conexion con = new Conexion();
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM product");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new ProductVO();
                producto.setId(rs.getInt(1));
                producto.setName(rs.getString(2));
                producto.setDescription(rs.getString(3));
                producto.setStock(rs.getInt(4));
                producto.setPrice(rs.getFloat(5));
                                
                listaB.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
}
