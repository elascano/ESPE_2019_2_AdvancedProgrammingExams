/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.delsalto.product_resources;

import ec.edu.espe.delsalto.classes.Product;
import ec.edu.espe.delsalto.dto.ProductDTO;
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
 * @author Windows 10
 */
@Path("company")
public class CompanyResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CompanyResource
     */
    public CompanyResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.delsalto.resources.CompanyResource
     * @return an instance of ec.edu.espe.delsalto.classes.Product
     */
    @GET
    @Path("/Products")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getJsonProducts() {
        ArrayList<Product> products;
        ProductDTO productDTO = new ProductDTO();
        
        products = productDTO.getProducts();     
        
        return products;
    }
    
    @GET
    @Path("/Product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getJsonProduct(@PathParam("id") int id) {
        ProductDTO productDTO = new ProductDTO();
        Product product;
        
        product = productDTO.getProduct(id);
        
        return product;
    }
    
    @GET
    @Path("/TotalAmmount")
    @Produces(MediaType.APPLICATION_JSON)
    public float calculateTotalAmmount() {
        ProductDTO productDTO = new ProductDTO();
        ArrayList<Product> products;
        float suma = 0;
        
        products = productDTO.getProducts();
        for (int i = 0; i < products.size(); i++){
            suma = suma + (products.get(i).getProduct_price()*products.get(i).getProduct_stock());
        }
        
        return suma;
    }

    /**
     * PUT method for updating or creating an instance of CompanyResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
}
