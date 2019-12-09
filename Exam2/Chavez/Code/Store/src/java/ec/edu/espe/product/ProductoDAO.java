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
 * @author nycha
 */
public class ProductoDAO {
    Conexion con;

    public ProductoDAO() {
        con=new Conexion();
    }
    public void adicionarProducto(ProductoVO producto){
        Connection acceso = con.obtenerConexion();
        String sql="INSERT INTO product (id,nombre,tipo,cantidad) VALUES(?,?,?,?)";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, producto.getId());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getTipo());
            ps.setInt(4, producto.getCantidad());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    public ArrayList<ProductoVO> mostrarProducto(){
        ArrayList <ProductoVO> listaB=new ArrayList <ProductoVO>();
        ProductoVO producto;
        try{
            Connection acceso = con.obtenerConexion();            
            PreparedStatement ps= acceso.prepareStatement("SELECT * from product");
            if (ps!=null)
                System.out.println("ERROR EN PS");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new ProductoVO();
                producto.setId(rs.getString(1));
                producto.setNombre(rs.getString(2));
                producto.setTipo(rs.getString(3));
                producto.setCantidad(rs.getInt(4));
                listaB.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }


    
}
