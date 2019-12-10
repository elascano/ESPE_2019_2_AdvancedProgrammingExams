/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @author Luis
 */
@Path("product")
public class stock {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of stock
     */
    public stock() {
    }

    /**
     * Retrieves representation of an instance of products.stock
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws SQLException {
         String selectSQL = "SELECT  * FROM product ";
        Connection con = conexion.getConnection();
        PreparedStatement ps = con.prepareStatement(selectSQL);
        ResultSet rst = ps.executeQuery();
        String Lista = "id_product "+" "+" name_product"+" description_product"+"quantity_stock"+"price_product"+"\n";
        while (rst.next()) {
         // String em = rst.getString("Alumno_ID");
          //  String coda = rst.getString("idproducto");
          String id_product = rst.getString("id_product");  
          String name_product = rst.getString("name_product");
            String description_product = rst.getString("description_product");
            
           
            Lista += id_product+" "+name_product+ " " +description_product+"\n";
  
        }
        return Lista;
    }

    /**
     * PUT method for updating or creating an instance of stock
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
