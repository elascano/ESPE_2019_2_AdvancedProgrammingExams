/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.service;

import ec.edu.espe.model.DBConnect;
import ec.edu.espe.model.Vehicle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.time.Clock.system;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Henry
 */
@Path("vehicle")
public class VehicleResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VehicleResource
     */
    public VehicleResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.service.VehicleResource
     *
     * @return an instance of ec.edu.espe.model.Vehicle
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Vehicle> getJson() throws SQLException {
        ArrayList<Vehicle> aux = new ArrayList();
        aux = getAllVehicle();
        return aux;
    }

    @GET
    @Path("{idVehicle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle getJsonId(@PathParam("idVehicle") String id) throws SQLException {
        Vehicle aux = new Vehicle();
        aux = getVehicle(id);
        return aux;
    }

 

    public ArrayList getAllVehicle() throws SQLException {
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        state = connect.getConnection().prepareStatement("SELECT * from vehicle ");

        ResultSet rs = state.executeQuery();

        Vehicle vehicle;
        ArrayList<Vehicle> vehicleList = new ArrayList();

        while (rs.next()) {

            vehicle = new Vehicle(rs.getString(1), rs.getString(2), rs.getString(3));
            vehicleList.add(vehicle);
        }
        rs.close();
        state.close();
        return vehicleList;

    }

    public Vehicle getVehicle(String id) throws SQLException {
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        state = connect.getConnection().prepareStatement("SELECT * from vehicle where ID=? ");
        state.setString(1, id);
        ResultSet rs = state.executeQuery();

        Vehicle vehicle = null;

        while (rs.next()) {
            vehicle = new Vehicle(rs.getString(1), rs.getString(2), rs.getString(3));
            System.out.println(vehicle.getID());

        }
        rs.close();
        state.close();
        return vehicle;

    }
}
