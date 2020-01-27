/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DenniseSandoval
 */
public class vehicleDAO {
    DBConnect con;

    public vehicleDAO() {
        con = new DBConnect();
    }
    public vehicle searchVehiclebyId(String vehicleId) throws SQLException {
        DBConnect connect = new DBConnect();
        String query;
        query = "SELECT * from vehicles WHERE id='" + vehicleId + "'";
        PreparedStatement state = connect.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();
        vehicle vehicle = null;
        while (rs.next()) {
            vehicle = new vehicle(rs.getString("id"), rs.getString("brand"), rs.getString("model"));
        }
        return vehicle;
    }
    public ArrayList<vehicle> showAllVehicles() throws SQLException {
        DBConnect connect = new DBConnect();
        String query;
        query = "SELECT * from vehicles";
        PreparedStatement state = connect.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();
        vehicle tempVehicle;
        ArrayList<vehicle> vehicle = new ArrayList();
        while (rs.next()) {
            tempVehicle = new vehicle(rs.getString("id"), rs.getString("brand"), rs.getString("model"));
            vehicle.add(tempVehicle);
        }
        return vehicle;
    }
}
