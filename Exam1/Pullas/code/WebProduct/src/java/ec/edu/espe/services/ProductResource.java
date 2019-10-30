/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.services;

import ec.edu.espe.model.ProductDAO;
import ec.edu.espe.model.ProductVO;
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
 * @author Anshelo
 */
@Path("product")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.services.ProductResource
     * @return an instance of ec.edu.espe.model.ProductVO
     */
   
    @GET
    @Path("product")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ProductVO> getJsonProduct() {
        //TODO return proper representation object
        ProductDAO productList=new ProductDAO();
        ArrayList<ProductVO> productVO=new ArrayList<ProductVO>();
        productVO=productList.mostrarListaProductos();        
        return productVO;
    }
    
    @Path("product/{id}")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ProductVO>  getProduct(@PathParam("id")int id){
        ProductDAO productList=new ProductDAO();
        ArrayList<ProductVO> productVO=new ArrayList<ProductVO>();
        productVO=productList.SearchProduct(id);
        productVO.add(new ProductVO(0, "leche", "producto lacteo", 5,0.6f));
        return productVO;
    }
    /**
     * PUT method for updating or creating an instance of ProductResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ProductVO content) {
    }
}
