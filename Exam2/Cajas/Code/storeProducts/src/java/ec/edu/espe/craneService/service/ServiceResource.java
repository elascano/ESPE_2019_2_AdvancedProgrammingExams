/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.craneService.service;

import ec.edu.espe.craneService.model.DBConnect;
import ec.edu.espe.craneService.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Product
 *
 * @author diego
 */
@Path("Products")
public class ServiceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceResource
     */
    public ServiceResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.gruasService.product.ServiceResource
     *
     * @return an instance of ec.edu.espe.gruasService.model.Product
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getJson() {
        ArrayList<Product> listProduct = new ArrayList<>();
        listProduct = getall();
        return listProduct;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String putText(Product operator) {
        return SetOperatorId(new Product(operator.getId(), operator.getName(), operator.getType(), operator.getQuatity()));
    }

    @GET
    @Path("{id}/{name}/{type}/{quantity}")
    @Produces(MediaType.TEXT_PLAIN)

    public String setOperator(@PathParam("id") int id, @PathParam("name") String name,
            @PathParam("type") String type, @PathParam("quantity") int quantity) {

        return SetOperatorId(new Product(id, name, type, quantity));
    }

    public String SetOperatorId(Product product) {

        DBConnect conec = new DBConnect();
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO product values(?,?,?,?)");
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getType());
            ps.setInt(4, product.getQuatity());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        conec.finished();
        return "registered operator";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postJson(Product content) {
        return setService(content);
    }

    public ArrayList<Product> getall() {
        ArrayList<Product> listProducts = new ArrayList<>();
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        Product product;
        try {
            state = connect.getConnection().prepareStatement("SELECT * from product");
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                listProducts.add(product);
            }
            rs.close();
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProducts;
    }

    public String setService(Product service) {
        DBConnect conec = new DBConnect();
        String response = "";

        try {
            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO product values(?,?,?,?)");
            ps.setInt(1, service.getId());
            ps.setString(2, service.getName());
            ps.setString(3, service.getType());
            ps.setInt(4, service.getQuatity());

            ps.executeUpdate();
            response = "Succesfull Save Service";
        } catch (Exception e) {
            System.out.println(e);
            response = "Error Save Service";
        }
        conec.finished();
        return response;
    }

}
