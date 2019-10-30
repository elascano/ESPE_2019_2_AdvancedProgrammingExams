/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.api.service;
import ec.edu.espe.api.model.Conexion1;
import ec.edu.espe.api.model.Product;
import ec.edu.espe.api.model.ProductDAO;
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
 *
 * @author Abi
 */
@Path("product")
public class ProductResource {
    Conexion1 con;
    @Context
    private UriInfo context;

    public ProductResource() {
    }
    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public ArrayList<Product> getJson() {
        ArrayList <Product> products=new ArrayList <Product>();
        ProductDAO productDAO = new ProductDAO(con);
        products=productDAO.searchProduct();
        return products;
    }
    
    @GET
    @Path("{id}/")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Product getJsonProductById(@PathParam("id") int id) {
        Product product = new Product();
        ProductDAO productDAO = new ProductDAO(con);
        product=productDAO.searchProductById(id);
        return product;
    }
    
    
}
