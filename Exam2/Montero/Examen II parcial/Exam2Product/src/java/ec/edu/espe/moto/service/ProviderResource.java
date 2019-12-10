/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.service;

import ec.edu.espe.moto.controller.PieceDAO;
import ec.edu.espe.moto.controller.ProviderDAO;
import static ec.edu.espe.moto.controller.ProviderDAO.searchProviderbyId;
import ec.edu.espe.moto.model.PieceVO;
import ec.edu.espe.moto.model.Provider;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Sergio Pillisa
 */
@Path("provider")
public class ProviderResource {


    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PieceResource
     */
    public ProviderResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.moto.service.PieceResource
     * @return an instance of java.lang.String
     */
    
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Provider> getJsonListProvider() {
       
        ProviderDAO providerList=new ProviderDAO();
        ArrayList<Provider> provider=new ArrayList<Provider>();
        provider=providerList.mostrarListaProvedores();        
        return provider;
    }
    
    @GET
    @Path("search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Provider getJsonProviderById(@PathParam("id") int id) {
       
        Provider provider = new Provider();
        provider = ProviderDAO.searchProviderbyId(id);
        return provider;
    }
    
    @GET
    @Path("change/{id}/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Provider getJsonChangeProviderById(@PathParam("id") int id,@PathParam("city") String city) {
       
       Provider provider = new Provider();
       provider = ProviderDAO.changeProvider(id, city);
       return provider;
    }

    
    /**
     * PUT method for updating or creating an instance of PieceResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

}
