/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.moto.service;

import ec.edu.espe.moto.controller.PieceDAO;
import ec.edu.espe.moto.controller.ProductDAO;
import ec.edu.espe.moto.model.PieceVO;
import ec.edu.espe.moto.model.Product;
import java.sql.SQLException;
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
 * @author Galo Pichucho
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
     * Retrieves representation of an instance of ec.edu.espe.moto.service.ProductResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getJsonListPiece() {

        ProductDAO pieceList = new ProductDAO();
        ArrayList<Product> piece = new ArrayList<Product>();
        piece = pieceList.mostrarListaProductos();
        return piece;
    }
    
    @Path("addPiece")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public Product insertPiece(Product piece) throws SQLException {
        ProductDAO newPiece = new ProductDAO();
        
            return newPiece.addPiece(piece);
       
    }

    /**
     * PUT method for updating or creating an instance of ProductResource
     * @param content representation for the resource
     */
   
}
