/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.controller;

import ec.edu.espe.moto.model.Moto;
import ec.edu.espe.moto.model.PieceVO;
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
public class MotoDao {
     private Conexion conexion = new Conexion();
    public ArrayList<Moto> mostrarListaMoto() {
        ArrayList<Moto> listPiece = new ArrayList<Moto>();
        Moto moto;
        
        try {
            
            Connection acceso = conexion.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM motos");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                moto = new Moto();
                moto.setIDMOTO(rs.getInt(1));
                moto.setMODELMOTO(rs.getString(2));
                moto.setDESPTIONMOTO(rs.getString(3));
                moto.setPRICEMOTO(rs.getFloat(4));
                moto.setCOLORMOTO(rs.getString(5));
                moto.setWARRANTYMOTO(rs.getInt(6));
                moto.setDISPLACEMENTMOTO(rs.getInt(7));
                moto.setPOWERMOTO(rs.getFloat(8));

                listPiece.add(moto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listPiece;
    }
    
    public static String deleteMotobyId(int id) {

        String response = null;
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();
        Statement st;
        ResultSet rs;
        ///Creamos la sentencia SQL
        String sql = "DELETE FROM motos WHERE IDMOTO =" + id;
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
                response = "Moto removed succesfully";
            } else {
                response = "Moto din't remove or doesn't exist";
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
    
    public Moto addMoto(Moto moto) throws SQLException {
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();
        String sql = "INSERT INTO motos VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, moto.getIDMOTO());
            ps.setString(2, moto.getMODELMOTO());
            ps.setString(3, moto.getDESPTIONMOTO());
            ps.setFloat(4, moto.getPRICEMOTO());
            ps.setString(5, moto.getCOLORMOTO());
            ps.setInt(6, moto.getWARRANTYMOTO());
            ps.setFloat(7, moto.getDISPLACEMENTMOTO());
            ps.setFloat(8, moto.getPOWERMOTO());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return moto;
    }

    
    public static  Moto searchMotobyId(int id) {

        Moto moto = new Moto();

        String nombre = "";
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();
        Statement st;
        ResultSet rs;
        ///Creamos la sentencia SQL
        String sql = "SELECT * FROM motos where IDMOTO = " + id + "";
        //ejecutamos la sentencia SQL
        try {
            st = cnn.createStatement();
            rs = st.executeQuery(sql);
            //codigo para mostrar los datos de los registros
            while (rs.next()) {
                System.out.println("═══════════════");
                id = rs.getInt(1);
                moto.setIDMOTO(id);
                System.out.println("ID: " + rs.getInt(1));

                nombre = rs.getString(2);
                moto.setMODELMOTO(nombre);
                System.out.println("MODELO: " + rs.getString(2));
                
                String category = rs.getString(3);
                moto.setDESPTIONMOTO(category);
                
                float price = rs.getFloat(4);
                moto.setPRICEMOTO(price);
                
                String color = rs.getString(5);
                moto.setCOLORMOTO(color);

                int warranty = rs.getInt(6);
                moto.setWARRANTYMOTO(warranty);
                
                int displacement = rs.getInt(7);
                moto.setWARRANTYMOTO(displacement);
                
                int power = rs.getInt(8);
                moto.setWARRANTYMOTO(power);
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

        return moto;
    }

    
//    public static PieceVO changePiece(int id, int  mount) {
//
//        PieceVO piece = new PieceVO();
//        BaseConnection conexion = new BaseConnection();
//        Connection cnn = conexion.getConnection();
//
//        String sql = "UPDATE pieces SET QUANTITY= '" + mount + "' WHERE IDPIECE = " + id;
//        Statement st;
//        try {
//            st = cnn.createStatement();
//            int confirmar = st.executeUpdate(sql);
//            if (confirmar == 1) {
//                System.out.println("REGISTRO MODIFICADO CON EXITO. ");
//            } else {
//                System.out.println("ERROR.. NO SE PUDO MODIFICAR. ");
//            }
//            //cerramos las conexiones
//            st.close();
//            cnn.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//            System.out.println("NO SE PUDO ACCEDER A LOS DATOS");
//        }
//
//        piece = searchPiecebyId(id);
//        return piece;
//
//    }
      
}
