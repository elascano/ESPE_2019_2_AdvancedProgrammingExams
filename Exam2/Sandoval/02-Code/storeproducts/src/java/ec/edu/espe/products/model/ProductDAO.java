/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.products.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
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
 * @author DenniseSandoval
 */
public class ProductDAO {
    DBConnect con;

    public ProductDAO() {
        con = new DBConnect();
    }
    public ArrayList<Product> getServices() throws IOException {
        ArrayList<Product> services = null;
        try {
            String url = "http://localhost:1024/storeproducts/store/products/showallproducts";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            Type tipoListaServicios = new TypeToken<List<Product>>() {
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
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return services;
    }
    public Product addProduct(Product objProduct) throws SQLException {
        Connection acceso = con.connect();
        String sql = "INSERT INTO products"
                + " (idproduct,nameproduct, typeproduct,quantity) values (?,?,?,?)";
        try {
            PreparedStatement state = acceso.prepareStatement(sql);
            state.setString(1, objProduct.getId());
            state.setString(2, objProduct.getName());
            state.setString(3, objProduct.getType());
            state.setInt(4, objProduct.getQuantity());
            state.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Product product = new Product(objProduct.getId(), objProduct.getName(), objProduct.getType(), objProduct.getQuantity());
        return product;
    }
    public ArrayList<Product> showAllProducts() throws SQLException {
        DBConnect connect = new DBConnect();
        String query;
        query = "SELECT * from products";
        PreparedStatement state = connect.connect().prepareStatement(query);
        ResultSet rs = state.executeQuery();
        Product tempProduct;
        ArrayList<Product> product = new ArrayList();
        while (rs.next()) {
            tempProduct = new Product(rs.getString("idproduct"), rs.getString("nameproduct"), rs.getString("typeproduct"), rs.getInt("quantity"));
            product.add(tempProduct);
        }
        return product;
    }
}
