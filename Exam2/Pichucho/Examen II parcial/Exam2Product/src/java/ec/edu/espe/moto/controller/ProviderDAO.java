/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.controller;

import static com.sun.tools.xjc.reader.Ring.add;
import ec.edu.espe.moto.model.PieceVO;
import ec.edu.espe.moto.model.Provider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Galo Pichucho
 */
public class ProviderDAO {

     public static void main(String[] args){
  Conexion c=new Conexion();
  c.obtenerConexion();
    }

    public static Provider changeProvider(int id, String mount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     private Conexion conexion = new Conexion();
    public ArrayList<Provider> mostrarListaProvedores() {
        ArrayList<Provider> listProvider = new ArrayList<Provider>();
        Provider provider;
        
        try {
            
            Connection acceso = conexion.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM provider");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                provider = new Provider();
                
                
                provider.setIdprovider (rs.getInt(1));
                provider.setRucprovider (rs.getString(2));         
                provider.setNameprovider (rs.getString(3));       
                provider.setAddressprovider(rs.getString(4));     
                provider.setCityprovider(rs.getString(5));         
                provider.setRepresentativeprovider(rs.getString(6)); 
                provider.setPhoneprovider(rs.getString(7));        
                provider.setCellphoneprovider(rs.getString(8));    
                provider.setEmailproveedor(rs.getString(9));       
                provider.setFaxprovider(rs.getString(10));


                listProvider.add(provider);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listProvider;
    }
    
    public static  Provider searchProviderbyId(int id) {

        Provider provider = new Provider();

        String nombre = "";
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();
        Statement st;
        ResultSet rs;
        ///Creamos la sentencia SQL
        String sql = "SELECT * FROM provider where IDPROVIDER = '" + id + "'";
        //ejecutamos la sentencia SQL
        try {
            st = cnn.createStatement();
            rs = st.executeQuery(sql);
            //codigo para mostrar los datos de los registros
            while (rs.next()) {
                System.out.println("═══════════════");
                id = rs.getInt(1);
                provider.setIdprovider(id);
                System.out.println("ID: " + rs.getInt(1));

                nombre = rs.getString(2);
                provider.setNameprovider(nombre);
                System.out.println("NOMBRE: " + rs.getString(2));
                
                String category = rs.getString(3);
                provider.setRucprovider(category);
                
                String description = rs.getString(4);
                provider.setCityprovider(description);
                
               

              
            }
            //cerramos las conexiones
            rs.close();
            st.close();
            cnn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " NO SE PUDO ACCEDER A LOS DATOS DE ACTIVIDAD");
            System.out.println("NO SE PUDO ACCEDER A LOS DATOS DE ACTIVIDAD");
        }

        return provider;
    }

    
    public static Provider changeProvider(int id, int  city) {

        Provider provider = new Provider();
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();

        String sql = "UPDATE provider SET QUANTITY= '" + city + "' WHERE IDPROVIDER = " + id;
        Statement st;
        try {
            st = cnn.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                System.out.println("REGISTRO MODIFICADO CON EXITO. ");
            } else {
                System.out.println("ERROR.. NO SE PUDO MODIFICAR. ");
            }
            //cerramos las conexiones
            st.close();
            cnn.close();

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("NO SE PUDO ACCEDER A LOS DATOS");
        }

        provider= searchProviderbyId(id);
        return provider;

    }
    
    

}
