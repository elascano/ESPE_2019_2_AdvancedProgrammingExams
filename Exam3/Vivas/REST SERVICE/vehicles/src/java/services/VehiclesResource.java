/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
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
import model.vehicle;
import model.vehicleDAO;

/**
 * REST Web Service
 *
 * @author DenniseSandoval
 */
@Path("vehicles")
public class VehiclesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VehiclesResource
     */
    public VehiclesResource() {
    }

    /**
     * Retrieves representation of an instance of services.VehiclesResource
     * @return an instance of model.vehicle
     */
    @Path("/showvehiclebyid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public vehicle getVehiclebyId(@PathParam("id") String id) throws SQLException {
        vehicleDAO guide = new vehicleDAO();
        vehicle objGuide= new vehicle();
        objGuide=guide.searchVehiclebyId(id);
        return objGuide;
    }
    @Path("/showallvehicles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<vehicle> getGuide() throws SQLException {
        vehicleDAO guide = new vehicleDAO();
        ArrayList<vehicle> objGuide=new ArrayList<vehicle>();
        objGuide = guide.showAllVehicles();
        return objGuide;
    }
    /**
     * PUT method for updating or creating an instance of VehiclesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(vehicle content) {
    }
}
