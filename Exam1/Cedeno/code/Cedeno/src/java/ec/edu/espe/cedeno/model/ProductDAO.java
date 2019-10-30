/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.cedeno.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Melissa
 */
public class ProductDAO {
    
    
   public ArrayList<ProductVO> listProducts(){
        ArrayList<ProductVO> arr=new ArrayList<ProductVO>();
        ProductVO stud;
        try {
            ConnectionBD con  = new ConnectionBD();
            Connection acceso=con.obtenerConexion();
            PreparedStatement ps=acceso.prepareStatement("SELECT * from product");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                stud=new ProductVO();
                stud.setIdProduct(rs.getInt(1));
                stud.setNameProduct(rs.getString(2));
                stud.setDescriProduct(rs.getString(3));
                stud.setStockProduct(rs.getInt(4));
                stud.setPriceProduct(rs.getFloat(5));
                arr.add(stud);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return arr;
    }
    public ArrayList<ProductVO> listProductsByID(String id){
        ArrayList<ProductVO> arr=new ArrayList<ProductVO>();
        ProductVO stud;
        try {
            ConnectionBD con  = new ConnectionBD();
            Connection acceso=con.obtenerConexion();
            PreparedStatement ps=acceso.prepareStatement("SELECT * from product WHERE idProduct ='"+id+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                stud=new ProductVO();
                stud.setIdProduct(rs.getInt(1));
                stud.setNameProduct(rs.getString(2));
                stud.setDescriProduct(rs.getString(3));
                stud.setStockProduct(rs.getInt(4));
                stud.setPriceProduct(rs.getFloat(5));
                arr.add(stud);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return arr;
    }
    
}
