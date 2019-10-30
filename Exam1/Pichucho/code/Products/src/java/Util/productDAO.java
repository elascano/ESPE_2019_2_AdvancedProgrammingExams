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
 * @author Galito
 */

public class productDAO {
   private int  id;
    private String name;
    private String description;
    private int stock;
    private int price;
public productDAO(){
    
}
  public static void main(String[] args){
  Conexion c=new Conexion();
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
    
  public void RegisterProducto( int id,String name,String description, int stock, int price){
       Connection con = conexion.obtenerConexion();
        Statement st;
        //Creamos las sentenia sql
        String sql = "INSERT INTO product(id,name_p,description,stock,price) "
                + "VALUES ('" + id+ "','" +name+ "','" + description+ "','"+ stock+ "','" + price + "')";
        //Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            //Cerramos las conexiones 
            st.close();
            con.close();
        }    catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error no se puse registrar la provincia");
        }
  }
  
  public String  ListproductData(){
   Connection con = conexion.obtenerConexion();
        Statement st;
        ResultSet rs;
          ArrayList l=new ArrayList();
        String sql = "SELECT * FROM product";
        String list="";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {//id,name,description,stock,price
               list=list+("id:" + rs.getInt(1) + " name_p:" + rs.getString(2) + "description:" + rs.getString(3) + " stock:" + rs.getInt(4) + "price:" + rs.getInt(5)+"\n");
               l.add(list);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede acceder a los datos de Alumnos");
        }
        return list;
}

  
   public String  ListProviderData(){
   Connection con = conexion.obtenerConexion();
        Statement st;
        ArrayList l=new ArrayList();
        ResultSet rs;
        String sql = "SELECT * FROM provider";
        String list="";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {//id,name,description,stock,price
               list=list+("id:" + rs.getInt(1) + " name_p:" + rs.getString(2) + " address:" + rs.getString(3) + " telephone:" + rs.getString(4) +"\n");
               l.add(list);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede acceder a los datos de Alumnos");
        }
        return list;
}
   
  public productVO SearchProduct(String nameproduct,String nameprovide) {
        Conexion con = new Conexion();
        Statement st;
        productVO report = null;
        String msj = "no";
        //Creamos las sentenia sql
        String sql = "SELECT *FROM product WHERE name_p LIKE '" + name + "%'";
        try {
            st = con.obtenerConexion().createStatement();
            ResultSet respuesta = st.executeQuery(sql);
            while (respuesta.next()) {
                String name = respuesta.getString(2);
                System.out.println("" + name);
                if (name.equals(nameproduct)) {
                    System.out.println("" + nameproduct);
                    report = new productVO();
                    report.setId(respuesta.getInt(1));
                    report.setName(respuesta.getString(2));
                    report.setStock(respuesta.getInt(3));
                    report.setPrice(respuesta.getInt(4));
                    report.setDescription(respuesta.getString(5));
                    msj = "exit";
                    return report;
                }
                respuesta.close();
                st.close();
            }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede acceder a los datos");
        }
         return report;
         
  }
  
  public productVO SearchProductById(int id) {
        Conexion con = new Conexion();
        Statement st;
        productVO report = null;
        String msj = "no";
        //Creamos las sentenia sql
        String sql = "SELECT *FROM product WHERE id = '" + id + "%'";
        try {
            st = con.obtenerConexion().createStatement();
            ResultSet respuesta = st.executeQuery(sql);
            while (respuesta.next()) {
                int Id = respuesta.getInt(1);
                System.out.println("" + name);
                if (Id == id) {
                    System.out.println("" + id);
                    report = new productVO();
                    report.setId(respuesta.getInt(1));
                    report.setName(respuesta.getString(2));
                    report.setDescription(respuesta.getString(3));
                    report.setStock(respuesta.getInt(4));
                    report.setPrice(respuesta.getInt(5));
                    
                    msj = "exit";
                    return report;
                }
                respuesta.close();
                st.close();
            }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede acceder a los datos");
        }
         return report;
         
  }
    /**
     * @return the id
     */
    public ArrayList<productVO> mostrarListaProductos(){
        ArrayList <productVO> listaB=new ArrayList <productVO>();
        productVO producto;
        Conexion con = new Conexion();
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM product");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new productVO();
                producto.setId(rs.getInt(1));
                producto.setName(rs.getString(2));
                producto.setDescription(rs.getString(3));
                producto.setStock(rs.getInt(4));
                producto.setPrice(rs.getInt(5));
                                
                listaB.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }

    /**
     * @return the instrictor
     */
    

}
