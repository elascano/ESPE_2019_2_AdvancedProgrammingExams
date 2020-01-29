/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Vehicle;
import services.Link;

/**
 * REST Web Service
 *
 * @author Galo
 */
@Path("vechicle")
public class Search {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Search
     */
    public Search() {
    }
    
    Link link = new Link();

   
    
     @GET
    //@Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Vehicle> getJsonListPiece() throws SQLException {

        Link vehicleList = new Link();
        ArrayList<Vehicle> vehicle = new ArrayList<Vehicle>();
        vehicle = vehicleList.listVehicle();
        return vehicle;
    }
    
    @GET
    @Path("search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle getJsonPieceById(@PathParam("id") int id) {

        Vehicle piece = new Vehicle();
        piece = Link.searchPiecebyId(id);
        return piece;
    }

    
    @Path("vehicle/{brand}")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public Vehicle getVehicleBrand(@PathParam("brand") String brand) 
    {
        return link.getVehicleBrand(brand);
    }
    
    @GET
    @Path("aws/prueba")
    @Produces(MediaType.TEXT_PLAIN)
    public String probarAWSRest() throws SQLException {

        Link piece = new Link();
        String res = "";
        res = piece.pruebaAWS();

        return res;
    }
    
    
}
