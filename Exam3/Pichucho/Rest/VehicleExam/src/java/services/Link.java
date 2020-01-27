
package services;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Link {
    
    ///Search URIS
    private final ArrayList<Vehicle> listVehicles = new ArrayList<Vehicle>();
    
    public ArrayList<Vehicle> listVehicle(){
        Conexion conect1 = new Conexion();
        Connection con1 = conect1.getConnection();
        String sql = "SELECT * FROM vechicle";
        try
        {
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");

                Vehicle vh =  new Vehicle(id, brand, model);
                listVehicles.add(vh);
            }
            st.close();
            return listVehicles;
        }catch (SQLException e){
            System.err.println("Got an exception! ");
            return listVehicles;
        }
    }
    
    public static Vehicle searchPiecebyId(int id) {

        Vehicle piece = new Vehicle();

        String nombre = "";
        
        Conexion conect1 = new Conexion();
        Connection con1 = conect1.getConnection();
        
        //BaseConnection conexion = new BaseConnection();
        //Connection cnn = conexion.getConnection();
        Statement st;
        ResultSet rs;
        ///Creamos la sentencia SQL
        String sql = "SELECT * FROM vechicle where id = '" + id + "'";
        //ejecutamos la sentencia SQL
        try {
            st = con1.createStatement();
            rs = st.executeQuery(sql);
            //codigo para mostrar los datos de los registros
            while (rs.next()) {
                System.out.println("═══════════════");
                id = rs.getInt(1);
                piece.setId(id);
                System.out.println("ID: " + rs.getInt(1));

                nombre = rs.getString(2);
                piece.setBrand(nombre);
                System.out.println("NOMBRE: " + rs.getString(2));

                String category = rs.getString(3);
                piece.setModel(category);

                
                System.out.println("═══════════════");
            }
            //cerramos las conexiones
            rs.close();
            st.close();
            con1.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " NO SE PUDO ACCEDER A LOS DATOS DE ACTIVIDAD");
            System.out.println("NO SE PUDO ACCEDER A LOS DATOS DE ACTIVIDAD");
        }

        return piece;
    }
    
    public Vehicle getVehicleBrand(String brand)
    {
            Conexion conect1 = new Conexion();
            Connection con1 = conect1.getConnection();
            
            String sqlGetData = "SELECT * from  vehicle WHERE ";
            
            String sql = sqlGetData + "brand= '" + brand+ "'";
            try
            {
                Statement st = con1.createStatement();
                ResultSet rs = st.executeQuery(sql);

                Vehicle me = null;
                while(rs.next()){
                    me = new Vehicle(rs.getInt("ID"), rs.getString("brand"), rs.getString("model"));
                }
                con1.close();
                return me;
            }    catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error for search...");
                return null;
        }
    }
    
    public Vehicle getVehicleModel(String model)
    {
            Conexion conect1 = new Conexion();
            Connection con1 = conect1.getConnection();
            
            String sqlGetData = "SELECT * from  vehicle WHERE ";
            
            String sql = sqlGetData + "model= '" + model+ "'";
            try
            {
                Statement st = con1.createStatement();
                ResultSet rs = st.executeQuery(sql);

                Vehicle me = null;
                while(rs.next()){
                    me = new Vehicle(rs.getInt("ID"), rs.getString("brand"), rs.getString("model"));
                }
                con1.close();
                return me;
            }    catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error for search...");
                return null;
        }
    }
    
     public String pruebaAWS() {

        return "el rest si funciona correctamente";
    }
   
}
