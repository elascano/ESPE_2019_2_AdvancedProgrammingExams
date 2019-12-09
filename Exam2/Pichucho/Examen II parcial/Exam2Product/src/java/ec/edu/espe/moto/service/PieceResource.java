/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.service;

import ec.edu.espe.moto.controller.PieceDAO;
import ec.edu.espe.moto.model.PieceVO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Galo Pichucho
 */
@Path("piece")
public class PieceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PieceResource
     */
    public PieceResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.moto.service.PieceResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    //@Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<PieceVO> getJsonListPiece() {

        PieceDAO pieceList = new PieceDAO();
        ArrayList<PieceVO> piece = new ArrayList<PieceVO>();
        piece = pieceList.mostrarListaProductos();
        return piece;
    }

    @GET
    @Path("search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PieceVO getJsonPieceById(@PathParam("id") int id) {

        PieceVO piece = new PieceVO();
        piece = PieceDAO.searchPiecebyId(id);
        return piece;
    }
    
    

    @GET
    @Path("change/{id}/{mount}")
    @Produces(MediaType.APPLICATION_JSON)
    public PieceVO getJsonChangePieceById(@PathParam("id") int id, @PathParam("mount") int mount) {

        PieceVO piece = new PieceVO();
        piece = PieceDAO.changePiece(id, mount);
        return piece;
    }

    @Path("addPiece")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public PieceVO insertPiece(PieceVO piece) throws SQLException {
        PieceDAO newPiece = new PieceDAO();
        
            return newPiece.addPiece(piece);
       
    }
    
    
    @Path("/updatepiece/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public PieceVO updateClient(PieceVO data) {
        PieceDAO updatedPiece = new PieceDAO();
        updatedPiece.updatePiece(data);
        return data;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonDeletePieceById(@PathParam("id") int id) {
        //PieceDAO pieceSms=new PieceDAO();
        String sms = PieceDAO.deletePiecebyId(id);
        return sms;

    }

    /**
     * PUT method for updating or creating an instance of PieceResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
