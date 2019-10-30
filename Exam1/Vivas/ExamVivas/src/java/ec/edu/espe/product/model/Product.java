/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.product.model;

/**
 *
 * @author Santiago Vivas
 */
public class Product {
    private String idProduct;
    private String nameProduct;
    private String descriptionProduct;
    private int quantityStockProduct;
    private float priceProduct;

    public Product(String id, String name, String description, int quantityStock, float price) {
        this.idProduct = id;
        this.nameProduct = name;
        this.descriptionProduct = description;
        this.quantityStockProduct = quantityStock;
        this.priceProduct = price;
    }
    
    public Product() {
        
    }

    public String getId() {
        return idProduct;
    }

    public String getName() {
        return nameProduct;
    }

    public String getDescription() {
        return descriptionProduct;
    }

    public int getQuantityStock() {
        return quantityStockProduct;
    }

    public float getPrice() {
        return priceProduct;
    }

    public void setId(String id) {
        this.idProduct = id;
    }

    public void setName(String name) {
        this.nameProduct = name;
    }

    public void setDescription(String description) {
        this.descriptionProduct = description;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStockProduct = quantityStock;
    }

    public void setPrice(float price) {
        this.priceProduct = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + idProduct + ", name=" + nameProduct + ", description=" + descriptionProduct + ", quantityStock=" + quantityStockProduct + ", price=" + priceProduct + '}';
    }
    
    
}
