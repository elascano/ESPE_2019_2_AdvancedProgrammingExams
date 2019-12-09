/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.service;

import ec.edu.espe.moto.controller.MotoDao;
import ec.edu.espe.moto.controller.UserDAO;
import ec.edu.espe.moto.model.Moto;
import ec.edu.espe.moto.model.User;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author atlha
 */
@Path("User")
public class UserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.moto.service.UserResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getJsonListUser() {
       
        UserDAO userlist=new UserDAO();
        ArrayList<User> user=new ArrayList<User>();
        user=userlist.mostrarListaUsers();        
        return user;
    }
    @GET
    @Path("search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getJsonMotoById(@PathParam("id") int id) {
       
        User user = new User();
        user = UserDAO.searchUserbyId(id);
        return user;
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
    @Path("deleteUser/{byId}")
    public void remove(@PathParam("id") int id) {
        UserDAO.deleteUserbyId(id);
        System.out.println(id);
    }
    @POST
    @Path("/saveUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public User save(User data) {
        UserDAO response = new UserDAO();
        try
        {
            response.addUser(data);
            
        }
        catch(Exception e)
        {
            System.out.println("Error "+e.getMessage());
        }
        return data;
    }
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
