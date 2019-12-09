/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.sevices;

import ec.edu.espe.model.Product;
import ec.edu.espe.model.ProductDAO;
import java.sql.SQLException;
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
 * @author Anshelo
 */
@Path("Product")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.sevices.ProductResource
     * @return an instance of ec.edu.espe.model.Product
     */
    @Path("getproducts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getCarrier() {
         ProductDAO productList = new ProductDAO();
         ArrayList<Product> product =new ArrayList<Product>();
         product = productList.getCarriers();
         return product;
    }
    @Path("insertproduct")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product insertProduct(Product product) throws SQLException{
        ProductDAO productObj = new ProductDAO();
       return productObj.addProduct(product);
    }
    /**
     * PUT method for updating or creating an instance of ProductResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
}
