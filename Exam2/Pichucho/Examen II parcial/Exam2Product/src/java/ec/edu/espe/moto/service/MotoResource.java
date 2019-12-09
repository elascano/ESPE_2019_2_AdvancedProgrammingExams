/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.service;

import ec.edu.espe.moto.controller.MotoDao;
import ec.edu.espe.moto.controller.PieceDAO;
import ec.edu.espe.moto.model.Moto;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author atlha
 */
@Path("Moto")
public class MotoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MotoResource
     */
    public MotoResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.moto.service.MotoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Moto> getJsonListMoto() {
       
        MotoDao motolist=new MotoDao();
        ArrayList<Moto> moto=new ArrayList<Moto>();
        moto=motolist.mostrarListaMoto();        
        return moto;
    }
    @GET
    @Path("search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Moto getJsonMotoById(@PathParam("id") int id) {
       
        Moto moto = new Moto();
        moto = MotoDao.searchMotobyId(id);
        return moto;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of MotoResource
     * @param id
     * @param content representation for the resource
     */
    

    
    @DELETE
    @Path("deleteMoto/{byId}")
    public void remove(@PathParam("id") int id) {
        MotoDao response = new MotoDao();
        MotoDao.deleteMotobyId(id);
        System.out.println(id);
    }
    @POST
    @Path("/saveMoto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Moto save(Moto data) {
        MotoDao response = new MotoDao();
        try
        {
            response.addMoto(data);
            
        }
        catch(Exception e)
        {
            System.out.println("Error "+e.getMessage());
        }
        return data;
    }
}
