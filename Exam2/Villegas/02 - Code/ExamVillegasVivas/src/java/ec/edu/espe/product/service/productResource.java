/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.product.service;

import ec.edu.espe.product.ProductDAO;
import ec.edu.espe.product.ProductVO;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Santiago Vivas
 */
@Path("product")
public class productResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of productResource
     */
    public productResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.product.service.productResource
     * @return an instance of ec.edu.espe.product.ProductVO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProductVO getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of productResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ProductVO content) {
    }
    
    @Path("addProduct")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProductVO insertProduct(ProductVO product) throws SQLException {
        ProductDAO productDao = new ProductDAO();
        return productDao.addProduct(product);
    }
    
    @Path("allProduct")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ProductVO> getAllProduct() {
        ProductDAO productDao = new ProductDAO();
        return productDao.showAllCustomers();
    }
}
