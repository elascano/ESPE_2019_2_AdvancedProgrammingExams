/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.controller;

import ec.edu.espe.moto.model.Moto;
import ec.edu.espe.moto.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author atlha
 */
public class UserDAO {
     private Conexion conexion = new Conexion();
    public ArrayList<User> mostrarListaUsers() {
        ArrayList<User> listPiece = new ArrayList<User>();
        User user;
        
        try {
            
            Connection acceso = conexion.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setIDUSER(rs.getInt(1));
                user.setNAME(rs.getString(2));
                user.setLASTNAME(rs.getString(3));
                user.setPHONE(rs.getString(4));
                user.setTYPE(rs.getString(5));
                user.setEMAIL(rs.getString(6));
                user.setUSER(rs.getString(7));
                user.setPASSWORD(rs.getString(8));

                listPiece.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listPiece;
    }
    
    public static String deleteUserbyId(int id) {

        String response = null;
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();
        Statement st;
        ResultSet rs;
        ///Creamos la sentencia SQL
        String sql = "DELETE FROM user WHERE IDUSER =" + id;
        //ejecutamos la sentencia SQL
        try {
            //PreparedStatement s;
            st = cnn.createStatement();
            //s = cnn.prepareStatement(sql);
            boolean result;

            result = st.execute(sql);
            System.out.println(result);
            //rs = st.executeQuery(sql);
            if (result == false) {
                response = "User removed succesfully";
            } else {
                response = "User din't remove or doesn't exist";
            }

            //cerramos las conexiones
            st.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("data base couldnt be connected ");
        }
        return response;
    }
    
    public User addUser(User user) throws SQLException {
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();
        String sql = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, user.getIDUSER());
            ps.setString(2, user.getNAME());
            ps.setString(3, user.getLASTNAME());
            ps.setString(4, user.getPHONE());
            ps.setString(5, user.getTYPE());
            ps.setString(6, user.getEMAIL());
            ps.setString(7, user.getUSER());
            ps.setString(8, user.getPASSWORD());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return user;
    }

    
    public static  User searchUserbyId(int id) {

        User user = new User();

        String nombre = "";
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();
        Statement st;
        ResultSet rs;
        ///Creamos la sentencia SQL
        String sql = "SELECT * FROM users where IDUSER = " + id + "";
        //ejecutamos la sentencia SQL
        try {
            st = cnn.createStatement();
            rs = st.executeQuery(sql);
            //codigo para mostrar los datos de los registros
            while (rs.next()) {
                System.out.println("═══════════════");
                id = rs.getInt(1);
                user.setIDUSER(id);
                System.out.println("ID: " + rs.getInt(1));

                nombre = rs.getString(2);
                user.setNAME(nombre);
                System.out.println("MODELO: " + rs.getString(2));
                
                String category = rs.getString(3);
                user.setLASTNAME(category);
                
                String phone = rs.getString(4);
                user.setPHONE(phone);
                
                String color = rs.getString(5);
                user.setTYPE(color);

                String warranty = rs.getString(6);
                user.setEMAIL(warranty);
                
                String displacement = rs.getString(7);
                user.setUSER(displacement);
                
                String power = rs.getString(8);
                user.setPASSWORD(power);
                System.out.println("═══════════════");
            }
            //cerramos las conexiones
            rs.close();
            st.close();
            cnn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " NO SE PUDO ACCEDER A LOS DATOS DE ACTIVIDAD");
            System.out.println("NO SE PUDO ACCEDER A LOS DATOS DE ACTIVIDAD");
        }

        return user;
    }

    

       
}
