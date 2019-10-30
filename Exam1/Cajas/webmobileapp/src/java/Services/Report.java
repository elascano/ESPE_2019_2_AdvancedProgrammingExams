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
 * @author Jefferson
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
     *
     * @return an instance of java.lang.String
     */

    @GET
    @Path("/product/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<productVO> getJsonProductCarrier(@PathParam("productId") String carrier) {
        //TODO return proper representation object
        productDAO transportist = new productDAO();
        ArrayList<productVO> productVO = new ArrayList<productVO>();
        productVO = transportist.viewProductoById(carrier);
        return productVO;

    }

    @GET
    @Path("products")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<productVO> getJsonListProducts() {
        //TODO return proper representation object
        productDAO productList = new productDAO();
        ArrayList<productVO> productVO = new ArrayList<productVO>();
        productVO = productList.viewListOfProducts();
        return productVO;
    }
        @GET
    @Path("/product/totalMoney")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<productVO> getJsonProductTotalMoney() {
        //TODO return proper representation object
        productDAO productList = new productDAO();
        ArrayList<productVO> productVO = new ArrayList<productVO>();
        productVO = productList.viewProductTotalMoney();       
        return productVO;
    }

    /**
     * PUT method for updating or creating an instance of Report
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

}
