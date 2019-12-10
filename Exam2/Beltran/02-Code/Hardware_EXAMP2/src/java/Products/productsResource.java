/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import ModelDAO.ProductDAO;
import Models.Product;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author diego
 */
@Path("products")
public class productsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of productsResource
     */
    public productsResource() {
    }

    /**
     * Retrieves representation of an instance of Products.productsResource
     * @return an instance of Models.Product
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getJson() {
        ProductDAO dao = new ProductDAO();
        return dao.getProducts();
    }

    /**
     * PUT method for updating or creating an instance of productsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(Product content) {
        ProductDAO dao = new ProductDAO();
        dao.postProduct(content);
    }
}
