/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.school.services;

import ec.edu.espe.school.model.product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DenniseSandoval
 */
@Path("totalamountmoney")
public class TotalamountmoneyResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TotalamountmoneyResource
     */
    public TotalamountmoneyResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.school.services.TotalamountmoneyResource
     * @return an instance of ec.edu.espe.school.model.product
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object totalMountValues() throws SQLException {
        DBCconnect conexion = new DBCconnect();
        product product = null;
        double total = 0;
        String query;
        String table = "products";
        query = "SELECT * FROM " + table;
        PreparedStatement state = conexion.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();

        while (rs.next()) {
            total += (rs.getDouble("price") * rs.getDouble("quantity"));
        }
        rs.close();
        state.close();

        return total;
    }

    /**
     * PUT method for updating or creating an instance of TotalamountmoneyResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(product content) {
    }
}
