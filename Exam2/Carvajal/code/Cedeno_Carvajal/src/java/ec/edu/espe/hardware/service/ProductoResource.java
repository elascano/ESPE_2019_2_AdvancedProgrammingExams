/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.hardware.service;

import ec.edu.espe.hardware.model.ProductoDAO;
import ec.edu.espe.hardware.model.*;
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
 * @author Melissa
 */
@Path("Products")
public class ProductoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductoResource
     */
    public ProductoResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.hardware.model.ProductoResource
     * @return an instance of ec.edu.espe.hardware.model.ProductoVO
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public ArrayList<ProductoVO> getAllProducts() {
        ProductoDAO guia=new ProductoDAO();
       ArrayList<ProductoVO> produc=new ArrayList<ProductoVO>();
        produc=guia.mostrarProductos();
        return produc;
    }

    /**
     * PUT method for updating or creating an instance of ProductoResource
     * @param content representation for the resource
     */
    @POST
    @Path("/createProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(ProductoVO data) {
        ProductoDAO response = new ProductoDAO();
        response.adicionarProducto(data);
        System.out.println(data.getId());
        System.out.println(data.getNombre());
        System.out.println(data.getTipo());
        System.out.println(data.getCantidad());
       
    }
}
