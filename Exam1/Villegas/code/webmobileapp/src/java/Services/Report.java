/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Util.productDAO;
import Util.productVO;
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
 * @author Diego
 */
@Path("report")
public class Report {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Report
     */
    public Report() {
    }

    /**
     * Retrieves representation of an instance of Services.Report
     * @return an instance of java.lang.String
     */
  @Path("product/{id}")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<productVO>  getProduct(@PathParam("id")int id) {
        productDAO productList=new productDAO();
        ArrayList<productVO> productVO=new ArrayList<productVO>();
        productVO=productList.mostrarListaProductoID(id);
        return productVO;
    }
    
    @GET
    @Path("list/product")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<productVO> getJsonListaProductos() {
        //TODO return proper representation object
        productDAO productList=new productDAO();
        ArrayList<productVO> productVO=new ArrayList<productVO>();
        productVO=productList.mostrarListaProductos();        
        return productVO;
    }
    
   
@Path("total")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public String  getProvider() {
        productDAO productList=new productDAO();
        float aux;
        ArrayList<productVO> productVO=new ArrayList<productVO>();
        aux=productList.mostrarProductoTotal();
        //aux=100;
        String total1=String.valueOf(aux);
       // String a=String.
        return total1;
    }

    
    /**
     * PUT method for updating or creating an instance of Report
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    
}

//total
//product/{id}