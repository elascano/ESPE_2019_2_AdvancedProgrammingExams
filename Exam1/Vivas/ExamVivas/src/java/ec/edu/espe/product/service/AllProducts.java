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
@Path("allProducts")
public class AllProducts {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public AllProducts() {
    }

    /**
     * Retrieves representation of an instance of Product.GenericResource
     * @return an instance of ec.edu.espe.product.model.Product
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getJsonCarriersTypeVehicle() {

        ArrayList<Product> productList = new ArrayList<Product>();
        productList = SearchData.allProducts();
        //productList.add(new Product("s", "s", "v", 0, 0.0f));
        //productList.add(new Product("d", "d", "d", 1, 0.0f));
        return productList;
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
}
