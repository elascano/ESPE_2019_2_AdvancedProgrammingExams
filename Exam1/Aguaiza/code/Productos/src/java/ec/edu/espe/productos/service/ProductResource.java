/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.productos.service;


import ec.edu.espe.Productos.model.DBConnect;
import ec.edu.espe.productos.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author henry
 */
@Path("Product")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.productos.service.ProductResource
     *
     * @return an instance of ec.edu.espe.productos.model.Producto
     */
    @GET
    @Path("{id}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Producto getJson(@PathParam("id") int id) {
        Producto product = new Producto();
        product = getOperatorId(id);

        return product;
    }

    public Producto getOperatorId(int id) {

        Producto product = new Producto();
        DBConnect conec = new DBConnect();
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("SELECT * from producto where id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                product.setIdProduct(rs.getInt(1));
                product.setNameProduct(rs.getString(2));
                product.setStock(rs.getInt(3));
                product.setPrice(rs.getFloat(4));
            } else {
                product = null;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        conec.finished();
        return product;
    }

    /**
     * PUT method for updating or creating an instance of ProductResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(Producto content) {
    }

}
