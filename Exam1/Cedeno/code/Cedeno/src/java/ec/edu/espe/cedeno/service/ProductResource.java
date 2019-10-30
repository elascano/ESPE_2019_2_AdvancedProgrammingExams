/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.cedeno.service;

import ec.edu.espe.cedeno.model.ConnectionBD;
import ec.edu.espe.cedeno.model.ProductDAO;
import ec.edu.espe.cedeno.model.ProductVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * @author Melissa
 */
@Path("report")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.cedeno.model.ProductResource
     * @return an instance of ec.edu.espe.cedeno.model.ProductVO
     */
    @GET
    @Path("products")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public ArrayList<ProductVO> getJsonProducts() {
       ProductDAO dao=new ProductDAO();
       ArrayList<ProductVO> arr=new ArrayList<ProductVO>();
        arr=dao.listProducts();
        return arr;
    }
    
    @GET
    @Path("/products/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ProductVO> getJsonClientCarrier(@PathParam("productId")String productId) {
        //TODO return proper representation object
        ProductDAO client=new ProductDAO();
        ArrayList<ProductVO> clientVO=new ArrayList<ProductVO>();
        clientVO=client.listProductsByID(productId);
        return clientVO;
    }
    /**
     * PUT method for updating or creating an instance of ProductResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(ProductVO content) {
    }
    
     
}
