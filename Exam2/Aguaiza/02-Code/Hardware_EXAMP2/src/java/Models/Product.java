/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author diego
 */
public class Product {
    private int id_product;
    private String name_product;
    private String type_product;
    private int quantity_product;

    public Product() {
    }

    public Product(int id_product, String name_product, String type_product, int quantity_product) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.type_product = type_product;
        this.quantity_product = quantity_product;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getType_product() {
        return type_product;
    }

    public void setType_product(String type_product) {
        this.type_product = type_product;
    }

    public int getQuantity_product() {
        return quantity_product;
    }

    public void setQuantity_product(int quantity_product) {
        this.quantity_product = quantity_product;
    }
    
    
}
