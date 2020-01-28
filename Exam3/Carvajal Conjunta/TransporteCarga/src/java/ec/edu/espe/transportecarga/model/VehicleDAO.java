/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Abi
 */
public class VehicleDAO {
    Conexion con;

    public VehicleDAO() {
        con = new Conexion();
    }

    public ArrayList<VehicleVO> mostrarVehicle() {
        ArrayList<VehicleVO> listaB = new ArrayList<VehicleVO>();
        VehicleVO vehiculo;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from vehicle");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vehiculo = new VehicleVO();
                vehiculo.setId(rs.getInt(1));
                vehiculo.setBrand(rs.getString(2));
                vehiculo.setModel(rs.getString(3));
                listaB.add(vehiculo);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }
    
    public ArrayList<VehicleVO> mostrarVehicleID(int id){
        ArrayList <VehicleVO> listaB=new ArrayList <VehicleVO>();
        VehicleVO vehiculo;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM vehicle WHERE id='"+id+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                vehiculo=new VehicleVO();
                vehiculo.setId(rs.getInt(1));
                vehiculo.setBrand(rs.getString(2));
                vehiculo.setModel(rs.getString(3));
        
                listaB.add(vehiculo);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }


}
