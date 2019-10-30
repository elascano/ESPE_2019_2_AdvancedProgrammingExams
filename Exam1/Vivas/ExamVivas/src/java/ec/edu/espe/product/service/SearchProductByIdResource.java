/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.product.service;

import ec.edu.espe.product.control.SearchData;
import ec.edu.espe.product.model.Product;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Santiago Vivas
 */
@Path("searchProductById")
public class SearchProductByIdResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchProductByIdResource
     */
    public SearchProductByIdResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.product.control.SearchProductByIdResource
     * @return an instance of ec.edu.espe.product.model.Product
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getJson(@PathParam("id") String id) {
        
        Product product = new Product();
        product = SearchData.searchProductById(id);
        return product;
    }

    /**
     * PUT method for updating or creating an instance of SearchProductByIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
}
