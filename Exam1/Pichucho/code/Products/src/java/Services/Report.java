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
 * @author Galito
 */
@Path("search")
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
  @Path("product")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String  getProduct() {
          productDAO pdc=new productDAO();
          
        return pdc.ListproductData();
    }
     @Path("provider")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public String  getProvider() {
          productDAO pdc=new productDAO();
        return pdc.ListProviderData();
    }
    @GET
    @Path("listproduct")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<productVO> getJsonClientCompraProdFragil() {
        //TODO return proper representation object
        productDAO productList=new productDAO();
        ArrayList<productVO> productVO=new ArrayList<productVO>();
        productVO=productList.mostrarListaProductos();        
        return productVO;
    }
    
    @Path("product/{id}")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public productVO  getReportProductbyId(@PathParam("id") int id) {
          productDAO pdc=new productDAO();
          productVO r=new productVO();
          r=pdc.SearchProductById(id);
        return r;
    }
    
    @Path("/{name}/{namep}")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public productVO  getReport(@PathParam("name") String name,@PathParam("namep") String namep) {
          productDAO pdc=new productDAO();
          productVO r=new productVO();
          r=pdc.SearchProduct(name,namep);
        return r;
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
