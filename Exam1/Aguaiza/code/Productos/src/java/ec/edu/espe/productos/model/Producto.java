/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.productos.model;

/**
 *
 * @author henry
 */
public class Producto {
    
    private int idProduct;
    private String nameProduct;
    private int  stock;
    private float price;

    public Producto(int idProduct, String nameProduct, int stock, float price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.stock = stock;
        this.price = price;
    }

    public Producto() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
}
