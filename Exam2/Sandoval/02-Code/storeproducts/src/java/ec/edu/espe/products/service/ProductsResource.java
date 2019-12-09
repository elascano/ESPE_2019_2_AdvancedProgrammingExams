/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.products.service;

import ec.edu.espe.products.model.Product;
import ec.edu.espe.products.model.ProductDAO;
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
 * @author DenniseSandoval
 */
@Path("products")
public class ProductsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductsResource
     */
    public ProductsResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.products.service.ProductsResource
     * @return an instance of ec.edu.espe.products.model.Product
     */
    @Path("/showallproducts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getProduct() throws SQLException {
        ProductDAO product = new ProductDAO();
        ArrayList<Product> objProduct=new ArrayList<Product>();
        objProduct = product.showAllProducts();
        return objProduct;
    }
    @Path("/insertguide")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Product addGuide(Product objProduct) throws SQLException{
        ProductDAO guide = new ProductDAO();
       return guide.addProduct(objProduct);
    } 
    /**
     * PUT method for updating or creating an instance of ProductsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
}
