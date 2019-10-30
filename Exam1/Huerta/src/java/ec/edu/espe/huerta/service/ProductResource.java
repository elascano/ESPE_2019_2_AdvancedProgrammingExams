/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.huerta.service;

import ec.edu.espe.huerta.model.AeProduc;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author ╔Diego Huerta╗
 */
@Path("webservice")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.huerta.service.ProductResource
     * @return an instance of java.lang.Product
     */
    @GET
    @Path("products")
    @Produces("application/json")
    public AeProduc getJsonProducts() {
        //TODO return proper representation object
        System.out.println("PROBANDO");
        AeProduc product = new AeProduc();
        return product;
    }
    /*public Student getJsonAnyStudent() {

        Student student = new Student(1,"Angel","y demonioi",8.0F,22);
        return student;
    }*/

    /**
     * PUT method for updating or creating an instance of ProductResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(AeProduc content) {
    }
}
