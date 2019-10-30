/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.delsalto.resources;

import ec.edu.espe.delsalto.classes.Product;
import ec.edu.espe.delsalto.connection.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
 * @author Windows 10
 */
@Path("company")
public class AppResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AppResource
     */
    public AppResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.webapppractice.resources.AppResource
     * @return an instance of ec.edu.espe.webapppractice.classes.Zone
     */
    @GET
    @Path("/Products")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getJsonAllProducts() {
        DBConn connection = new DBConn();
        Connection conn = connection.getConexion();
        List <Product> productList = new ArrayList<Product>();
        Product product = null;
        
        if(conn!=null){
            try {
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM product");
                ResultSet rs = statement.executeQuery();
                
                while(rs.next()){
                    product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getFloat(5));
                    productList.add(product);
                }
                
            } catch (SQLException ex) {
                System.out.println("ERROR EN OBTENCION DE DATOS TOTALES DE ZONA");
            }
        }
        return (ArrayList<Product>)productList;
    }

    @GET
    @Path("/Product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getJsonProductById(@PathParam("id") int id) {
        DBConn connection = new DBConn();
        Connection conn = connection.getConexion();
        List <Product> productList = new ArrayList<Product>();
        Product item = null;
        
        if (conn!=null){
            productList = getJsonAllProducts();
            for (int i = 0; i < productList.size(); i++){
                if (productList.get(i).getProduct_id() == id){
                    item = productList.get(i);
                }
            }
        }
        return item;
    }
    
    @GET
    @Path("/TotalAmmount")
    @Produces(MediaType.APPLICATION_JSON)
    public float calculateTotalAmmount() {
        DBConn connection = new DBConn();
        Connection conn = connection.getConexion();
        List <Product> productList = new ArrayList<Product>();
        float suma = 0;
        
        if (conn!=null){
            productList = getJsonAllProducts();
            for (int i = 0; i < productList.size(); i++){
                suma = suma + (productList.get(i).getProduct_price()*productList.get(i).getProduct_stock());
            }
        }
        return suma;
    }
    
    /**
     * PUT method for updating or creating an instance of AppResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Product content) {
    }
}
