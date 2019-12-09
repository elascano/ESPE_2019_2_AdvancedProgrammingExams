/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.hardware.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melissa
 */
public class ProductoDAO {
     Conexion con;

    public ProductoDAO() {
        con=new Conexion();
    }
    public void adicionarProducto(ProductoVO producto){
        Connection acceso = con.obtenerConexion();
        String sql="INSERT INTO producto (id,nombre,tipo,cantidad) VALUES(?,?,?,?)";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setInt(1, producto.getId());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getTipo());
            ps.setInt(4, producto.getCantidad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void setServices(ProductoVO transportista) throws IOException {
        
        try {
            String url = "http://localhost:8080/Cedeno_Carvajal/Hardware/Products/createProduct";
            
            Gson gson = new Gson();
            String JSON = gson.toJson(transportista);
            System.out.println(gson.toJson(transportista));
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(JSON);
            wr.flush();
            wr.close();
        
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            
            
            System.out.println("Response Body : ");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
      } catch (MalformedURLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    public ArrayList<ProductoVO> getServices() throws IOException {
        ArrayList<ProductoVO> services = null;
        try {
            String url = "http://localhost:8080/Cedeno_Carvajal/HardwareStore/Products";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            Type tipoListaServicios = new TypeToken<List<ProductoVO>>() {
            }.getType();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            services =new Gson().fromJson(response.toString(), tipoListaServicios);
      } catch (MalformedURLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return services;
    }
    
   
    public ArrayList<ProductoVO> mostrarProductos(){
        ArrayList <ProductoVO> listaB=new ArrayList <ProductoVO>();
        ProductoVO producto;
        
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from producto");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new ProductoVO();
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setTipo(rs.getString(3));
                producto.setCantidad(rs.getInt(4));
               listaB.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
}
