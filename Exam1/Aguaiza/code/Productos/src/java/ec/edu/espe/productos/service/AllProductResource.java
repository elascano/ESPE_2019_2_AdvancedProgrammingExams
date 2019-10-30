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
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author henry
 */
@Path("AllProduct")
public class AllProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AllProductResource
     */
    public AllProductResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.productos.service.AllProductResource
     *
     * @return an instance of ec.edu.espe.productos.model.Producto
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getJson() {
        ArrayList<Producto> listaServicios = new ArrayList<>();
        listaServicios = getAll();
        return listaServicios;
    }

    
    public ArrayList<Producto> getAll() {
        DBConnect conec = new DBConnect();
        ArrayList<Producto> lista = new ArrayList<>();
        try {
            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("SELECT * from producto");
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto serv = new Producto();
                serv.setIdProduct(rs.getInt(1));
                serv.setNameProduct(rs.getString(2));
                serv.setStock(rs.getInt(3));
                serv.setPrice(rs.getFloat(4));

                lista.add(serv);
            }
            conec.finished();
        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }
    
    
    
    

    /**
     * PUT method for updating or creating an instance of AllProductResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Producto content) {
    }
}
