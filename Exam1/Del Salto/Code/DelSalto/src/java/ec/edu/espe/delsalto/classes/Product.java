/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.delsalto.classes;

/**
 *
 * @author Windows 10
 */
public class Product {
    private int product_id;
    private int product_stock;
    private String product_name;

    public Product() {
    }

    
    
    public Product(int product_id, String product_name, String product_description,int product_stock, float product_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_stock = product_stock;
        this.product_price = product_price;
    }
    private String product_description;
    private float product_price;

    /**
     * @return the product_id
     */
    public int getProduct_id() {
        return product_id;
    }

    /**
     * @param product_id the product_id to set
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    /**
     * @return the product_stock
     */
    public int getProduct_stock() {
        return product_stock;
    }

    /**
     * @param product_stock the product_stock to set
     */
    public void setProduct_stock(int product_stock) {
        this.product_stock = product_stock;
    }

    /**
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * @return the product_description
     */
    public String getProduct_description() {
        return product_description;
    }

    /**
     * @param product_description the product_description to set
     */
    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    /**
     * @return the product_price
     */
    public float getProduct_price() {
        return product_price;
    }

    /**
     * @param product_price the product_price to set
     */
    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }
}
