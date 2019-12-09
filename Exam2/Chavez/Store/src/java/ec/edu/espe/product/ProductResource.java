/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.product;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author nycha
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

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(ProductoVO data) {
        ProductoDAO response = new ProductoDAO();
        response.adicionarProducto(data);
        System.out.println(data.getId());
        System.out.println(data.getNombre());
        System.out.println(data.getTipo());
        System.out.println(data.getCantidad());
    }

        //CONSULTA TODOS LOS TRANSPORTISTAS
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ProductoVO> getJsonAnyProduct() {
       ProductoVO prod=new ProductoVO();
       ProductoDAO prodDAO=new ProductoDAO();
       ArrayList<ProductoVO> prodVO=new ArrayList<ProductoVO>();
        prodVO=prodDAO.mostrarProducto();
        return prodVO;
    }

    
}
