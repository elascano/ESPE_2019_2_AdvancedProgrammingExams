/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.controller;

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
 * @author Galo Pichucho
 */
public class PieceDAO {

    public ArrayList<PieceVO> mostrarListaProductos() {
        ArrayList<PieceVO> listPiece = new ArrayList<PieceVO>();
        PieceVO piece;

        try {
            BaseConnection conexion = new BaseConnection();
            Connection cnn = conexion.getConnection();
            //Connection acceso = conexion.obtenerConexion();
            PreparedStatement ps = cnn.prepareStatement("SELECT * FROM pieces");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                piece = new PieceVO();
                piece.setIdPiece(rs.getInt(1));
                piece.setNamePiece(rs.getString(2));
                piece.setCategoryPiece(rs.getString(3));
                piece.setDescriptionPiece(rs.getString(4));
                piece.setPricePiece(rs.getFloat(5));
                piece.setQuantityPiece(rs.getInt(6));

                listPiece.add(piece);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listPiece;
    }

    public static PieceVO searchPiecebyId(int id) {

        PieceVO piece = new PieceVO();

        String nombre = "";
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();
        Statement st;
        ResultSet rs;
        ///Creamos la sentencia SQL
        String sql = "SELECT * FROM pieces where IDPIECE = '" + id + "'";
        //ejecutamos la sentencia SQL
        try {
            st = cnn.createStatement();
            rs = st.executeQuery(sql);
            //codigo para mostrar los datos de los registros
            while (rs.next()) {
                System.out.println("═══════════════");
                id = rs.getInt(1);
                piece.setIdPiece(id);
                System.out.println("ID: " + rs.getInt(1));

                nombre = rs.getString(2);
                piece.setNamePiece(nombre);
                System.out.println("NOMBRE: " + rs.getString(2));

                String category = rs.getString(3);
                piece.setCategoryPiece(category);

                String description = rs.getString(4);
                piece.setDescriptionPiece(description);

                float price = rs.getFloat(5);
                piece.setPricePiece(price);

                int mount = rs.getInt(6);
                piece.setQuantityPiece(mount);
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

        return piece;
    }

    public PieceVO addPiece(PieceVO piece) throws SQLException {
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();
        String sql = "INSERT INTO pieces VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, piece.getIdPiece());
            ps.setString(2, piece.getNamePiece());
            ps.setString(3, piece.getCategoryPiece());
            ps.setString(4, piece.getDescriptionPiece());
            ps.setFloat(5, piece.getPricePiece());
            ps.setInt(6, piece.getQuantityPiece());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return piece;
    }

    public void updatePiece(PieceVO piece) {
        try {
            BaseConnection conexion = new BaseConnection();
            Connection cnn = conexion.getConnection();
            PreparedStatement ps = cnn.prepareStatement("UPDATE pieces SET NAMEPIECE='" + piece.getNamePiece() 
                    + "', CATEGORYPIECE='" + piece.getCategoryPiece() + "', DESCRIPTIONPIECE='" + piece.getDescriptionPiece()
                    + "', PRICEPIECE='" + piece.getPricePiece() + "', QUANTITY='" + piece.getQuantityPiece()
                    + "'WHERE IDPIECE='" + piece.getIdPiece() + "'");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static PieceVO changePiece(int id, int mount) {

        PieceVO piece = new PieceVO();
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();

        String sql = "UPDATE pieces SET QUANTITY= '" + mount + "' WHERE IDPIECE = " + id;
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

        piece = searchPiecebyId(id);
        return piece;
    }

    public static String deletePiecebyId(int id) {

        String response = null;
        BaseConnection conexion = new BaseConnection();
        Connection cnn = conexion.getConnection();
        Statement st;
        ResultSet rs;
        ///Creamos la sentencia SQL
        String sql = "DELETE FROM pieces WHERE IDPIECE =" + id;
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
                response = "Piece removed succesfully";
            } else {
                response = "Piece dont remove or don't exist";
            }

            //cerramos las conexiones
            st.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("NO SE PUDO ACCEDER A LOS DATOS ");
        }
        return response;
    }

}
