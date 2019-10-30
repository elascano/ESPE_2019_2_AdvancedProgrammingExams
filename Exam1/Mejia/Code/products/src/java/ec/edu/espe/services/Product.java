/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.services;

import ec.edu.espe.connection.DBConnect;
import ec.edu.espe.hardware.product;
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

/**
 * REST Web Service
 *
 * @author
 */
@Path("")
public class Product {

    DBConnect db = new DBConnect();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Product
     */
    public Product() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.services.Product
     *
     * @return an instance of ec.edu.espe.hardware.product
     */
    @Path("totalmoney")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object getTotalMountMoney() throws SQLException {
        
        return db.totalMountValues();
    }
    
    @Path("allproducts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList getAllProducts() throws SQLException {
        
         ArrayList <product> product;
        product=db.showAllProducts();
        return product;
    }

    @Path("byid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public product showById(@PathParam("id") String id) throws SQLException {

        product product = (product) db.showById(id);
        return product;
    }
    /**
     * PUT method for updating or creating an instance of Product
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(product content) {
    }
}
