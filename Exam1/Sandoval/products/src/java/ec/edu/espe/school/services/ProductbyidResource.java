/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.school.services;

import ec.edu.espe.school.model.product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DenniseSandoval
 */
@Path("productbyid")
public class ProductbyidResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductbyidResource
     */
    public ProductbyidResource() {
    }
    
    /**
     * Retrieves representation of an instance of ec.edu.espe.school.services.ProductbyidResource
     * @return an instance of ec.edu.espe.school.model.product
     */
    @Path("{idproduct}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("idproduct") String idproduct) throws SQLException {
        DBCconnect conexion = new DBCconnect();
        ArrayList <product> products = new ArrayList();
        product tempProduct;
        PreparedStatement consulta = conexion.connect().prepareStatement("SELECT * FROM products WHERE id like idproduct");
        ResultSet resultado = consulta.executeQuery();
        while (resultado.next()) {
            tempProduct = new product(resultado.getString("id"), resultado.getString("name"), resultado.getString("description"), resultado.getInt("quantity"), resultado.getFloat("price"));
            products.add(tempProduct);
        }
        return products.toString();
    }

    /**
     * PUT method for updating or creating an instance of ProductbyidResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(product content) {
    }
}
