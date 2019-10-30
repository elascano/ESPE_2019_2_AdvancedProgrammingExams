/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.api.model;

/**
 *
 * @author Abi
 */
public class Product {
    
    private int id;
    private String name;
    private String description;
    private int quantityStock;
    private float price;

    public Product(int id, String name, String description, int quantityStock, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantityStock = quantityStock;
        this.price = price;
    }

    public Product() {
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public float getPrice() {
        return price;
    }
    
    
}
